package pe.edu.cibertec.retrofitgitflow.presentation.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.retrofitgitflow.R;
import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.main_interactor.MaininteractorImpl;
import pe.edu.cibertec.retrofitgitflow.netwok.JsonPlaceHolderApi;
import pe.edu.cibertec.retrofitgitflow.presentation.main.IMainContract;
import pe.edu.cibertec.retrofitgitflow.presentation.main.presenter.MainPresenter;
import pe.edu.cibertec.retrofitgitflow.presentation.view.PostDetailActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements IMainContract.IView {


    private TextView textViewResult;
    private RecyclerView recyclerViewPosts;
    private PostAdapter postAdapter;
    private List<Post> postList;
    private ProgressBar progressBar;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(new MaininteractorImpl());
        presenter.attachView(this);
        textViewResult = findViewById(R.id.textViewResult);
        progressBar = findViewById(R.id.progressBarMain);
        recyclerViewPosts = findViewById(R.id.recyclerViewPosts);
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));
        postList = new ArrayList<>();
        postAdapter = new PostAdapter(postList);

        postAdapter.setOnItemClickListener(new PostClickListener() {
            @Override
            public void onClick(int position) {
                gotToDetailPost(postList.get(position).getId());
            }
        });
        recyclerViewPosts.setAdapter(postAdapter);
        presenter.getAllPost();

    }


    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void getAllPostSuccess(List<Post> postList) {
        this.postList.addAll(postList);
        postAdapter.notifyDataSetChanged();
    }

    @Override
    public void gotToDetailPost(int postId) {
        Intent intent = new Intent(this, PostDetailActivity.class);
        intent.putExtra("post_id",postId);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        presenter.detactView();
        super.onDestroy();
    }

    @Override
    public void onDetachedFromWindow() {
        presenter.detactView();
        super.onDetachedFromWindow();
    }
}
