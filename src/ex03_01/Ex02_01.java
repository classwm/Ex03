package ex03_01;

import java.util.Collections;

public class Ex02_01 {

    public static void main(String[] args) {
        List list = new List();
        //list.insert("kota", list.getFirst());
        Link link = new Link("kota");
        list.addFirst(link);
        System.out.println(list);
        //list.insert("ma", list.getFirst());
        Link link2 = new Link("ma");
        list.addFirst(link2);
        System.out.println(list);
        //list.insert("ala", list.getFirst());
        Link link3 = new Link("ala");
        list.addFirst(link3);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println("Wyraz 'kota'" + (list.contains(link) ? "" : " nie") + " istnieje.");
        
        list.remove(link2);
        System.out.println(list);

        System.out.println("Wyraz 'ma'" + (list.contains(link2) ? "" : " nie") + " istnieje.");

        //list.deleteNext(list.getFirst());
        // list.getFirst();
        list.removeFirst();
        System.out.println(list);
        
    }   
    
}
