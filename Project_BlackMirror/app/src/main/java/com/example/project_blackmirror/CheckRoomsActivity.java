package com.example.project_blackmirror;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.project_blackmirror.ui.main.Room;

import java.util.ArrayList;
import java.util.Random;

public class CheckRoomsActivity extends AppCompatActivity {
    private RecyclerView roomRecyclerView;
    private RoomAdapter roomAdapter;
    private RecyclerView.LayoutManager roomLayoutManager;
    ArrayList<Room> currentListOfRooms = new ArrayList<>();

    /*
    private BroadcastReceiver roomReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle extraRoomList = intent.getBundleExtra("roomList");
            ArrayList<Room> myRooms = new ArrayList<>();
            myRooms = (ArrayList<Room>) extraRoomList.getSerializable("roomList");
        }
    };
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_rooms);
        //CheckRoomsActivity activity = this.activity;

        ArrayList<Room> myRooms = new ArrayList<>();
        Intent getRoomList = getIntent();
        myRooms = (ArrayList<Room>) getRoomList.getSerializableExtra("roomList");
        currentListOfRooms = myRooms;

        //Creates recyclerview for each room in the list
        roomRecyclerView = findViewById(R.id.recyclerView);
        roomRecyclerView.setHasFixedSize(true);
        roomLayoutManager = new LinearLayoutManager(this);
        //Toast.makeText(this, myRooms.toString(), Toast.LENGTH_SHORT).show();
        roomAdapter = new RoomAdapter(currentListOfRooms);

        roomRecyclerView.setLayoutManager(roomLayoutManager);
        roomRecyclerView.setAdapter(roomAdapter);

        roomAdapter.setOnItemClickListener(new RoomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position)
            {
                Room clickedRoom = currentListOfRooms.get(position);
                String currentRoomName = clickedRoom.getRoomName();
                String currentRoomID = clickedRoom.getRoomID();
                ArrayList<IOTs> currentIOTList = clickedRoom.getListOfIOTs();
                clickedRoom.openRoomPage(currentRoomName, currentRoomID, currentIOTList, CheckRoomsActivity.this);
            }
        });
    }

    public void buildMoreRooms (View buildRoomBtn)
    {
        Intent roomBuilder = new Intent(this, RoomBuilderActivity.class);
        roomBuilder.putExtra("previousRoomList", currentListOfRooms);
        startActivity(roomBuilder);
    }

    //Determines if the list of room it receives is empty
    /*
    public ArrayList<Room> getRoomList()
    {
        // Creates data that would dynamically change based on the room list created from Room Builder
        RoomList currentRoomList = new RoomList();
        ArrayList<Room> currentListOfRooms = new ArrayList<>()  ;
        currentListOfRooms = currentRoomList.getListOfRooms();

        if(currentListOfRooms.size() == 0)
        {
            ArrayList <IOTs> emptyIOTList = new ArrayList<>(0);
            Room placeHolderBedroom = new Room("Junior's Bedroom", 2, "bedroom1", 0, emptyIOTList);
            Room placeHolderBathroom = new Room("Guest Bathroom", 1, "bathroom1", 0, emptyIOTList);
            Room placeHolderKitchen = new Room("Kitchen", 3, "kitchen1", 0, emptyIOTList);
            Room placeHolderBedroom2 = new Room("My Bedroom", 2, "bedroom2", 0, emptyIOTList);

            ArrayList<Room> placeHolderRoomList = new ArrayList<>(0);
            placeHolderRoomList.add(placeHolderBedroom);
            placeHolderRoomList.add(placeHolderBathroom);
            placeHolderRoomList.add(placeHolderKitchen);
            placeHolderRoomList.add(placeHolderBedroom2);

            return placeHolderRoomList;
        }
        else
        {
            for(int i = 0; i < currentListOfRooms.size(); i++)
            {
                Toast.makeText(this, "" + currentListOfRooms.get(i).getRoomName() + "", Toast.LENGTH_LONG).show();
            }
            return currentListOfRooms;
        }
    }
     */
}