package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    private Entry<String> root;
    private LinkedList<Entry> list = new LinkedList<>();

    public CustomTree() {
        this.root = new Entry<>("element");
        list.add(root);
    }

    @Override
    public int size() {
        return 0;
    }

    public String getParent(String s) {
        return null;
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
    public void add(int index, String element) {
        for (Entry entry : list) {
            entry.isAvailableToAddChildren();
        }
    }
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}

