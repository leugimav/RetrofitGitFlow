package pe.edu.cibertec.retrofitgitflow.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import pe.edu.cibertec.retrofitgitflow.R;
import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.post_detail_iteractor.PostDetailIteractor;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.IPostDetailContract;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter.PostPresenter;

public class PostDetailActivity extends AppCompatActivity implements IPostDetailContract.IView{
PostPresenter presenter;
    TextView idTextView;
    TextView userIdTextView;
    TextView userIdTextView2;
    TextView userIdTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        IdTextView = findViewById(R.id.idTextView);
        userIdTextView = findViewById(R.id.userIdTextView);
        int id = getIntent().getIntExtra("post_id",-1);
        if(id == -1)
        {
            showError("No nos llegó el postId");
            finish();
        }
        presenter = new PostPresenter(new PostDetailIteractor());
        presenter.attachView(this);
        presenter.getPost(id);
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void getPostSuccess(Post post) {
        idTextView.setText(String.valueOf(post.getId()));
        userIdTextView.setText(String.valueOf(post.getUserId());

    }


}
