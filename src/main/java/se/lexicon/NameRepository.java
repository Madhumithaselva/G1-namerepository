package se.lexicon;

import java.util.Arrays;

public class NameRepository {
    private static String[] names;

    public static void main(String[] args) {
        String[] nameArray = {"Anna Hjdfj", "Kalle Apefdn"};
        setNames(nameArray);

        add("Anna Panna");
        String[] namesFound = findByFirstName("Kalle");
        System.out.println(Arrays.toString(namesFound));

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
        String[] newArray= Arrays.copyOf(strArray,strArray.length);
        return newArray;

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
            if (firstName.equals(names[i])) {
                arrayLength++;
            }

        }
        return null;
    }
}