package com.codepath.apps.restclienttemplate;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;

import org.parceler.Parcels;


public class TweetDetailActivity extends AppCompatActivity {

    Tweet tweet;
    TextView name;
    TextView userName;
    TextView description;
    ImageView image;
    TextView time;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweets);
        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));
        name = findViewById(R.id.name);
        userName = findViewById(R.id.userName);
        description = findViewById(R.id.detail);
        image = findViewById(R.id.profileImage);
        time = findViewById(R.id.time);

        //name.setText(tweet.user.name);
        //userName.setText(tweet.user.id);
        description.setText(tweet.description);
        //Glide.with(this).load(tweet.user.profilepic).into(image);
        time.setText(tweet.time);

        if(tweet.background != null){
            final ImageView embedded = findViewById(R.id.embedpic);
            Glide.with(this).asBitmap().load(tweet.background).override(50,50).into(new BitmapImageViewTarget(embedded) {
                @Override
                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                    super.onResourceReady(resource, transition);
                    embedded.setImageBitmap(resource);
                    embedded.setZ(1); //This is important
                }
            });
        }
        Log.i("newFrame", "sjkfhksfakfhjdk");
    }
}
