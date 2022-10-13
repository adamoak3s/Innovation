package com.example.innovation4;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by pethoalpar on 4/16/2016.
 */
public class HttpCall {

    public static final int GET = 1;
    public static final int POST = 2;

    private String url;
    private int methodtype;
    private String id;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataString() {
        //Eric, simply change the command & add and "id" field and grab the id value from the class field =)
        //can hard-code in the command, receiver & cid for now
        Log.e("HttpCall", "id is: " + id);
        return "{\"command\":\"get_stb_notification\",\"receiver\":\"XTJ191170439614\",\"cid\":65535}";
    }
}