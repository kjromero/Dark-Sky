package sky.dark.kenny.darksky.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sky.dark.kenny.darksky.model.ResponseData;

/**
 * Created by desarrollo-carlos on 12/07/17.
 */

public interface ApiInterface {

    @GET("{latitude},{longitude}")
    Call<ResponseData> getData(@Path("latitude") String latitude, @Path("longitude") String longitude);



}
