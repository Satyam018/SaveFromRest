package com.example.roomretro.dboperation;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomretro.model.Post;

@Database(entities = Post.class,version = 1)
public abstract class Databaserooms extends RoomDatabase {

    public abstract DatabaseDao getdatabasedao();



}
