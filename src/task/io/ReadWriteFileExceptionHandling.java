package task.io;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class ReadWriteFileExceptionHandling {
    public static void main(String[] args) throws Exception {


//        toDo1("test.txt","����, ����� �����!!!");
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
toDo11("�������� ��� ���������");

    }

    // ���������� ���������������� �������� ��������

    // TODO1: �������� ���������, ������� ������� ����� ���� � ���������� � ���� ������, ������� ����������
    //  �������
    public static void toDo1(String name, String text) {
        try {                                                               //�������� �����
            File file = new File(name);
            if (file.createNewFile()) {
                System.out.println("���� ������");
            } else {
                System.out.println("���� ��� ����");
            }
        } catch (IOException e) {
            System.out.println("������ ��� �������� �����");
            e.printStackTrace();
        }

        try {                                                               //������ � ����
            FileWriter writer = new FileWriter(name);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println("������ ��� ������ � ����");
            e.printStackTrace();
        }
    }


    // TODO2: �������� ���������, � ������� ��� ������� ���������� �� ������� � ������� ����� � �� ������
    //  ���������� ������ ��������� ����

    public static void toDo2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("����� �������� �����: ");
        String s = scanner.nextLine();
        scanner.close();

        try {
            File file = new File(s);
            if (file.createNewFile()) {
            } else {
                System.out.println("���� ��� ����");
            }
        } catch (IOException e) {
            System.out.println("������ ��� �������� �����");
            e.printStackTrace();
        }
    }


    // TODO3: �������� �����, ������� ����� ��� ����� � ���������� ���������. ����������� ����������,
    //  ���� ������ ����� ����� ���� , ����������� ���(ArithmeticException) � �������� ���� ��������� �� ������ � �������
    //  "������� �� ���� ���������"
    public static void toDo3(int a, int b) {
        int c = 0;
        try {
            c = a / b;
            System.out.println(c);

        } catch (ArithmeticException e) {
            System.out.println("������� �� ���� ���������");
            e.printStackTrace();
        }

    }

    // TODO4: �������� ���������, ������� ��������� ����� � ���������� � ������� ��� �������. ���������
    //  ����������, ���� ������� �� �����
    public static void toDo4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("����� �����: ");
        try {
            int i = scanner.nextInt();
            scanner.close();
            System.out.println(i * i);
        } catch
        (InputMismatchException e) {
            System.out.println("��������� �����!!!");
            e.printStackTrace();
        }
    }

    // TODO5: �������� �����, ������� ������������ ���������� ����. ���������� ����� ��� ������ ����� ��
    //  �����. ��������� ����������, ���� �� ����� ������������ �������.
    static class Bank {
        int amount = 100;

        public void toDo5(int money) {
            try {
                if (amount < money) {
                    throw new Exception();
                } else {
                    System.out.println("��� ����");
                }
            } catch (Exception e) {
                System.out.println("��� ������, ������");
            }
        }
    }


    // TODO6: �������� ���������, ������� ��������� ������ �� ����� � ������� �� �� �����. �����������
    //  ����������, ���� ���� �� ������.

    public static void toDo6(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                System.out.println(stringBuilder.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("���� �� ������");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO7: �������� �����, ������� ����������� ������ � �����. ����������� ����������, ���� ������ ��
    //  ����� ���� ������������� � �����.
    public static void toDo7(String s) {
        try {
            Integer number = Integer.parseInt(s);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("����� �����, � �� �����");
            e.printStackTrace();
        }
    }

    // TODO8: ���������� �����, ������� ������������ ������ ���������. ���������� ����� ��� ����������
    //  �������� � ������. ��������� ����������, ���� ������ ��� �������� �������� � ����� �� ������.
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
                System.out.println(new Exception("����� ��� ����"));
            }
            else {
                list.add(new Student(name0));
                System.out.println("������� ��������");
            }
        }
    }


    // TODO9:�������� ��������� ������� ��������� � ������� ��� �������� ����� ���� �� ������ � ������������ ����������, ���� ������� ������������ ������:
    //  � ������� � ������� �������� ������ , � ������ ������ ���� �� ����� ������ , ����� ��������� ������ � �������� ��������� �� ���� � �������

    public static void toDo9() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("����� ������ �����: ");
            int i1 = scanner.nextInt();
            System.out.print("����� ������ �����: ");
            int i2 = scanner.nextInt();
            scanner.close();
            int i0 = i1 / i2;
            System.out.println("��������� �������: " + i0);
        } catch (InputMismatchException e) {
            System.out.println("������� ����� ������");
        } catch (ArithmeticException e) {
            System.out.println("������� �� ���� ���������");
        }
    }
    // TODO10: �������� �����, ������� ������������ ����������. ���������� ����� ��� ������� ���������.
    //  ��������� ����������, ���� ��������� ��� �������.

    static class Car {
        static boolean isRun = false;

        public static void toDo10() {
            if (isRun != true) {
                isRun = true;
                System.out.println("��������� �������");
            } else {
                System.out.println(new Exception("��������� ��� �������"));
            }


        }
    }



// TODO: �������� ���������, ������� ������� ���� �� ������, ������� �������� �������, � �����
//  ��������� ������ ����� �� �����

    //�������: ������� ����, � �������� ������ ����� �� ������� ����� ������?


public static void toDo11(String text) {
        String [] split = text.split(" ");                           //�������� ������ �� ��������
        String nameFile = split[0];                                         //������ �������
    try {                                                               //�������� �����
        File file = new File(nameFile);
        if (file.createNewFile()) {
            System.out.println("���� ������: " + nameFile+".txt");
        } else {
            System.out.println("���� ��� ����");
        }
    } catch (IOException e) {
        System.out.println("������ ��� �������� �����");
        e.printStackTrace();
    }

    try {                                                               //������ � ����
        FileWriter writer = new FileWriter(nameFile+".txt");
        writer.write(text);
        writer.close();
    } catch (IOException e) {
        System.out.println("������ ��� ������ � ����");
        e.printStackTrace();
    }
}


}
