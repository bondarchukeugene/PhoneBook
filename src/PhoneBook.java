import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        //Добавить считывание ввода пользователя в цикле
        boolean continueToWork = true;
        while (continueToWork) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Give mne a name");
            String name = scanner.nextLine();
            Boolean isNameCorrect = PhoneBook.checkName(name);
            System.out.println(isNameCorrect);
            continueToWork = false;
        }
    }


    public static boolean checkName(String name) {
        int length = name.trim().split(" ").length;
        return length == 3;
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return true;
    }

    public static String formatName(String name) {
        return "";
    }

    public static String formatPhoneNumber(String number) {
        return "";
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
//        test changces


    }
}

