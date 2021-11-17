package com.example.project_blackmirror;

public class TV implements IOTs {
    @Override
    public String manufacturer() {
        String tvManufacturer = "Sony";
        return tvManufacturer;
    }

    @Override
    public String idName() {
        String tvID = "TV_1";
        return tvID;
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

    public int adjustVolume() {
        int currentVolume = 5;
        return currentVolume;
    }
}
