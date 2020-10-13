package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.content.Intent;
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

import org.parceler.Parcels;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.MyViewHolder> {
    List<Tweet> list;
    public Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView userName;
        public TextView detail;
        public ImageView profileImage;
        public ImageView embedpic;
        public TextView time;
        public VideoView video;
        public MyViewHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            userName = itemView.findViewById(R.id.userName);
            detail = itemView.findViewById(R.id.detail);
            profileImage = itemView.findViewById(R.id.profileImage);
            time = itemView.findViewById(R.id.time);
            embedpic = itemView.findViewById(R.id.embedpic);
            video = itemView.findViewById(R.id.video);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            // make sure the position is valid, i.e. actually exists in the view
            if (position != RecyclerView.NO_POSITION) {
                Tweet tweet = list.get(position);
                Log.i("newFrame",Tweet.class.getSimpleName());
                Intent intent = new Intent(context, TweetDetailActivity.class);
                intent.putExtra(Tweet.class.getSimpleName(), Parcels.wrap(tweet));
                context.startActivity(intent);
            }
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
        //holder.name.setText(tweet.user.name);
        //holder.userName.setText(tweet.user.id);
        holder.detail.setText(tweet.description);
        holder.time.setText(tweet.time);
        if(tweet.background != null) {
                Glide.with(context).load(tweet.background).override(700).transform(new RoundedCorners(30)).into(holder.embedpic);
        }
       // Glide.with(context).load(tweet.user.profilepic).transform(new RoundedCorners(30)).into(holder.profileImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



}
