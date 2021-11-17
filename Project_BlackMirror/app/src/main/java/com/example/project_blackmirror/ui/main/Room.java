package com.example.project_blackmirror.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.project_blackmirror.CheckRoomsActivity;
import com.example.project_blackmirror.IOTs;
import com.example.project_blackmirror.RoomPageActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
    private String roomName;
    private int roomType;
    private int roomImage;
    private String roomID;
    private ArrayList<IOTs> listOfIOTs;
    private Context context;

    public Room (String roomName, int roomType, String roomID, int roomImage, ArrayList<IOTs> listOfIOTs, Context context)
    {
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomImage = roomImage;
        this.roomID = roomID;
        this.listOfIOTs = listOfIOTs;
        this.context = context;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(int roomImage) {
        this.roomImage = roomImage;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public ArrayList<IOTs> getListOfIOTs() {
        return listOfIOTs;
    }

    public void addIOT(IOTs newIOT) {
        this.listOfIOTs.add(newIOT);
    }

    public void openRoomPage(String roomName, String roomID, ArrayList<IOTs> listOfIOTs, Context context)
    {
        Intent roomPage = new Intent(context, RoomPageActivity.class);
        Bundle roomInfo = new Bundle();
        roomInfo.putString("RoomName", roomName);
        roomInfo.putString("RoomID", roomID);
        roomInfo.putSerializable("IOTList", listOfIOTs);
        roomPage.putExtras(roomInfo);
        context.startActivity(roomPage);
    }
}
