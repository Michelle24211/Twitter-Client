package com.codepath.apps.restclienttemplate;

import org.parceler.Parcel;

@Parcel
public class User {
    public String name;
    public String profilepic;
    public String id;

    public User(){}
    public User(String name, String profilepic, String id){
        this.name = name;
        this.profilepic = profilepic;
        this.id = "@" + id;
    }


}
