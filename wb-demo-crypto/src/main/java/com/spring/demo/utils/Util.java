package com.spring.demo.utils;

public class Util {


    public static String byteToHex(byte[] b) {
        if (b == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        } else {
            StringBuilder hs = new StringBuilder();
            String stmp = "";

            for (byte value : b) {
                stmp = Integer.toHexString(value & 255);
                if (stmp.length() == 1) {
                    hs.append("0").append(stmp);
                } else {
                    hs.append(stmp);
                }
            }

            return hs.toString().toUpperCase();
        }
    }

    public static void main(String[] args) {
        byte[] data = new byte[]{0x12, 0x34, 0x56, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF};
        System.out.println(byteToHex(data));
    }
}