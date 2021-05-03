package ru.job4j.generics;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class GenericUsage {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add(new Person("name", 21, new Date(913716000000L)));
        System.out.println("Количество элементов в списке: " + list.size());
//        String s = (String) list.get(1);

//        for (int i = 0; i < list.size(); i++ ) {
//            String s  = (String) list.get(i);
//            System.out.println("Текущий элемент: " + s);
//        }

//        for(String s: list) {
//            System.out.println("Текущий элемент: " + s);
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printRsl(l);

        List<Person> person = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printInfo(person);

        List<Programmer> programmer = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new GenericUsage().printInfo(programmer);

        List<? super Integer> lst = new ArrayList<>();
        new GenericUsage().addAll(lst);

        GenericsClass<String, String> gen = new GenericsClass<>("First key", "First value");
        System.out.println("Вывод в консоль: " + gen);

        GenericsClass<Integer, String> second = new GenericsClass<>(12345, "Second value");
        System.out.println("Вывод в консоль: " + second);

        ArrayList<Float> listOfNumbers = new FloatList();
        Class actual = listOfNumbers.getClass();
        System.out.println(actual);
        Class sup = actual.getSuperclass();
        System.out.println(sup);
        ParameterizedType type = (ParameterizedType) actual.getGenericSuperclass();
        System.out.println(type);
        Class parameter = (Class) type.getActualTypeArguments()[0];
        System.out.println(parameter);
    }

    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println(next);
        }
    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        for (int i = 0; i <= 5; i++) {
            list.add(i);
        }

        for (Object o : list) {
            System.out.println("Текущий элемент: " + o);
        }
    }

    public static class FloatList extends ArrayList<Float> {
        public FloatList() {
            super();
        }
    }
}
