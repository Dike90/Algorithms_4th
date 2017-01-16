package Basement;

import java.util.Iterator;

/**
 * Created by DK on 2017/1/10.
 */
public class MyQueue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty() { return first == null;}
    public int size() { return N;}
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        N ++;
    }
    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
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
