package com.example.project_blackmirror;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.project_blackmirror.ui.main.Room;
import com.example.project_blackmirror.ui.main.RoomBuilderFragment;

import java.io.Serializable;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.Random;

public class RoomBuilderActivity extends AppCompatActivity implements Serializable
{
    private ArrayList<Room> listOfRooms = new ArrayList<>(0);
    private RoomList roomList = new RoomList();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_builder_activity);
        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, RoomBuilderFragment.newInstance())
                    .commitNow();
        }

        Intent updateRooms = getIntent();
        if(updateRooms.getSerializableExtra("previousRoomList") != null)
        {
            listOfRooms = (ArrayList<Room>) updateRooms.getSerializableExtra("previousRoomList");
        }
    }

        public void handleText(View buildRoomBtn)
        {
            //Gets inputted room name data
            EditText currentInput = findViewById(R.id.createRoomName);
            String roomName = currentInput.getText().toString();

            //Gets name of the room type
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.roomTypeButtons);
            int selectedRadioBtn = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectedRadioBtn);
            String roomType = (String) radioButton.getText();

            //Creates the room object based on user input
            Room newlyCreatedRoom = createRooms(roomName, roomType);


            //Sends list of Rooms to a middle man that communicates with Check Rooms to show case the created rooms.
            listOfRooms.add(newlyCreatedRoom);

            //roomList.setListOfRooms(listOfRooms);
            //ArrayList<Room> currentRoomList = roomList.getListOfRooms();

            /*
            for(int i = 0; i < currentRoomList.size(); i++)
            {
                Toast.makeText(this, "" + currentRoomList.get(i).getRoomName() + "", Toast.LENGTH_LONG).show();
            }
            */

            Intent checkRoom = new Intent(this, CheckRoomsActivity.class);
            checkRoom.putExtra("roomList", listOfRooms);
            startActivity(checkRoom);
        }

        public void checkAllRooms (View viewRoomsBtn)
        {
            ArrayList<Room> currentRoomList = roomList.getListOfRooms();
            Intent checkRoom = new Intent(this, CheckRoomsActivity.class);
            checkRoom.putExtra("roomList", currentRoomList);
            startActivity(checkRoom);
        }

        /*
            //Printing integer array list values on screen.
            for(int i=0; i < integerData.size(); i++)
            {
                integerTextView.setText(integerTextView.getText() + " " + integerData.get(i) + " , ");
            }
            //Printing string array list values on screen.
            for(int i=0; i < stringData.size(); i++)
            {
                stringTextView.setText(stringTextView.getText() + stringData.get(i) + " , ");
            }

         */

        public Room createRooms(String roomName, String roomType)
        {
            int roomTypeInt = getRoomTypeNum(roomType);
            String newRoomID = createRoomID(roomType);
            int roomImage = getRoomImage(roomType);
            ArrayList <IOTs> emptyIOTList = new ArrayList<>(0);
            Room newRoom = new Room(roomName, roomTypeInt, newRoomID, roomImage, emptyIOTList, this);
            //String createdRoomAlert = "Hey I created a room with: " + roomName + " " + roomTypeInt + " " + newRoomID + " " + roomImage + "";
            //Toast.makeText(this, createdRoomAlert, Toast.LENGTH_SHORT).show();
            return newRoom;
        }

        public int getRoomTypeNum(String roomType)
        {
            int roomTypeInt = 0;

            if(roomType.equalsIgnoreCase("Bathroom"))
            {
                roomTypeInt= 1;
            }
            else if(roomType.equalsIgnoreCase("Bedroom"))
            {
                roomTypeInt = 2;
            }
            else if(roomType.equalsIgnoreCase("Kitchen"))
            {
                roomTypeInt = 3;
            }
            else if(roomType.equalsIgnoreCase("Living Room"))
            {
                roomTypeInt = 4;
            }

            return roomTypeInt;
        }

        public String createRoomID(String roomType)
        {
            String currentRoomType = roomType;
            if(currentRoomType.equalsIgnoreCase("Living Room"))
            {
                currentRoomType = "LivingRoom";
            }
            Random random = new Random();
            String randomIDNum = String.format("%04d", random.nextInt(10000));;
            String newRoomID = currentRoomType + randomIDNum;

            return newRoomID;
        }

        public int getRoomImage(String roomType)
        {
            String currentRoomType = roomType;
            if(currentRoomType.equalsIgnoreCase("Living Room"))
            {
                currentRoomType = "livingroom";
            }
            else if(currentRoomType.equalsIgnoreCase("Bedroom"))
            {
                currentRoomType = "bedroom";
            }
            else if(currentRoomType.equalsIgnoreCase("Bathroom"))
            {
                currentRoomType = "bathroom";
            }
            else if(currentRoomType.equalsIgnoreCase("Kitchen"))
            {
                currentRoomType = "kitchen";
            }
            int roomImageID = getResources().getIdentifier(currentRoomType, "drawable", "package.name");

            //ImageView roomTypeImage;
            //roomTypeImage.setImageResource(roomImageID)

            return roomImageID;
        }
}
