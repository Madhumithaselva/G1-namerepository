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
        String stringFound=find("Anna");
        System.out.println(stringFound);

        boolean value=add("abcd");
        value=add("abcd");
        value=add("xyz");
        if (value) {
            System.out.println("A new name added ");
            System.out.println("Array after added a name:");
            System.out.println(Arrays.toString(names));
        }
        else {
            System.out.println("Name already exists!!!");
        }
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
                return false;
            }
        }
        String[] newArray=Arrays.copyOf(names,names.length+1);
        newArray[newArray.length-1]=fullName;
        clear();
        names=Arrays.copyOf(newArray,newArray.length);
       //System.out.println(Arrays.toString(newArray));
        return true;
    }
}
