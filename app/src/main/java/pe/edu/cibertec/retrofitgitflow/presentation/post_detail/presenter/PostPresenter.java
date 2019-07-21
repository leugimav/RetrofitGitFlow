package pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.post_detail_iteractor.IPostDetailIteractor;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.IPostDetailContract;

public class PostPresenter implements IPostDetailContract.IPresenter {
    IPostDetailContract.IView view;
    IPostDetailIteractor interactor;

    public PostPresenter(IPostDetailIteractor interactor)

    {
        this.interactor = interactor;
    }


    @Override
    public void attachView(IPostDetailContract.IView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public boolean isViewAttached() {
        return false;
    }

    @Override
    public void getPost(int posId) {
            view.showProgressBar();
        interactor.getPost(posId, new IPostDetailIteractor.PostDetailCallback() {
            @Override
            public void onSuccess(Post post) {
                if(isViewAttached()) {
                    view.getPostSuccess(post);
                    view.hideProgressBar();
                }
            }

            @Override
            public void onError(String errMsg) {
                if(isViewAttached()) {
                    view.showError(errMsg);
                    view.hideProgressBar();
                }
            }
        });
    }
}
