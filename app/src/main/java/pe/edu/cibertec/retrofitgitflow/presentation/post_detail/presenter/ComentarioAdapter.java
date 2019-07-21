package pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import pe.edu.cibertec.retrofitgitflow.R;

import pe.edu.cibertec.retrofitgitflow.data.entities.Comentarios;

public class ComentarioAdapter extends RecyclerView.Adapter<ComentarioAdapter.ComentarioViewHolder> {

    private List<Comentarios> commentList;

    public ComentarioAdapter(List<Comentarios> commentList) {
        this.commentList = commentList;
    }

    public class ComentarioViewHolder extends RecyclerView.ViewHolder{

        private TextView textEmail;
        private TextView textComment;

        public ComentarioViewHolder(@NonNull View itemView) {
            super(itemView);

            textEmail =(TextView)  itemView.findViewById(R.id.textEmail);
            textComment =(TextView)  itemView.findViewById(R.id.textComment);
        }
    }

    @Override
    public ComentarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new ComentarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentarioViewHolder holder, int position) {
        Comentarios comment = commentList.get(position);
        holder.textComment.setText(String.valueOf(comment.getComentario()));
        holder.textEmail.setText(String.valueOf(comment.getEmail()));
    }

    @Override
    public int getItemCount(){
        return commentList.size();
    }
}
