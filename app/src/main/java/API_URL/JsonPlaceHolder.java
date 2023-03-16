package API_URL;

import java.util.List;

import Model.DepositRequest;
import Model.EditUserModel;
import Model.User;
import Model.testModels;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolder {
    //test thoi dung xai
    @GET("posts")
    Call<List<testModels>> getPosts();

    //deposit url
    @GET("deposits/{id}")
    Call<List<DepositRequest>> getListDeposit(@Path(value = "id")String id);

    //user url
    @GET("users/{id}")
    Call<User> getUser(@Path(value = "id")String id);
    @POST("users/create")
    Call<User> createUser(@Body User user);
    @POST("users/update")
    Call<User> updateUser(@Body EditUserModel user);

    //post url


    //wish url


}
