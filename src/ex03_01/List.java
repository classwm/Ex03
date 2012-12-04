package ex03_01;

import java.util.LinkedList;

public class List extends LinkedList<Link> {

    /**
     * Wypisywanie listy.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista:");
        for (Link link : this) {
            sb.append(" ").append(link.getName());
        }
        return sb.toString();
    }
}
