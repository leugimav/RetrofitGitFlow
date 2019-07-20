package pe.edu.cibertec.retrofitgitflow.domain.post_detail_iteractor;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.netwok.ApiClient;
import pe.edu.cibertec.retrofitgitflow.netwok.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetailIteractor implements IPostDetailIteractor{

    @Override
    public void getPost(int postId, PostDetailCallback callback) {
        JsonPlaceHolderApi jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);
        Call<Post> call = jsonPlaceHolderApi.getPostDetail(postId);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
                else {
                    callback.onError("Code :" + response.code());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                    callback.onError(t.getMessage());
            }
        });

    }
}
