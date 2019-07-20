package pe.edu.cibertec.retrofitgitflow.presentation.main.presenter;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.main_interactor.IMaininteractor;
import pe.edu.cibertec.retrofitgitflow.presentation.main.IMainContract;

public class MainPresenter implements IMainContract.IPresenter {

    IMainContract.IView view;
    IMaininteractor interactor;

    public MainPresenter(IMaininteractor interactor)
    {
        this.interactor = interactor;
    }

    @Override
    public void attachView(IMainContract.IView view) {
        this.view = view;
    }

    @Override
    public void detactView() {
        view = null;
    }

    @Override
    public boolean isViewAttached() {
    return view!= null;
    }

    @Override
    public void getAllPost() {
        view.showProgressBar();
        //view.showError("GET ALL POST");
        interactor.getAllPost(new IMaininteractor.MainCallBack() {
            @Override
            public void onSuccess(List<Post> postList) {
                if(isViewAttached())
                {
                    view.getAllPostSuccess(postList);
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
