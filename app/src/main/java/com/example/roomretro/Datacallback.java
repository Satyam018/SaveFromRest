package com.example.roomretro;

import com.example.roomretro.model.Post;

import java.util.List;

import retrofit2.http.POST;

public interface Datacallback {


    void getdata(List<Post> posts);

    void getsaveddata(List<Post> posts);
}
