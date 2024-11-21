package com.example.laba17;

import android.app.Application;

public class MyApp extends Application {
    private String str1;
    private String str2;

    public MyApp(){
        super();
        str1 = "111";
        str2 = "222";
    }
    public void setStr1(String newStr){
        str1 = newStr;
    }
    public void setStr2(String newStr){
        str2 = newStr;
    }

    public String getStr1() {
        return str1;
    }

    public String getStr2() {
        return str2;
    }
}
