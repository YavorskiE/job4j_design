package ru.job4j.generics;

public class Role extends Base {

    private final String baseName;

    public Role(String id, String baseName) {
        super(id);
        this.baseName = baseName;
    }

    @Override
    public String toString() {
        return "Role{" + "baseName='" + baseName + '\'' + '}';
    }
}
