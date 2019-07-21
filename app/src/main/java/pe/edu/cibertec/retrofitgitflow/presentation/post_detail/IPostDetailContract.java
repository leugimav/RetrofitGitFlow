package pe.edu.cibertec.retrofitgitflow.presentation.post_detail;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Comentarios;
import pe.edu.cibertec.retrofitgitflow.data.entities.Post;

public interface IPostDetailContract {
    interface IView{
        void showError(String errorMsg);
        void showProgressBar();
        void hideProgressBar();
        void getPostSuccess(Post post);
        void getCommentSuccess(List<Comentarios> commentList);
    }

    interface IPresenter{
        void attachView(IPostDetailContract.IView view);
        void detachView();
        boolean isViewAttached();
        void getPost(int posId);
        void getCommets(int postId);
    }
}
