package com.example.project_blackmirror;

public class IOTFactory {
    public IOTs getIOT(String iotType) {
        if (iotType.equalsIgnoreCase("TV")) {
            return new TV();
        } else if (iotType.equalsIgnoreCase("Lights")) {
            return new Lights();
        } else if (iotType.equalsIgnoreCase("Speaker")) {
            return new Speaker();
        } else if (iotType.equalsIgnoreCase("Refrigerator")) {
            return new Fridge();
        }
        return null;
    }
}
