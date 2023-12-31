package se.lexicon;

import java.sql.Array;
import java.util.Arrays;

public class NameRepository {
    private static String[] names;

    public static void main(String[] args) {
        String[] nameArray = {"Anna Hjdfj", "Kalle Apefdn"};
        setNames(nameArray);

        add("Anna Panna");

//        String[] findLastNameArray = findByLastName("Panna");

        boolean updateCheck = update("Anna Panna", "Anna Panna" );
        System.out.println(Arrays.toString(names));
    }

    public static int getSize(String[] names) {
        return names.length;
    }

    public static void setNames(String[] strArray) {
        names = new String[getSize(strArray)];
        for (int i = 0; i < strArray.length; i++) {
            names[i] = strArray[i];
        }
    }

    public static void clear() {
        names=new String[]{};
    }

    public static String[] findAll(String[] strArray) {
        return Arrays.copyOf(strArray,strArray.length);

    }
    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equals(fullName)) {
                return name;
            }
        }
        return null;
    }
    public static boolean add(final String fullName){
        for(String name:names){
            if(name==fullName){
                System.out.println("Name already exists!!!");
                return false;
            }
        }
        String[] newArray=Arrays.copyOf(names,names.length+1);
        newArray[newArray.length-1]=fullName;
        clear();
        names=Arrays.copyOf(newArray,newArray.length);
        System.out.println("A new name added ");
        System.out.println("Array after added a name:");
        System.out.println(Arrays.toString(names));
        return true;
    }

    public static String[] findByFirstName(final String firstName) {
        String[] newNamesArray;
        int arrayLength = 0;
        String tmp;

        for (int i = 0; i < names.length; i++) {
            tmp = names[i].replaceAll("\\s.*", "");
            if (firstName.equals(tmp)) {
                arrayLength++;
            }
        }
        if (arrayLength > 0) {
            newNamesArray = new String[arrayLength];
            int index = 0;

            for (String name : names) {
                if (name.toLowerCase().contains(firstName.toLowerCase())) {
                    newNamesArray[index] = name;
                    index++;
                }
            }
            System.out.println("Returning new array of: ");
            System.out.println(Arrays.toString(newNamesArray));
            return newNamesArray;
        }
        System.out.println("No name found matching: " + firstName);

        return null;
    }

    public static String[] findByLastName(final String lastName) {
        String[] newNamesArray;
        int arrayLength = 0;
        String tmp;

        for (int i = 0; i < names.length; i++) {
            tmp = names[i].substring(names[i].indexOf(" ") + 1).trim();
            if (lastName.equals(tmp)) {
                arrayLength++;
            }
        }
        if (arrayLength > 0) {
            newNamesArray = new String[arrayLength];
            int index = 0;

            for (String name : names) {
                if (name.toLowerCase().contains(lastName.toLowerCase())) {
                    newNamesArray[index] = name;
                    index++;
                }
            }
            System.out.println("Returning new array of: ");
            System.out.println(Arrays.toString(newNamesArray));
            return newNamesArray;
        }
        System.out.println("No name found matching: " + lastName);

        return null;
    }

    public static boolean update(final String original, final String updatedName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(original)) {
                names[i] = updatedName;

                if (names[i].equalsIgnoreCase(updatedName)) {
                    System.out.println("The name \'" + original + "\' already exists in the array and have not been updated.");
                    return false;
                }

                System.out.println(original + " : has been updated to: " + updatedName);
                return true;
            }
        }
        System.out.println("The name \'" + original + "\' was not found in array.");
        return false;
    }

    public static boolean remove(final String fullName) {

        return true;
    }
}