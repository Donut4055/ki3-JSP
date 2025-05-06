package com.example.ss1.bt7;

public class Student {
    private String fullName;
    private String className;
    private String vehicleType;
    private String plateNumber;

    public Student(String fullName, String className, String vehicleType, String plateNumber) {
        this.fullName = fullName;
        this.className = className;
        this.vehicleType = vehicleType;
        this.plateNumber = plateNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getClassName() {
        return className;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
