package com.example.project_blackmirror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.*;
import android.util.*;
import android.os.Bundle;
import android.widget.*;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    public void changeText(View homePageText)
    {
        TextView welcomeText = findViewById(R.id.homePageWelcome);
        //Log.d("success", "Ayy, we out here changing text!");
        String currentText = (String) welcomeText.getText();
        if(currentText.equalsIgnoreCase("Hello World!"))
        {
            welcomeText.setText("Welcome to Project: Black Mirror!");
        }
        else if(currentText.equalsIgnoreCase("Welcome to Project: Black Mirror!"))
        {
            welcomeText.setText("Feature adding Floor plans and Rooms Coming Soon!");
        }
        else if(currentText.equalsIgnoreCase("Feature adding Floor plans and Rooms Coming Soon!"))
        {
            welcomeText.setText("Welcome to Project: Black Mirror!");
        }
        else
        {
            welcomeText.setText("I hope you enjoy my app!");
        }
    }
     */

    public void changeActivity(View enterApp)
    {
        openUserOptions();
    }

    public void openUserOptions()
    {
        Intent userOptionsIntent =  new Intent (this, UserOptionsActivity.class);
        startActivity(userOptionsIntent);
    }
}