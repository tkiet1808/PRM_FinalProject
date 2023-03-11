package APIServices;

import java.util.List;

import Model.DepositRequest;
import Model.DepositRequest;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolder {
    @GET("deposit")
    Call<List<DepositRequest>> getListDeposit();
}
