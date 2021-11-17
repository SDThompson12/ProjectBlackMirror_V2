package com.example.project_blackmirror;

public class Speaker implements IOTs {
    @Override
    public String manufacturer() {
        String speakerManufacturer = "Sony";
        return speakerManufacturer;
    }

    @Override
    public String idName() {
        String speakerID = "Speaker_1";
        return speakerID;
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
