package ru.job4j.iterator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

//    private static class Func implements Function<List<Integer>, Stream<Integer>> {
//        @Override
//        public Stream<Integer> apply(List<Integer> e) {
//            return e.stream();
//        }
//    }

    public static void main(String[] args) {

        List<List<Integer>> data = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
//        List flat = data.stream()
//                .flatMap(Stream::of)
//                .collect(Collectors.toList());

//        Stream<List<Integer>> str = data.stream();
//        Stream<Integer> strI = str.flatMap(e -> e.stream());
//        List<Integer> flat = strI.collect(Collectors.toList());

//        Func func = new Func();
//        Stream<List<Integer>> str = data.stream();
//        Stream<Integer> strI = str.flatMap(func.apply());
//        List<Integer> flat = strI.collect(Collectors.toList());

        Stream<List<Integer>> str = data.stream();
        Stream<Integer> strI = str.flatMap(List::stream);
        List<Integer> flat = strI.collect(Collectors.toList());

//        flat.forEach(System.out::println);
        System.out.println(flat);
    }
}
