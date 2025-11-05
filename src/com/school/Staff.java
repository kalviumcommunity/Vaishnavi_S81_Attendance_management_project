

package com.school;

public class Staff extends Person implements Storable {
    private String role;

    public Staff(int id, String name, String role) {
        super(id, name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + role;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", name='" + name + "', role='" + role + "'}";
    }
}

