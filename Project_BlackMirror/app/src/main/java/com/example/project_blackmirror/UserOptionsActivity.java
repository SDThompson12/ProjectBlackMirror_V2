package com.example.project_blackmirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_options);
    }

    public void changeActivity(View enterApp)
    {
        String currentID = (String) enterApp.getTag();
        if(currentID.equalsIgnoreCase("Build Room"))
            openRoomBuilder();
        //else if(currentID.equalsIgnoreCase("Check Rooms"))
           // openCheckRooms();
    }

    public void openRoomBuilder()
    {
        Intent roomBuilderIntent =  new Intent (this, RoomBuilderActivity.class);
        startActivity(roomBuilderIntent);
    }

    /*
    public void openCheckRooms()
    {
        Intent checkRoomsIntent =  new Intent (this, CheckRoomsActivity.class);
        startActivity(checkRoomsIntent);
    }
     */
}