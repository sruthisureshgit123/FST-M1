package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer,String> colours = new HashMap<>();
        colours.put(1,"Red");
        colours.put(2,"Green");
        colours.put(3,"Yellow");
        colours.put(4,"Blue");
        colours.put(5,"white");
        // print Map to console
        System.out.println("Map created is "+colours);
        //remove a colour
        colours.remove(4);
        System.out.println("Map after Removing color Blue is "+colours);
        //check if Green exist
        if(colours.containsValue("Green")){
            System.out.println("Green exist in the map");
        }
        else{
            System.out.println("Green does not exist in the map");
        }
        //Print size
        System.out.println("Size of the map is "+ colours.size());
    }
}
