package ru.job4j.generics;

public class User extends Base {

    private final String userName;

    public User(String id, String userName) {
        super(id);
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" + "userName='" + userName + '\'' + '}';
    }
}
