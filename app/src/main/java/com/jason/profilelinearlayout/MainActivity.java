package com.jason.profilelinearlayout;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String name, city, state, zip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit = (Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(this);

        //Get all user inputs
        EditText inName = (EditText)findViewById(R.id.txtName);
        name = inName.getText().toString();
        EditText inCity = (EditText)findViewById(R.id.txtCity);
        city = inCity.getText().toString();
        EditText inState = (EditText)findViewById(R.id.txtState);
        state = inState.getText().toString();
        EditText inZip = (EditText)findViewById(R.id.txtZip);
        zip = inZip.getText().toString();
    }

    @Override
    public void onClick(View view) {
        File profileLog = new File(((Context)this).getExternalFilesDir(null), "profiles.txt");

        if(!profileLog.exists())
        {
            try
            {
                profileLog.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n\t");
        sb.append("City: ").append(city).append("\n\t");
        sb.append("State: ").append(state).append("\n\t");
        sb.append("Zip: ").append(zip);

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(profileLog,true));
            writer.append(sb);
            writer.newLine();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Toast toast = Toast.makeText(this, "Data Submitted", Toast.LENGTH_SHORT);
        toast.show();
    }
}
