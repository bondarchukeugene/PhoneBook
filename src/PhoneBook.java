import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

// + метод для форматирования первых букв имени

public class PhoneBook {

    public static void main(String[] args) {
        //Добавить считывание ввода пользователя в цикле
        ArrayList<ArrayList<String>> phoneBook = new ArrayList<ArrayList<String>>();
        boolean continueToWork = true;
        while (continueToWork) {
            Scanner scanner = new Scanner(System.in);
            PhoneBook.printIntro();
            String userInputCommand = scanner.nextLine();
            switch (userInputCommand) {
                case "NEW":
                    System.out.println("Type name");
                    String userInputName = scanner.nextLine();
                    if (checkNameFormat(userInputName)) {
                        String userInputNameFormated = PhoneBook.formatName (userInputName);
                        if (PhoneBook.checkNameExistance(phoneBook, userInputName)) {
                            String number = PhoneBook.getNumberbyName(phoneBook,userInputName);
                            String text = "This name is already in the list. Number is:%s";
                            String formatedText = String.format(text,number);
                            System.out.println(formatedText);
                        } else {
                            System.out.println("Type phone number");
                            String userInputNumber = scanner.nextLine();
                            PhoneBook.addNewEntry(phoneBook, userInputName, userInputNumber);
                        }
                    } else {
                        System.out.println("Incorrect name");
                    }
                    break;
                case "EXIT":
                    continueToWork = false;
                    break;
                case "PRINT":
                    PhoneBook.printAllBook(phoneBook);
                    break;
                case "HELP":
                    PhoneBook.printAllCommands();
                    break;
                default:
                    System.out.println("Incorrect command");
            }
        }
    }

    private static String formatName(String name) {
        String [] nameDivided =name.trim().split(" ");
        String nameFormated = "";
        for (String namePart : nameDivided){
            String nameTemp = namePart.substring(0,1).toUpperCase() + namePart.substring(1).toLowerCase()+" ";
            nameFormated += nameTemp;
        }
        return nameFormated;
    }

    private static boolean checkNameExistance(ArrayList<ArrayList<String>> phoneBook, String name) {
        boolean isNameExist = false;
        for (ArrayList<String> phoneBookEntry : phoneBook) {
            if (phoneBookEntry.get(0).equals(name)) {
                isNameExist = true;
            }

        }
        return isNameExist;
    }


    private static String getNumberbyName(ArrayList<ArrayList<String>> phoneBook, String name) {

        String number = "";
        for (ArrayList<String> phoneBookEntry : phoneBook) {
            if (phoneBookEntry.get(0).equals(name)) {
                number = phoneBookEntry.get(1);
            }

        }
        return number;
    }

    private static void printAllCommands() {
        System.out.println("NEW to add new entry");
        System.out.println("PRINT to print all entries in the book");
        System.out.println("FIND NAME to find number by name");
        System.out.println("EXIT for exit");
    }

    private static void printIntro() {
        System.out.println("Please type command (type HELP to show a list of all commands)");

    }

    private static void printAllBook(ArrayList<ArrayList<String>> phoneBook) {
        for (ArrayList<String> phoneBookEntry : phoneBook) {
            String name = phoneBookEntry.get(0);
            String number = phoneBookEntry.get(1);
            System.out.println(name+":"+number);

        }
    }

    private static void addNewEntry(ArrayList<ArrayList<String>> phoneBook, String name, String number) {
        ArrayList<String> phoneBookEntry = new ArrayList<>();
        phoneBookEntry.add(name);
        String formatedNumber = PhoneBook.formatPhoneNumber(number);
        phoneBookEntry.add(formatedNumber);
        phoneBook.add(phoneBookEntry);
    }


    public static boolean checkNameFormat(String name) {
        return name instanceof String && PhoneBook.checkNameLength(name); //check if name is String and it has length of 3
    }

    private static boolean checkNameLength(String name) {
        int length = name.trim().split(" ").length;
        return length == 3;
    }

    public static String formatPhoneNumber(String number) {
        number = number.replaceAll("[\\D+]", "");
        number = number.substring(number.length() - 10);
        String code = number.substring(0, 3);
        String first = number.substring(3, 6);
        String second = number.substring(6, 8);
        String third = number.substring(8);
        return String.format("8 %s %s %s %s", code, first, second, third);
    }


}

