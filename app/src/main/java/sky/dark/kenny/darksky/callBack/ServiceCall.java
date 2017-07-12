package sky.dark.kenny.darksky.callBack;

import android.util.Log;

import retrofit2.Call;
import sky.dark.kenny.darksky.model.ResponseData;
import sky.dark.kenny.darksky.rest.ApiInterface;
import sky.dark.kenny.darksky.rest.RestClient;

/**
 * Created by desarrollo-carlos on 12/07/17.
 */

public class ServiceCall {

    public static void getData(String latitude, String longitude, final GetCallBack callback) {
        ApiInterface service = RestClient.getClient();
        Call<ResponseData> call = service.getData(latitude, longitude);

        call.enqueue(new retrofit2.Callback<ResponseData>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseData> call, retrofit2.Response<ResponseData> response) {
                Log.e("ServiceCall", "Status Code = " + response.code());
                if(response.body() == null){
                    ResponseData responseLogin = response.body();
                    callback.getCallback(responseLogin, false);
                }else{
                    ResponseData responseLogin = response.body();
                    callback.getCallback(responseLogin, true);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseData> call, Throwable t) {
                ResponseData responseLogin = null;
                callback.getCallback(responseLogin, false);
            }
        });
    }

}
