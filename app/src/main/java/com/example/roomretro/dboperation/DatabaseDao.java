package com.example.roomretro.dboperation;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomretro.model.Post;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
@Dao
public interface DatabaseDao {

    @Query("Select * FROM  table1")
    Observable<List<Post>> allgetdata();
    @Insert
    void insertdata(Post post);


}
