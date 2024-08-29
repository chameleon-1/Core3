package task.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("шла");
        list.add("саша");
        list.add("по");
        list.add("шоссе");

        List<Integer> listInt = Arrays.asList(1, 3, 2, 3, 4, 2, 5, 4);



    }

    //Реализуйте функциональность согласно описанию

    // TODO1: Напишите метод, который принимает два числа от пользователя и использует функциональный интерфейс BinaryOperator
//  для сложения этих чисел и вывода результата. Используйте для решения лямбда выражение
    public static int toDo1(int t, int u) {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        int result = add.apply(t, u);
        System.out.println(result);
        return result;
    }

    // TODO2: Напишите метод, который принимает список слов от пользователя и использует функциональный интерфейс Predicate
//  для фильтрации слов, начинающихся с определенной буквы, и вывода отфильтрованного списка.Используйте для решения лямбда выражение
    public static void toDo2(List<String> list) {
        Predicate<String> startWith = str -> str.startsWith("ш");
        list.stream().filter(startWith).forEach(System.out::println);
    }

    // TODO3: Напишите метод, который принимает список чисел от пользователя и использует функциональный интерфейс Function
//  для преобразования каждого числа в его квадрат и вывода списка квадратов.Используйте для решения лямбда выражение
public static void toDo3 (List <Integer> list){
    list.stream().map((x)->x*x).forEach(System.out::println);
}

    // TODO4: Напишите метод, который принимает список строк от пользователя и использует функциональный интерфейс Consumer
//  для вывода каждой строки в верхнем регистре.Используйте для решения лямбда выражение
    public static void toDo4(List<String> list0) {
        Consumer<List<String>> upperCase = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> print = list -> list.stream().forEach(System.out::println);
        upperCase.andThen(print).accept(list0);
    }

    // TODO5: Найти сумму всех чисел в списке. Описание: Напишите программу, которая принимает список целых чисел в качестве
//  входных данных и вычисляет их сумму с использованием стримов.
    public static void toDo5(List<Integer> list) {
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    // TODO6: Найти среднее значение всех чисел в списке. Описание: Напишите программу, которая принимает список чисел в качестве
//  входных данных и вычисляет их среднее значение с использованием стримов.
    public static void toDo6(List<Integer> list) {
        double avrg = list.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(avrg);
    }

    // TODO7: Найти наибольшее число в списке. Описание: Напишите программу, которая принимает список чисел в качестве входных
//  данных и находит наибольшее число с использованием стримов.
    public static void toDo7(List<Integer> list) {
        int maxInt = list.stream().reduce(Integer::max).get();
        System.out.println(maxInt);
    }

    // TODO8: Найти наименьшее число в списке. Описание: Напишите программу, которая принимает список чисел в качестве входных
//  данных и находит наименьшее число с использованием стримов.
    public static void toDo8(List<Integer> list) {
        int minInt = list.stream().reduce(Integer::min).get();
        System.out.println(minInt);
    }

    // TODO9: Проверить, содержит ли список определенное значение. Описание: Напишите программу, которая принимает список
//  элементов и определенное значение в качестве входных данных и проверяет, содержит ли список это значение с использованием
//  стримов.
    public static void toDo9(List<Integer> list, Integer id) {
        System.out.println(list.stream().anyMatch(i -> i == id));
    }


    // TODO10: Удалить дубликаты из списка. Описание: Напишите программу, которая принимает список элементов в качестве входных
//  данных и удаляет все дубликаты, оставляя только уникальные элементы с использованием стримов.
    public static void toDo10(List<Integer> list) {
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
    }

    // TODO11: Преобразовать список строк в список их длин. Описание: Напишите программу, которая принимает список строк в
//  качестве входных данных и преобразует его в список их длин с использованием стримов.
    public static void toDo11(List<String> list) {
        System.out.println(list.stream().map(s -> s.length()).collect(Collectors.toList()));
    }

    // TODO12: Соединить все строки из списка в одну строку. Описание: Напишите программу, которая принимает список строк в
//  качестве входных данных и соединяет их все в одну строку с использованием стримов.
    public static void toDo12(List<String> list) {
        System.out.println(list.stream().collect(Collectors.joining(" ")));
    }

    // TODO13: Отфильтровать список чисел, оставив только четные числа. Описание: Напишите программу, которая принимает список
//  чисел в качестве входных данных и фильтрует его, оставляя только четные числа с использованием стримов.
    public static void toDo13(List<Integer> list) {
        System.out.println(list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));
    }
}