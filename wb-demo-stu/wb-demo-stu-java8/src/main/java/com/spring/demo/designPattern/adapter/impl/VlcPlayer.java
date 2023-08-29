package com.spring.demo.designPattern.adapter.impl;

import com.spring.demo.designPattern.adapter.AdvancedMediaPlayer;

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