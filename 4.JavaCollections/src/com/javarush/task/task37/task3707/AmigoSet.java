package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        final double floor = Math.ceil(collection.size() / .75f);
        final int max = (int) Math.max(16, floor);
        map = new HashMap<>(max);
        this.addAll(collection);
    }


    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public void clear() {
        map.clear();
    }

    public boolean remove(Object o) {
        return map.remove(o).equals(PRESENT);
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError();
        }   
    }

    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
            oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
            oos.writeObject(map.size());
            for (E e : map.keySet()) {
                oos.writeObject(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            int cap = (int) ois.readObject();
            float lf = (float) ois.readObject();
            map = new HashMap<>(cap, lf);
            int mapSize = (int) ois.readObject();
            for (int i = 0; i < mapSize; i++) {
                map.put((E) ois.readObject(), PRESENT);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
