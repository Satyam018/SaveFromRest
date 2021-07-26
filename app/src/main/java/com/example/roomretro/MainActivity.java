package com.example.roomretro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.roomretro.adpater.Dataadapter;
import com.example.roomretro.model.Post;
import com.example.roomretro.networkoperation.networkmanager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Datacallback {
    Button callnetwork;
    networkmanager networkmanagers;
    RecyclerView recyclerView;
    Dataadapter dataadapters;
    List<Post>postLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callnetwork=(Button)findViewById(R.id.callnetwork);
        recyclerView=(RecyclerView)findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        networkmanagers=new networkmanager(MainActivity.this,this);

        postLists=new ArrayList<>();
        dataadapters=new Dataadapter(MainActivity.this,postLists,this);
        recyclerView.setAdapter(dataadapters);



        callnetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                networkmanagers.getdata();
            }
        });
    }

    @Override
    public void getdata(List<Post> posts) {
        int i=0;
        for (Post post:posts){
            postLists.add(post);
            i++;

        }
        dataadapters.notifyDataSetChanged();
        Toast.makeText(MainActivity.this,""+i,Toast.LENGTH_LONG).show();
    }

    @Override
    public void getsaveddata(List<Post> posts) {

    }
}