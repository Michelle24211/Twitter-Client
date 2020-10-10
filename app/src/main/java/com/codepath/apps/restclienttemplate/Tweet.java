package com.codepath.apps.restclienttemplate;

import android.util.Log;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    public User user;
    public String description;
    public String time;
    public String background;
    public String type;
    public long id;


    public static Tweet fromJson(JSONObject json) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.description = json.getString("text");
        tweet.time = TimeFormatter.getTimeDifference(json.getString("created_at"));
        JSONObject u = json.getJSONObject("user");
        tweet.user = new User(u.getString("name"), u.getString("profile_image_url_https"), u.getString("screen_name"));
        if(json.has("entities") && json.getJSONObject("entities").has("media")){
            JSONArray back = json.getJSONObject("entities").getJSONArray("media");

            tweet.background = back.getJSONObject(0).getString("media_url_https");
            tweet.type = back.getJSONObject(0).getString("type");
            Log.i("type", back.getJSONObject(0).getString("type"));
        }
        else
            tweet.background = null;
        tweet.id = json.getLong("id");
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray json) throws JSONException {
        List<Tweet> list = new ArrayList<>();
        for(int i = 0; i < json.length(); i++){
            list.add(fromJson(json.getJSONObject(i)));
        }
        return list;
    }

}
