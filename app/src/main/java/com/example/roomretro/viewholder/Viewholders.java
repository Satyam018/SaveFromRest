package com.example.roomretro.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomretro.R;

import org.jetbrains.annotations.NotNull;

public class Viewholders extends RecyclerView.ViewHolder {
    public TextView title,body;

    public Viewholders(@NonNull @NotNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.title);
        body=itemView.findViewById(R.id.body);
    }
}
