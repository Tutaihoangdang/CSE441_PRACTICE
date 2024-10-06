package com.example.prac02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

// Lớp dữ liệu Staff
class Staff {
    public String id;
    public String name;
    public String birthDate;
    public String salary;

    public Staff(String id, String name, String birthDate, String salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
    }
}

public class StaffViewModel extends ViewModel {

    private final MutableLiveData<List<Staff>> staffList = new MutableLiveData<>(new ArrayList<>());


    public void addStaff(String id, String name, String birthDate, String salary) {
        List<Staff> currentList = staffList.getValue();
        if (currentList != null) {
            currentList.add(new Staff(id, name, birthDate, salary));
            staffList.setValue(currentList);
        }
    }

    public LiveData<List<Staff>> getStaffList() {
        return staffList;
    }
}
