package com.school;

public class Staff extends Person implements Storable {
    private String staffRole;

    public Staff(int id, String name, String staffRole) {
        super(id, name);
        this.staffRole = staffRole;
    }

    public String getStaffRole() { return staffRole; }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
        System.out.println("Staff Role: " + staffRole + " (Role: Staff)");
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + staffRole;
    }

    @Override
    public String toString() {
        return "Staff{id=" + id + ", name='" + name + "', staffRole='" + staffRole + "'}";
    }
}
