package com.example.myapplication.api;


import com.example.myapplication.model.ProductSaleRequest;
import com.example.myapplication.model.StatisticRequest;
import com.example.myapplication.response.ListEntityStatusResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    //base link:http://....:9999/
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

//    WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
//    String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());


    ApiService apiservice = new Retrofit.Builder().baseUrl("http://192.168.1.123:9999/").addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(ApiService.class);

    //statistic
    @GET("api/admin/statistic/product")
    Call<ListEntityStatusResponse<ProductSaleRequest>> getStatisticProduct(@Header("Authorization") String token);

    @GET("api/admin/statistic/year")
    Call<ListEntityStatusResponse<StatisticRequest>> getStatisticYear(@Header("Authorization") String token, @Query("year") String year);

    @GET("api/admin/statistic/date")
    Call<ListEntityStatusResponse<ProductSaleRequest>> getStatisticProductByDate(@Header("Authorization") String token, @Query("start") String start, @Query("end") String end);

}
