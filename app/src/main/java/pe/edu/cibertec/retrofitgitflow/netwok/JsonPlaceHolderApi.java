package pe.edu.cibertec.retrofitgitflow.netwok;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Comentarios;
import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPostDetail(@Path("id") int postId);

    @GET("/comments")
    Call<List<Comentarios>> getCommets(@Query("postId") int postId);

}
