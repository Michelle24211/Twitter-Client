package com.codepath.apps.restclienttemplate;

public class User {
    public String name;
    public String profilepic;
    public String id;
    public User(String name, String profilepic, String id){
        this.name = name;
        this.profilepic = profilepic;
        this.id = "@" + id;
    }


}
