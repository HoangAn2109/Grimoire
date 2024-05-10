package com.example.homescreen.models;

public class ChapModel {
    String chap_num;

    String chap_content;


    public ChapModel(String chap_num, String chap_content) {
        this.chap_content = chap_content;
        this.chap_num = chap_num;
    }


    public String getChap_num() {
        return chap_num;
    }

    public void setChap_num(String chap_num) {
        this.chap_num = chap_num;
    }

    public String getChap_content() {
        return chap_content;
    }

    public void setChap_content(String chap_content) {
        this.chap_content = chap_content;
    }
}
