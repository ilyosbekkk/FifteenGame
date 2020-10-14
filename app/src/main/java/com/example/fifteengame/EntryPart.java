package com.example.fifteengame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class EntryPart extends AppCompatActivity {


    //region UI part
    EditText username;
    //endregion
    //region overrides
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_part);
        username = findViewById(R.id.useername); }
        //endregion
    //region launchgame
    public void startGame(View view) {
        Intent intent = new Intent(EntryPart.this, MainActivity.class);
        intent.putExtra("username", username.getText().toString());
        startActivity(intent);
    }
    //endregion



}