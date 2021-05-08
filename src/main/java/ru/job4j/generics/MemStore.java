package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    public final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        if (findById(model.getId()) != null) {
            throw new IllegalArgumentException("ID duplicated");
        }
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).getId().equals(id)) {
                mem.set(index, model);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).getId().equals(id)) {
                mem.remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (T element : mem) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MemStore<User> mem = new MemStore<>();
        mem.add(new User("First", "1"));
        mem.add(new User("Second", "2"));
        mem.add(new User("Third", "3"));
        mem.add(new User("Fourth", "4"));
//        mem.add(new User("Second", "22"));
        mem.replace("Second", new User("Second", "22"));
        mem.delete("Third");

        System.out.println(mem.findById("First"));
        System.out.println(mem.findById("Second"));
        System.out.println(mem.findById("Third"));
        System.out.println(mem.findById("Fourth"));
        }
}
