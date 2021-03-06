package Basement;

import java.util.Iterator;

/**
 * Created by DK on 2017/1/10.
 */
public class MyBag<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty() { return first == null;}
    public int size() { return  N;}
    public void add(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N ++ ;
    }

    public Iterator<Item> iterator()
    {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() { return current != null;}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
