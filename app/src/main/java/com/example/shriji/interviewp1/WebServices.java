package com.example.shriji.interviewp1;

import com.example.shriji.interviewp1.models.SiteModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface WebServices {

    //http://www.mocky.io/v2/5acba6cb2f000049004116fb
    String BASE_URL = "http://www.mocky.io/";
    String FEED = "v2/5acba6cb2f000049004116fb";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET(FEED)
    Call<SiteModel> model();

}
