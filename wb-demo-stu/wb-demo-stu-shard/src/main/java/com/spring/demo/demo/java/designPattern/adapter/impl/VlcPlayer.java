package com.spring.demo.demo.java.designPattern.adapter.impl;

import com.spring.demo.demo.java.designPattern.adapter.AdvancedMediaPlayer;

public class VlcPlayer implements AdvancedMediaPlayer {


    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}