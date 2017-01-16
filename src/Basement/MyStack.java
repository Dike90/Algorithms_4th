package Basement;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by DK on 2017/1/10.
 */
public class MyStack<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty() { return first == null;}
    public int size() { return  N;}
    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N ++ ;
    }
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N --;
        return item;
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
