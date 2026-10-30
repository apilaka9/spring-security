package com.pilaka.spring_security.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStreams {
    public static void main(String[] args) throws IOException {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
//        Set<Integer> set = new HashSet();
//    myList.stream().filter(n->!set.add(n))
//            .forEach(System.out::println);
//
//   myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
//        System.out.println(
//   myList.stream().max(Comparator.comparingInt(Integer::intValue)).get());
//;
//        String input = "Java articles are Awesome";
//
//        String value =input.trim()
//                        .chars()
//                                .mapToObj(c->(char)c)
//                                        .collect(Collectors.groupingBy(Function.identity(),
//                                                LinkedHashMap::new, Collectors.counting()))
//                                                .entrySet().stream().filter(entry->entry.getValue()==1)
//                        .map(entry->String.valueOf(entry.getKey()))
//                                .findFirst()
//                                        .get();
//        System.out.println(value);
        myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
//        myList.stream().sorted().forEach(System.out::println);
//        myList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        List<Integer> finalMyList = myList;
        //myList.stream().filter(n->Collections.frequency(finalMyList, n)>1)
            //    .collect(Collectors.toSet()).forEach(System.out::println);
//
//        int arr[] = { 99, 55, 203, 99, 4, 91 };
//        Arrays.parallelSort(arr);
//      Arrays.stream(arr).forEach(System.out::println);


        List<Integer> list = new ArrayList<>(
                Arrays.asList(10, 20, 30, 40, 50));
        list.stream().forEach(element->{
            if(element>43){
                list.remove(element);
            }
        });

    }
}
//Thread Pool Executor Manages Threads.
//Java Memory MOdel, Heap, Stack, Method are and native stack
//Heap and Stack are runtime memory models
//Denial of Service: limit connections, use gateways, Configure services
