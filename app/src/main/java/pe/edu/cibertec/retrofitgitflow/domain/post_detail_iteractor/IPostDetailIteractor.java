package pe.edu.cibertec.retrofitgitflow.domain.post_detail_iteractor;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.presentation.view.PostDetailActivity;

public interface IPostDetailIteractor {

    interface PostDetailCallback{
        //void onSuccess(List<Post> postList);
        void onSuccess(Post post);
        void onError(String errMsg);
        //void onSuccesPostComment(List<Comment> comments);
    }
/*
    interface PostDetailCommentCallBack
    {
        //void onSucces(List<Comment> comments);
        void onError(String errMsg);
    }
    */
    void getPost(int PostId, PostDetailCallback callback);
   // void getCommentsOfPost(int posId,PostDetailCallback callback);
}
