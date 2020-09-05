import java.util.Scanner;
import java.util.ArrayList;

public class PhoneBook {

    public static void main(String[] args) {
        //Добавить считывание ввода пользователя в цикле
        ArrayList<ArrayList<String>> phoneBook = new ArrayList<ArrayList<String>>();
        boolean continueToWork = true;
        while (continueToWork) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Give mne a name or type exit");
            String userInput = scanner.nextLine();
            if ("exit".equals(userInput)) {
                continueToWork = false;
            } else if (PhoneBook.checkName(userInput)) {
                System.out.println("Please add number");
                String nextUserInput = scanner.nextLine();
                if (checkPhoneNumber(nextUserInput)) {
                    ArrayList<String> phoneBookEntry = new ArrayList<>();
                    phoneBookEntry.add(userInput);
                    phoneBookEntry.add(nextUserInput);
                    phoneBook.add(phoneBookEntry);
                    System.out.println( phoneBook.get(0).get(1) );
                }
            } else {
                System.out.println("Name is incorrect, type exit or try again");
            }
        }
    }


    private static String[][] addNewEntry(String[][] phonebook, String name, String number) {
        String[][] newPhoneBook = new String[phonebook.length + 1][2];
        System.arraycopy(phonebook, 0, newPhoneBook, 0, phonebook.length);
        newPhoneBook[phonebook.length][0] = name;
        newPhoneBook[phonebook.length][1] = number;
        return newPhoneBook;

    }


    public static boolean checkName(String name) {
        return name instanceof String && PhoneBook.checkNameLength(name); //check if name is String and it has length of 3
    }

    private static boolean checkNameLength(String name) {
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

