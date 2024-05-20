package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hset1= new HashSet<> ();
        hset1.add ("A");
        hset1.add ("B");
        hset1.add ("C");
        hset1.add ("D");
        hset1.add ("E");
        hset1.add ("F");

        System.out.println("Size of the hash set is "+hset1.size());
        hset1.remove("C");
        hset1.remove("X");
        System.out.println("Verif if B is present "+hset1.contains("B"));
        System.out.println("Elements in the set are ");
        for (String s : hset1){
            System.out.println(s);
        }

    }
}
