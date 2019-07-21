package pe.edu.cibertec.retrofitgitflow.domain.comment_interactor;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Comentarios;
import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.netwok.ApiClient;
import pe.edu.cibertec.retrofitgitflow.netwok.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostCommentIteractor implements IPostCommentIteractor {
    @Override
    public void getCommentsOfPost(int PostId, PostCommentCallback callback) {

        JsonPlaceHolderApi jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);
        Call<List<Comentarios>> call = jsonPlaceHolderApi.getCommets(PostId);

        call.enqueue(new Callback<List<Comentarios>>() {
            @Override
            public void onResponse(Call<List<Comentarios>> call, Response<List<Comentarios>> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
                else {
                    callback.onError("Code :" + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Comentarios>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    }

