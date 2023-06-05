package com.spring.demo.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Optional学习类
 */
public class OptionalDemo {


    public static boolean isNull(Object o) {
        Optional<Object> optional = Optional.of(o);
        final boolean present = optional.isPresent();
        System.out.println(present);

        List<Map> maps = new ArrayList<>();
        maps.add(null);

        return present;
    }
}