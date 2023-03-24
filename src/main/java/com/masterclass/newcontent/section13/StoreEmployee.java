package com.masterclass.newcontent.section13;

import java.util.Comparator;

public class StoreEmployee extends Employee{

    private String store;

    public StoreEmployee() {
    }

    public StoreEmployee(int id, String name, int yearStart, String store) {
        super(id, name, yearStart);
        this.store = store;
    }

    public class StoreComparator implements Comparator<StoreEmployee>{

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);
            if (result == 0){
                return new Employee.EmployeeComparator<>("yearstart").compare(o1, o2);
            }

            return result;
        }
    }

    @Override
    public String toString() {
        return "%-5s %s".formatted(store, super.toString());
    }
}
