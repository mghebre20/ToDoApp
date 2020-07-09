package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    //member variables
    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        //setting title of activity
        getSupportActionBar().setTitle("Edit item");

        //retrieve data from main activity to edit activity
        //prepopulate edit text with the data passed in from main activity
        etItem.setText(getIntent().getStringExtra(MainActivity.KET_ITEM_TEXT));

        //when user is done editing, they click the save button
        //set a click listener on button Save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create an intent which will contain the results
                Intent intent = new Intent();

                //pass the data, results of editing
                //get item edited
                //place the item at the position at which it was updated
                intent.putExtra(MainActivity.KET_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION,getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //defining what was the result
                //set the result of the intent
                setResult(RESULT_OK, intent);

                //finish and close edit activity screen and go back to main activity
                finish();
            }
        });
    }
}