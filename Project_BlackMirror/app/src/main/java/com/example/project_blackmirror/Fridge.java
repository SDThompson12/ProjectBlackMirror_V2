package com.example.project_blackmirror;

public class Fridge implements IOTs {
    @Override
    public String manufacturer() {
        String fridgeManufacturer = "Samsung";
        return fridgeManufacturer;
    }

    @Override
    public String idName() {
        String fridgeID = "Fridge_1";
        return fridgeID;
    }

    @Override
    public String description() {
        String desc = "This is the TV in X bedroom made by X manufacturer.";
        return desc;
    }

    @Override
    public Boolean toggleOnOff() {
        boolean currentStatus = true;
        return currentStatus;
    }

    public int adjustTemperature() {
        int currentTemperature = 36;
        return currentTemperature;
    }
}
