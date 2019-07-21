package pe.edu.cibertec.retrofitgitflow.data.entities;

import com.google.gson.annotations.SerializedName;

public class Comentarios {

    private int id;
    private String email;
    @SerializedName("body")
    private String comentario;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
