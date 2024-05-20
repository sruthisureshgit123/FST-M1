package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("apple");
        myList.add("orange");
        myList.add("mango");
        myList.add("lemon");
        myList.add("grape");

        System.out.println("Elements in the List are ");

        for (String fruit : myList) {
            System.out.println(fruit);
        }
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is grape is in list: " + myList.contains("grape"));
        System.out.println("Size of the Arraylist is" + myList.size());
        myList.remove("lemon");
        System.out.println("Size of the Arraylist after removing an element is " + myList.size());

    }
}