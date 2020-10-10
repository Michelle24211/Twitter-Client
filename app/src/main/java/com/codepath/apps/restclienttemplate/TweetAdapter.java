package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.MyViewHolder> {
    List<Tweet> list;
    public Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView userName;
        public TextView detail;
        public ImageView profileImage;
        public ImageView embedpic;
        public TextView time;
        public VideoView video;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            userName = itemView.findViewById(R.id.userName);
            detail = itemView.findViewById(R.id.detail);
            profileImage = itemView.findViewById(R.id.profileImage);
            time = itemView.findViewById(R.id.time);
            embedpic = itemView.findViewById(R.id.embedpic);
            video = itemView.findViewById(R.id.video);
        }

    }

    public TweetAdapter(List<Tweet> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(context).inflate(R.layout.tweets, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tweet tweet = list.get(position);
        holder.name.setText(tweet.user.name);
        holder.userName.setText(tweet.user.id);
        holder.detail.setText(tweet.description);
        holder.time.setText(tweet.time);
        if(tweet.background != null) {
                Glide.with(context).load(tweet.background).override(700).transform(new RoundedCorners(30)).into(holder.embedpic);
        }
        Glide.with(context).load(tweet.user.profilepic).transform(new RoundedCorners(30)).into(holder.profileImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



}
