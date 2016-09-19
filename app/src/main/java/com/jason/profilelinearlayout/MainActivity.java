package com.jason.profilelinearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit = (Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //TODO: Log info to a file
    }
}
