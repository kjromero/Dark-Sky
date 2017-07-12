package sky.dark.kenny.darksky.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static ApiInterface apiInterface ;
    public static final String API_URL = "https://api.darksky.net/forecast/4b3fbd4679aa2ad9139106de224e4155/";

    public static ApiInterface getClient() {
        if (apiInterface == null) {


            Retrofit client = new retrofit2.Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInterface = client.create(ApiInterface.class);
        }
        return apiInterface ;
    }

}
