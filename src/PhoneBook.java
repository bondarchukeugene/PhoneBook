import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class PhoneBook {

    public static void main(String[] args) {
        //Добавить считывание ввода пользователя в цикле
        ArrayList<ArrayList<String>> phoneBook = new ArrayList<ArrayList<String>>();
        boolean continueToWork = true;
        while (continueToWork) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please add command: new (add new entry), print (print all book), exit");
            String userInputCommand = scanner.nextLine();
            switch (userInputCommand) {
                case "new":
                    System.out.println("Type name");
                    String userInputName = scanner.nextLine();

                    System.out.println("Type phone number");
                    String userInputNumber = scanner.nextLine();
                    PhoneBook.addNewEntry(phoneBook, userInputName, userInputNumber);
                    break;
                case "exit":
                    continueToWork = false;
                    break;
                case "print":
                    PhoneBook.printAllBook (phoneBook);
                    break;
                default:
                    System.out.println("Incorrect command");
            }
        }
    }

    private static void printAllBook(ArrayList<ArrayList<String>> phoneBook) {
        for (ArrayList<String> phoneBookEntry:phoneBook){
            System.out.println(Arrays.toString(phoneBookEntry.toArray()));

        }
    }

    private static boolean checkNumberbyName(ArrayList<ArrayList<String>> phoneBook, String name) {
        boolean isNameExist = false;
        for (ArrayList<String> phoneBookEntry : phoneBook) {
            if (phoneBookEntry.get(0) == name) {
                isNameExist = true;
            }

        }
        return isNameExist;
    }

    private static void getNumberbyName(ArrayList<ArrayList<String>> phoneBook, String name) {
        for (ArrayList<String> phoneBookEntry : phoneBook) {
            if (phoneBookEntry.get(0) == name) {
                System.out.println(phoneBookEntry.get(1));
            }

        }
    }

    private static void addNewEntry(ArrayList<ArrayList<String>> phoneBook, String name, String number) {
        ArrayList<String> phoneBookEntry = new ArrayList<>();
        phoneBookEntry.add(name);
        phoneBookEntry.add(number);
        phoneBook.add(phoneBookEntry);
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

