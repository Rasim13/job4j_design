package ru.job4j.generics;

public final class RoleStore implements Store<Role> {

    private final Store<Role> role = new MemStore<>();

    @Override
    public void add(Role model) {
        role.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return role.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return role.delete(id);
    }

    @Override
    public Role findById(String id) {
        return role.findById(id);
    }

    @Override
    public int size() {
        return role.size();
    }
}
