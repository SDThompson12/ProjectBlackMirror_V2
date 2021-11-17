package com.example.project_blackmirror;

public class Lights implements IOTs {
    @Override
    public String manufacturer() {
        String lightManufacturer = "Google";
        return lightManufacturer;
    }

    @Override
    public String idName() {
        String lightID = "Light_1";
        return lightID;
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

    public int adjustBrightness() {
        int currentBrightness = 5;
        return currentBrightness;
    }
}
