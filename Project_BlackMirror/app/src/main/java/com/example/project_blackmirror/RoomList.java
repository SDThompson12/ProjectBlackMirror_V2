package com.example.project_blackmirror;

import com.example.project_blackmirror.ui.main.Room;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomList implements Serializable {
    private ArrayList<Room> listOfRooms = new ArrayList<>(0);

    public RoomList()
    {
    }

    public void addRooms(Room createdRoom)
    {
        this.listOfRooms.add(createdRoom);
    }

    public void setListOfRooms(ArrayList<Room> listOfRooms)
    {
        this.listOfRooms = listOfRooms;
    }

    public ArrayList<Room> getListOfRooms()
    {
        return this.listOfRooms;
    }
}
