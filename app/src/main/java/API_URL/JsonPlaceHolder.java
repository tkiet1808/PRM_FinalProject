package API_URL;

import Model.PostFormRequest;
import Model.PostRequest;

import java.util.List;

import Model.Category;
import Model.DepositRequest;
import Model.EditUserModel;
import Model.LoginRequest;
import Model.Post;
import Model.PostList;
import Model.RegisterRequest;
import Model.StatusResponse;
import Model.User;
import Model.Wish;
import Model.WishRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonPlaceHolder {
    //test thoi dung xai
//    @GET("posts")
//    Call<List<testModels>> getPosts();

    //deposit url
    @GET("deposits/{id}")
    Call<List<DepositRequest>> getListDeposit(@Path(value = "id")String id);

    //user url
    @GET("users/{id}")
    Call<User> getUser(@Path(value = "id")String id);
    @POST("users/create")
    Call<User> register(@Body RegisterRequest registerForm);
    @PUT("users/update")
    Call<User> updateUser(@Body EditUserModel user);
    @POST("users/login")
    Call<User> login(@Body LoginRequest loginForm);

    //post url
    @GET("posts")
    Call<List<PostList>> getListPost();
    @GET("posts/{id}")
    Call<List<PostList>> getMyPost(@Path(value = "id")String id);
    @GET("posts/details/{id}")
    Call<Post> getPostDetails(@Path(value = "id")String id);
    @POST("posts/create")
    Call<StatusResponse> createPost(@Body PostFormRequest postFormRequest);
    @PUT("posts/update")
    Call<StatusResponse> updatePost(@Body PostFormRequest postFormRequest);

    //wish url
    @GET("wishes/{id}")
    Call<List<Wish>> getWishList(@Path(value = "id")String id);
    @POST("wishes/create")
    Call<StatusResponse> createWish(@Body WishRequest wishRequest);

    @HTTP(method = "DELETE", path = "wishes/delete", hasBody = true)
    Call<StatusResponse> deleteWish(@Body WishRequest wishRequest);

    @GET("categories")
    Call<List<Category>> getCategories();

}
