package task.io;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class ReadWriteFileExceptionHandling {
    public static void main(String[] args) throws Exception {


//        toDo1("test.txt","Саня, верни сотку!!!");
//        toDo2();
//        toDo3(5,0);
//        toDo4();

//        Bank bank = new Bank();
//        bank.toDo5(500);

//        toDo6("test.txt");
//        toDo7("g;jn");

        Student st1 = new Student("lupa");
        Student st2 = new Student("pupa");
        List<Student> list1 = new ArrayList<>();
        list1.add(st1);
        list1.add(st2);
//        Student.todo8(list1, "pupa");


//
//        Car car = new Car();
//        car.toDo10();
//        car.toDo10();
toDo11("тестирую эту программу");

    }

    // Реализуйте функциональность согласно описанию

    // TODO1: Напишите программу, которая создает новый файл и записывает в него данные, которые передаются
    //  строкой
    public static void toDo1(String name, String text) {
        try {                                                               //создание файла
            File file = new File(name);
            if (file.createNewFile()) {
                System.out.println("файл создан");
            } else {
                System.out.println("файл уже есть");
            }
        } catch (IOException e) {
            System.out.println("ошибка при создании файла");
            e.printStackTrace();
        }

        try {                                                               //запись в файл
            FileWriter writer = new FileWriter(name);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println("ошибка при записи в файл");
            e.printStackTrace();
        }
    }


    // TODO2: Напишите программу, в которой при запуске приложения вы вводите в консоль текст и на основе
    //  введенного текста создается файл

    public static void toDo2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введи название файла: ");
        String s = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(s);
            if (file.createNewFile()) {
            } else {
                System.out.println("файл уже есть");
            }
        } catch (IOException e) {
            System.out.println("ошибка при создании файла");
            e.printStackTrace();
        }
    }


    // TODO3: Создайте метод, который делит два числа и возвращает результат. Обработайте исключение,
    //  если второе число равно нулю , перехватите его(ArithmeticException) и выведите свое сообщение об ошибке с текстом
    //  "Деление на ноль запрещено"
    public static void toDo3(int a, int b) {
        int c = 0;
        try {
            c = a / b;
            System.out.println(c);

        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль запрещено");
            e.printStackTrace();
        }

    }

    // TODO4: Напишите программу, которая считывает число с клавиатуры и выводит его квадрат. Выбросите
    //  исключение, если введено не число
    public static void toDo4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введи число: ");
        try {
            int i = scanner.nextInt();
            scanner.close();
            System.out.println(i * i);
        } catch
        (InputMismatchException e) {
            System.out.println("используй цифры!!!");
            e.printStackTrace();
        }
    }

    // TODO5: Создайте класс, который представляет банковский счет. Реализуйте метод для снятия денег со
    //  счета. Выбросите исключение, если на счете недостаточно средств.
    static class Bank {
        int amount = 100;

        public void toDo5(int money) {
            try {
                if (amount < money) {
                    throw new Exception();
                } else {
                    System.out.println("кэш снят");
                }
            } catch (Exception e) {
                System.out.println("иди отсюда, бичара");
            }
        }
    }


    // TODO6: Напишите программу, которая считывает данные из файла и выводит их на экран. Обработайте
    //  исключение, если файл не найден.

    public static void toDo6(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                System.out.println(stringBuilder.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO7: Создайте метод, который преобразует строку в число. Обработайте исключение, если строка не
    //  может быть преобразована в число.
    public static void toDo7(String s) {
        try {
            Integer number = Integer.parseInt(s);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("введи число, а не слово");
            e.printStackTrace();
        }
    }

    // TODO8: Реализуйте класс, который представляет список студентов. Реализуйте метод для добавления
    //  студента в список. Выбросите исключение, если список уже содержит студента с таким же именем.
    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public static void todo8(List<Student> list, String name0) {
            int i11 = 0;
            for (int i = 0; i < list.size(); i++) {
                for (Student s : list) {
                    if (s.name == name0) {
                        i11++;
                    }
                }
            }
            if (i11>0){
                System.out.println(new Exception("такое имя есть"));
            }
            else {
                list.add(new Student(name0));
                System.out.println("студент добавлен");
            }
        }
    }


    // TODO9:Напишите программу который принимает с консоли два значения делит одно на другое и обрабатывает исключение, если введены некорректные данные:
    //  к примеру с консоли передали строки , а строки делить друг на друга нельзя , тогда выбросите ошибку и напишите сообщение об этом в консоль

    public static void toDo9() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("введи первое число: ");
            int i1 = scanner.nextInt();
            System.out.print("введи второе число: ");
            int i2 = scanner.nextInt();
            scanner.close();
            int i0 = i1 / i2;
            System.out.println("результат деления: " + i0);
        } catch (InputMismatchException e) {
            System.out.println("вводить слова нельзя");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль запрещено");
        }
    }
    // TODO10: Создайте класс, который представляет автомобиль. Реализуйте метод для запуска двигателя.
    //  Выбросить исключение, если двигатель уже запущен.

    static class Car {
        static boolean isRun = false;

        public static void toDo10() {
            if (isRun != true) {
                isRun = true;
                System.out.println("двигатель запущен");
            } else {
                System.out.println(new Exception("двигатель уже запущен"));
            }


        }
    }



// TODO: Напишите программу, которая создает файл из текста, который подается строкой, а потом
//  считывает первое слово из файла

    //задание: создать файл, у которого первое слово из тексста будет именем?


public static void toDo11(String text) {
        String [] split = text.split(" ");                           //разделяю строку на элементы
        String nameFile = split[0];                                         //первый элемент
    try {                                                               //создание файла
        File file = new File(nameFile);
        if (file.createNewFile()) {
            System.out.println("файл создан: " + nameFile+".txt");
        } else {
            System.out.println("файл уже есть");
        }
    } catch (IOException e) {
        System.out.println("ошибка при создании файла");
        e.printStackTrace();
    }

    try {                                                               //запись в файл
        FileWriter writer = new FileWriter(nameFile+".txt");
        writer.write(text);
        writer.close();
    } catch (IOException e) {
        System.out.println("ошибка при записи в файл");
        e.printStackTrace();
    }
}


}
