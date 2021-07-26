package com.example.roomretro.networkoperation;

import com.example.roomretro.model.Post;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Network {

    @GET("/posts")
    Observable<List<Post>> getpost();



}
