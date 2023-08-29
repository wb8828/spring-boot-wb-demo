package com.spring.demo;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream流
 */
public class StreamDemo {

    /**
     * 创建流
     */
    public void creatStream() {
        // 1.通过 java.util.Collection.stream() 方法用集合创建流
        List<String> list = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<String> stream = list.stream();
        // 创建一个并行流
        Stream<String> parallelStream = list.parallelStream();

        // 2.使用java.util.Arrays.stream(T[] array)方法用数组创建流
        int[] array={1,3,5,6,8};
        IntStream stream1 = Arrays.stream(array);

        // 3.使用Stream的静态方法：of()、iterate()、generate()

        Stream<Integer> stream30 = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream31 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream31.forEach(System.out::println);

        Stream<Double> stream34 = Stream.generate(Math::random).limit(3);
        stream34.forEach(System.out::println);
    }
}