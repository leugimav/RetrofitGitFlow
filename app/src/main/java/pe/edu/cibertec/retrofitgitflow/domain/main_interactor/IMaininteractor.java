package pe.edu.cibertec.retrofitgitflow.domain.main_interactor;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;

public interface IMaininteractor {

    interface MainCallBack{
        void onSuccess(List<Post> postList);
        void onError(String errMsg);
    }

    void getAllPost(MainCallBack callBack);

}
