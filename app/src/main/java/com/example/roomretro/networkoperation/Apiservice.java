package com.example.roomretro.networkoperation;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiservice {
  static   String baseurl="https://jsonplaceholder.typicode.com/";

    public static Retrofit getretrofit(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Network callservice(){

        Network network=Apiservice.getretrofit().create(Network.class);

        return network;

    }
}
