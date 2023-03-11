package APIServices;

import java.util.List;

import Model.DepositRequest;
import Model.DepositRequest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolder {
    @GET("deposit/{id}")
    Call<List<DepositRequest>> getListDeposit(@Path(value = "id")String id);
}
