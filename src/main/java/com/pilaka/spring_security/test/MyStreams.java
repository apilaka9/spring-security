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
//List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        System.out.println( numbers.stream().reduce(0,(a,b)->a+b));
//        System.out.println(numbers.stream().reduce(1,(a,b)->a*b));
//        System.out.println(numbers.stream().mapToInt(Integer::intValue).average());
//        System.out.println(numbers.stream().max(Comparator.comparing(Integer::intValue)));
//        System.out.println(numbers.stream().reduce((a,b)->b));
//int number=13456;
//        int sum =String.valueOf(number).chars().map(Character::getNumericValue).sum();
//        System.out.println();
//        int factorial = IntStream.rangeClosed(1,5).reduce(1, (a,b)->a*b);
//        System.out.println(factorial);
//String value="jello";
//        System.out.println(   value.chars().mapToObj(c->String.valueOf((char)c)).reduce("",(a,b)->b+a));
//List<String> fruits = List.of("apple", "banana", "apple", "orange", "banana", "apple");
//        System.out.println(       fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
//                        .stream()
//                        .max(Map.Entry.comparingByValue())
//                                .map(Map.Entry::getValue)
//                        .orElse(null)
//
//                );
//
//            String input = "madam";
//            boolean isPalindrome =IntStream.rangeClosed(0, input.length()/2)
//                    .allMatch(i->input.charAt(i)==input.charAt(input.length()-1-i));
//            System.out.println(isPalindrome);
//
//            List<String> words = List.of("listen", "silent", "enlist", "google", "inlets");
//            String target = "silent";
//            List<String> anagrams=words.stream().filter(word->Arrays.equals(
//                    word.chars().sorted().toArray(),
//                    target.chars().sorted().toArray()
//            ))
//                    .collect(Collectors.toList());
//
////            Stream.iterate(new int[] {0,1}, fib->new int[]{fib[1], fib[0]+fib[1]}).limit(10)
////                    .map(fib->fib[0])
////                    .forEach(System.out::println);
//
//             Stream.iterate(new int[]{0,1}, fib->new int[] {fib[1], fib[0]+fib[1]}).limit(10).forEach(System.out::println);
//        Stream.generate(()->new Random().nextInt(100)).limit(10)
//                .collect(Collectors.toList()).forEach(System.out::println);
//
//            List<List<Integer>> listOfLists = List.of(
//                    List.of(1, 2, 3),
//                    List.of(4, 5, 6),
//                    List.of(7, 8, 9)
//            );
//
//            listOfLists.stream()
//                    .flatMap(List::stream)
//                    .collect(Collectors.toList())
//                    .forEach(System.out::println);

            List<String> words = List.of("madam", "racecar", "apple", "banana", "level");
   words.stream().filter(word->word.equals(new StringBuilder(word).reverse().toString()))
           .max(Comparator.comparingInt(String::length)).orElse(null);

            String input = "hello world this is a test";
            System.out.println(Arrays.asList(input.split(" ")).stream()
                    .max(Comparator.comparingInt(String::length))
                    .orElse(null));

            Path path = Paths.get("C:\\Users\\apila\\OneDrive\\Documents\\MyDocs\\Anant\\Resumes\\meena.txt");
         long charCount=   Files.lines(path)
                    .flatMapToInt(String::chars).count();
            System.out.println(charCount);
            charCount=Files.lines(path).flatMap(line->Arrays.stream(line.split(" "))).count();
            System.out.println(charCount);





//100
            List<Integer> list1 = List.of(1, 2, 3, 4);
            List<Integer> list2 = List.of(3, 4, 5, 6);
            List<Integer> intersection =list1.parallelStream()
                    .filter(list2::contains)
                    .collect(Collectors.toList());
            List<Integer> merged =Stream.concat(list1.stream(),list2.stream())
                    .collect(Collectors.toList());

        words.stream().collect(Collectors.groupingByConcurrent(word->word, Collectors.counting()));



    }
}
