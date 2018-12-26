package com.uet.mysong2018.domain.model;

import java.io.Serializable;

public class ItemSongModel implements Serializable {

    private String nameSong;
    private String nameSinger;
    private String time;
    private String nameImage;
    private String nameSongRaw;

    public ItemSongModel(String nameSong, String nameSinger, String time, String nameImage, String nameSongRaw){
        this.nameSong = nameSong;
        this.nameImage = nameImage;
        this.nameSinger = nameSinger;
        this.time = time;
        this.nameSongRaw = nameSongRaw;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }
}
