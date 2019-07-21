package pe.edu.cibertec.retrofitgitflow.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.retrofitgitflow.R;
import pe.edu.cibertec.retrofitgitflow.data.entities.Comentarios;
import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.comment_interactor.PostCommentIteractor;
import pe.edu.cibertec.retrofitgitflow.domain.post_detail_iteractor.PostDetailIteractor;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.IPostDetailContract;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter.ComentarioAdapter;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter.PostPresenter;

public class PostDetailActivity extends AppCompatActivity implements IPostDetailContract.IView{
    PostPresenter presenter;
    TextView idTextView;
    TextView userIdTextView;
    TextView titleTextView;
    TextView bodyTextView;
    ProgressBar progressBar;

    RecyclerView Comment;
    ComentarioAdapter commentAdapter;
     List<Comentarios> commentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        idTextView = findViewById(R.id.idTextView);
        userIdTextView = findViewById(R.id.userIdTextView);
        titleTextView = findViewById(R.id.titleTextView);
        bodyTextView = findViewById(R.id.bodyTextView);
        progressBar = findViewById(R.id.progressBar);

        Comment =findViewById(R.id.recyclerViewComment);

        presenter = new PostPresenter(new PostDetailIteractor(),new PostCommentIteractor());
        presenter.attachView(this);

        commentAdapter = new ComentarioAdapter(commentList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        Comment.setLayoutManager(mLayoutManager);
        Comment.setAdapter(commentAdapter);

        int id = getIntent().getIntExtra("post_id",-1);

        if(id == -1)
        {
            showError("No nos llegó el postId");
            finish();
        }
        presenter.getPost(id);
        presenter.getCommets(id);
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
      //  progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        //progressBar.setVisibility(View.GONE);
    }

    @Override
    public void getPostSuccess(Post post) {
        idTextView.setText(String.valueOf(post.getId()));
        userIdTextView.setText(String.valueOf(post.getUserId()));
        titleTextView.setText(post.getTitle());
        bodyTextView.setText(post.getText());
    }

    @Override
    public void getCommentSuccess(List<Comentarios> commentList) {
        this.commentList.addAll(commentList);
        commentAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        presenter.detachView();
    }
}
