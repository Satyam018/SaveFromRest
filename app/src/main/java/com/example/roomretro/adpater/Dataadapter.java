package com.example.roomretro.adpater;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomretro.Datacallback;
import com.example.roomretro.R;
import com.example.roomretro.dboperation.Dbmanager;
import com.example.roomretro.model.Post;
import com.example.roomretro.viewholder.Viewholders;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Dataadapter extends RecyclerView.Adapter<Viewholders> {
    private static final String TAG = "TAG";
    Context context;
    List<Post> postList;
    Datacallback datacallback;

    public Dataadapter(Context context, List<Post> postList,Datacallback datacallback) {
        this.context = context;
        this.postList = postList;
        this.datacallback=datacallback;
    }

    @NonNull
    @NotNull
    @Override
    public Viewholders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new Viewholders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Viewholders holder, int position) {
        Post temp=postList.get(position);
        holder.title.setText(temp.getTitle());
        holder.body.setText(temp.getBody());

        holder.body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                savedata(temp);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
    private void savedata(Post post){
        Log.e(TAG, "savedata: "+"savedata" );

        Dbmanager dbmanager=new Dbmanager(context,datacallback);
        dbmanager.insertdata(post);
    }
}
