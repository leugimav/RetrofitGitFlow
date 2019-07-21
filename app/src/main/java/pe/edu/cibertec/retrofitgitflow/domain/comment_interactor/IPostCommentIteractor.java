package pe.edu.cibertec.retrofitgitflow.domain.comment_interactor;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Comentarios;
import pe.edu.cibertec.retrofitgitflow.domain.post_detail_iteractor.IPostDetailIteractor;

public interface IPostCommentIteractor {

    interface PostCommentCallback{
         void onSuccess(List<Comentarios> postList);
         void onError(String errMsg);

    }

    void getCommentsOfPost(int PostId, PostCommentCallback callback);
}
