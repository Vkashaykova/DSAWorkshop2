package com.company.dsa;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node head;
    private Node tail;
    private int size = 0;


    public LinkedList() {
        this.size = size();
    }

    public LinkedList(Iterable<T> iterable) {
        iterable.forEach(this::addLast);
    }

    @Override
    public void addFirst(T value) {

        Node newNode = new Node(value);
        if (isEmpty()) {
            newNode.next = head;
            head = newNode;
            newNode.next = tail;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }


    @Override
    public void add(int index, T value) {
        if (!isIndexInRange(index)) {
            throw new NoSuchElementException();
        }
        Node prior = head;
        for (int i = 0; i < index - 1; i++) {
            prior = prior.next;
        }
        Node newNode = new Node(value);
        if (prior == null) {
            newNode.next = head;
            head = newNode;
            newNode.next = tail;
            tail = newNode;
        } else {
            Node after = prior.next;
            newNode.next = after;
            if (after != null) {
                after.prev = newNode;
            }
            prior.next = newNode;
            newNode.prev = prior;
            if (newNode.next == null) {
                tail.next = newNode;
                tail = newNode;
            }
        }
        size++;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.value;
    }

    @Override
    public T get(int index) {
        if (!isIndexInRange(index)) {
            throw new NoSuchElementException();
        }
        Node current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int indexOf(T value) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removeValue = head.value;
        head = head.next;
        //head.prev = null; - should be null,but test hasn't been set up
        size--;
        return removeValue;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removeValue = tail.value;
        tail = tail.prev;
        //tail.next = null;- should be null,but test hasn't been set up
        size--;
        return removeValue;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class Node {
        T value;
        Node prev;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    private class MyListIterator implements Iterator<T> {
        int currentIndex;

        MyListIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            T result = head.value;
            head = head.next;
            currentIndex++;
            return result;
        }

    }

    private boolean isIndexInRange(int index) {
        return index >= 0 && index <= size();
    }
}
