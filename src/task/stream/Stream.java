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
        list.add("���");
        list.add("����");
        list.add("��");
        list.add("�����");

        List<Integer> listInt = Arrays.asList(1, 3, 2, 3, 4, 2, 5, 4);



    }

    //���������� ���������������� �������� ��������

    // TODO1: �������� �����, ������� ��������� ��� ����� �� ������������ � ���������� �������������� ��������� BinaryOperator
//  ��� �������� ���� ����� � ������ ����������. ����������� ��� ������� ������ ���������
    public static int toDo1(int t, int u) {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        int result = add.apply(t, u);
        System.out.println(result);
        return result;
    }

    // TODO2: �������� �����, ������� ��������� ������ ���� �� ������������ � ���������� �������������� ��������� Predicate
//  ��� ���������� ����, ������������ � ������������ �����, � ������ ���������������� ������.����������� ��� ������� ������ ���������
    public static void toDo2(List<String> list) {
        Predicate<String> startWith = str -> str.startsWith("�");
        list.stream().filter(startWith).forEach(System.out::println);
    }

    // TODO3: �������� �����, ������� ��������� ������ ����� �� ������������ � ���������� �������������� ��������� Function
//  ��� �������������� ������� ����� � ��� ������� � ������ ������ ���������.����������� ��� ������� ������ ���������
public static void toDo3 (List <Integer> list){
    list.stream().map((x)->x*x).forEach(System.out::println);
}

    // TODO4: �������� �����, ������� ��������� ������ ����� �� ������������ � ���������� �������������� ��������� Consumer
//  ��� ������ ������ ������ � ������� ��������.����������� ��� ������� ������ ���������
    public static void toDo4(List<String> list0) {
        Consumer<List<String>> upperCase = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> print = list -> list.stream().forEach(System.out::println);
        upperCase.andThen(print).accept(list0);
    }

    // TODO5: ����� ����� ���� ����� � ������. ��������: �������� ���������, ������� ��������� ������ ����� ����� � ��������
//  ������� ������ � ��������� �� ����� � �������������� �������.
    public static void toDo5(List<Integer> list) {
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    // TODO6: ����� ������� �������� ���� ����� � ������. ��������: �������� ���������, ������� ��������� ������ ����� � ��������
//  ������� ������ � ��������� �� ������� �������� � �������������� �������.
    public static void toDo6(List<Integer> list) {
        double avrg = list.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(avrg);
    }

    // TODO7: ����� ���������� ����� � ������. ��������: �������� ���������, ������� ��������� ������ ����� � �������� �������
//  ������ � ������� ���������� ����� � �������������� �������.
    public static void toDo7(List<Integer> list) {
        int maxInt = list.stream().reduce(Integer::max).get();
        System.out.println(maxInt);
    }

    // TODO8: ����� ���������� ����� � ������. ��������: �������� ���������, ������� ��������� ������ ����� � �������� �������
//  ������ � ������� ���������� ����� � �������������� �������.
    public static void toDo8(List<Integer> list) {
        int minInt = list.stream().reduce(Integer::min).get();
        System.out.println(minInt);
    }

    // TODO9: ���������, �������� �� ������ ������������ ��������. ��������: �������� ���������, ������� ��������� ������
//  ��������� � ������������ �������� � �������� ������� ������ � ���������, �������� �� ������ ��� �������� � ��������������
//  �������.
    public static void toDo9(List<Integer> list, Integer id) {
        System.out.println(list.stream().anyMatch(i -> i == id));
    }


    // TODO10: ������� ��������� �� ������. ��������: �������� ���������, ������� ��������� ������ ��������� � �������� �������
//  ������ � ������� ��� ���������, �������� ������ ���������� �������� � �������������� �������.
    public static void toDo10(List<Integer> list) {
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
    }

    // TODO11: ������������� ������ ����� � ������ �� ����. ��������: �������� ���������, ������� ��������� ������ ����� �
//  �������� ������� ������ � ����������� ��� � ������ �� ���� � �������������� �������.
    public static void toDo11(List<String> list) {
        System.out.println(list.stream().map(s -> s.length()).collect(Collectors.toList()));
    }

    // TODO12: ��������� ��� ������ �� ������ � ���� ������. ��������: �������� ���������, ������� ��������� ������ ����� �
//  �������� ������� ������ � ��������� �� ��� � ���� ������ � �������������� �������.
    public static void toDo12(List<String> list) {
        System.out.println(list.stream().collect(Collectors.joining(" ")));
    }

    // TODO13: ������������� ������ �����, ������� ������ ������ �����. ��������: �������� ���������, ������� ��������� ������
//  ����� � �������� ������� ������ � ��������� ���, �������� ������ ������ ����� � �������������� �������.
    public static void toDo13(List<Integer> list) {
        System.out.println(list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));
    }
}