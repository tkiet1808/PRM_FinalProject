package Model;

import com.google.gson.annotations.SerializedName;

public class testModels {
    private int userId;
    private int id;
    private String tittle;

    @SerializedName("body")
    private String text;

    public testModels() {
    }

    public testModels(int userId, int id, String tittle, String text) {
        this.userId = userId;
        this.id = id;
        this.tittle = tittle;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
