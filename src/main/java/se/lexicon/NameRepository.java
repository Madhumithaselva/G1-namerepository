package se.lexicon;

import java.util.Arrays;

public class NameRepository {
    private static String[] names;

    public static void main(String[] args) {
        String[] nameArray = {"Anna", "Kalle"};
        setNames(nameArray);
        int size = getSize(names);
        System.out.println(size);
        //clear();
        nameArray=findAll(names);
        System.out.println("Copied Array:");
        System.out.println(Arrays.toString(nameArray));
    }

    public static int getSize(String[] names) {
        return names.length;
    }

    public static void setNames(String[] strArray) {
        names = new String[getSize(strArray)];
        // System.out.println(strArray.length);
        for (int i = 0; i < strArray.length; i++) {
            names[i] = strArray[i];
            System.out.println(names[i]);
        }
    }

    public static void clear() {
        names=new String[]{};
        System.out.println(names.length);
    }

   public static String[] findAll(String[] strArray) {
       String[] newArray= Arrays.copyOf(strArray,strArray.length);
       return newArray;

    }
}
