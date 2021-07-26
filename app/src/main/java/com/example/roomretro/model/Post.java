package com.example.roomretro.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
@Entity(tableName = "table1")
public class Post {

    @ColumnInfo(name = "userid")
    @SerializedName("userId")
    String userid;

    @PrimaryKey
    int id;
    @ColumnInfo(name = "title")
    String title;


    @ColumnInfo(name = "body")
    String body;

    public Post(String userid, int id, String title, String body) {
        this.userid = userid;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getUserid() {
        return userid;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
