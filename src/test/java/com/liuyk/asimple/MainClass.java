package com.liuyk.asimple;


import java.util.*;
import java.util.stream.IntStream;

public class MainClass {

    public static void main(String[] args) {
        List<Integer> a = Collections.synchronizedList(new ArrayList<>());
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        IntStream.range(0, 1000000).parallel().forEach(
                o -> {
                    set.add(Thread.currentThread().getName());
                }
        );
        System.out.println("---------------" + set + "," + Runtime.getRuntime().availableProcessors());
    }

}
