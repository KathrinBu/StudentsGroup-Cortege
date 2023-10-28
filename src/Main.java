

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        start();
        Scanner scanner=new Scanner(System.in);
        Cortege cortege= readFromFile();
        selection(scanner, cortege);
    }

    private static void start() {
        System.out.println("1. Список студентов (ФИО)" + "\n" +
        "2. Список студентов которые сдали все экзамены только на пять" + "\n" +
        "3. Список студентов которые имеют хотя-бы одну тройку по экзаменам" + "\n" +
        "4. Список студентов у которых есть двойки" + "\n" +
        "(если студент имеет больше одной двойки он исключается из списка)" + "\n" +
        "--- Введите 'q' для выхода ---" + "\n" +
        "Пожалуйста сделайте свой выбор:");
    }

    public static Cortege readFromFile() throws IOException {
        List<String> names= new ArrayList<>();
        List<String> firstNum= new ArrayList<>();
        List<String> secondNum= new ArrayList<>();
        List<String> thirdNum= new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String name = parts[0] + " " + parts[1];
            names.add(name);
            int number1 = Integer.parseInt(parts[2]);
            firstNum.add(String.valueOf(number1));
            int number2 = Integer.parseInt(parts[3]);
            secondNum.add(String.valueOf(number2));
            int number3 = Integer.parseInt(parts[4]);
            thirdNum.add(String.valueOf(number3));
        }
        Cortege cortege=new Cortege(names, firstNum, secondNum, thirdNum);
        return cortege;
    }

    public static void selection(Scanner scanner, Cortege cortege){
        while (scanner.hasNext()) {
            String order=scanner.next();
            if (order.equals("1")) {
                List<String> combinedList1 = cortege.getList1();
                System.out.println("Список студентов: " + combinedList1);
            }
            if (order.equals("2")) {
                lookingForExcellent(cortege);
            }
            if (order.equals("3")) {
                findCStudents(cortege);
            }
            if (order.equals("4")) {
                poorStudents(cortege);
            }
            if (order.equals("q")) {
                System.out.println("программа завершена");
                break;
            }
        }
    }

    private static void poorStudents(Cortege cortege) {
        List<String> combinedList1 = cortege.getList1();
        List<String> combinedList2 = cortege.getList2();
        List<String> combinedList3 = cortege.getList3();
        List<String> combinedList4 = cortege.getList4();
        int n=-1;
        for (int i = 0; i < combinedList1.size(); i++) {
            if (combinedList2.get(i).equals("2") || combinedList3.get(i).equals("2") || combinedList4.get(i).equals("2")) {
                if ((combinedList2.get(i).equals("2") && combinedList3.get(i).equals("2")) ||
                        (combinedList2.get(i).equals("2") && combinedList4.get(i).equals("2")) ||
                        (combinedList3.get(i).equals("2") && combinedList4.get(i).equals("2"))) {
                    System.out.println(")) студент имеет больше одной двойки -- " + combinedList1.get(i));
                    combinedList1.remove(i);
                    combinedList2.remove(i);
                    combinedList3.remove(i);
                    combinedList4.remove(i);
                } else {
                    n = i;
                    System.out.println(combinedList1.get(i));
                }
            }
        }
            if (n==-1){
                System.out.println("!! нет двоечников !!");
            }
        }

    private static void findCStudents(Cortege cortege) {
        List<String> combinedList1 = cortege.getList1();
        List<String> combinedList2 = cortege.getList2();
        List<String> combinedList3 = cortege.getList3();
        List<String> combinedList4 = cortege.getList4();
        int n=-1;
        for (int i = 0; i < combinedList1.size(); i++) {
            if (combinedList2.get(i).equals("3") || combinedList3.get(i).equals("3") || combinedList4.get(i).equals("3")) {
                n=i;
                System.out.println(combinedList1.get(i));
            }
        }
        if (n == -1){
            System.out.println("== нет троечников ==");
        }
    }

    private static void lookingForExcellent(Cortege cortege) {
        List<String> combinedList1 = cortege.getList1();
        List<String> combinedList2 = cortege.getList2();
        List<String> combinedList3 = cortege.getList3();
        List<String> combinedList4 = cortege.getList4();
        int n=-1;
        for (int i = 0; i < combinedList1.size(); i++) {
            if (combinedList2.get(i).equals("5") && combinedList3.get(i).equals("5") && combinedList4.get(i).equals("5")) {
                n = i;
                System.out.println(combinedList1.get(i));
            }
        }
        if (n == -1){
                System.out.println("== отличники отсутствуют ==");
            }
        }
}


