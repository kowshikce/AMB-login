package com.example.amblogin.service;

import com.example.amblogin.UserPostRequest.AmbulanceResponseModel;
import com.example.amblogin.constant.Constant;
import com.example.amblogin.models.SignupResp;
import com.example.amblogin.models.UserLoginRequest;
import com.example.amblogin.models.UserLoginResposnse;
import com.example.amblogin.ui.response.model.DriverCommentModel;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class ApiService {

    public static final String URL = "http://192.168.1.104:3000";


    private ApiService(){

    }

    private static Mainservice mainservice = null;
    public static Mainservice getMainservice(){
        if(mainservice == null){

            Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
            mainservice = retrofit.create(Mainservice.class);
        }
        return mainservice;
    }
    public interface Mainservice{
        @POST("/api/app/v1/login")
        Call<UserLoginResposnse> getlogin(@Body UserLoginRequest userLoginRequest);

        @POST("/api/app/v1/register")
        @FormUrlEncoded
        Call<SignupResp> getSignUp(@FieldMap Map<String, String> params);

        @GET("/")
        Call<Resp> getResp();


        @POST("/api/request/create")
        @FormUrlEncoded
        Call<AmbulanceResponseModel> createAMBrequest(@Header("Authorization") String token, @FieldMap Map<String, String> params );

        @GET("/api/request/list")
        Call<List<DriverCommentModel>> getDrivers(@Header("Authorization")String token, @Query("receverid") String id);

    }
}
