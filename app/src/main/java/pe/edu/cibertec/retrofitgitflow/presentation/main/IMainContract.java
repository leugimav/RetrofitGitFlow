package pe.edu.cibertec.retrofitgitflow.presentation.main;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;

public interface IMainContract {
    interface IView
    {
        void showError(String errorMsg);
        void showProgressBar();
        void hideProgressBar();
        void getAllPostSuccess(List<Post> postList);
        void gotToDetailPost(int postId);

    }
    interface IPresenter
    {
        void attachView(IView view);
        void detactView();
        boolean isViewAttached();
        void getAllPost();
    }
}
