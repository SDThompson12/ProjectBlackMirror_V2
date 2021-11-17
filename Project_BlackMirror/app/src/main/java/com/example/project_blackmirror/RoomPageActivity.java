package com.example.project_blackmirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RoomPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_page);

        TextView roomPageName = findViewById(R.id.roomName);
        TextView roomPageID = findViewById(R.id.roomPageID);
        Intent currentRoom = getIntent();

        Bundle currentBundle = currentRoom.getExtras();
        String currentRoomName = currentBundle.getString("RoomName");
        String currentRoomID = currentBundle.getString("RoomID");

        roomPageName.setText(currentRoomName);
        roomPageID.setText(currentRoomID);
    }
}