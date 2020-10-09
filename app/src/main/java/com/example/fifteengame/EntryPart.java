package com.example.fifteengame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fifteengame.models.Player;
import com.example.fifteengame.persistence.PlayerRepository;
import com.example.fifteengame.recyclerview_adapter.PlayerRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class EntryPart extends AppCompatActivity {


    //region UI part
    EditText username;




    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_part);
        username = findViewById(R.id.useername);



    }




    //region launchgame
    public void startGame(View view) {
        Intent intent = new Intent(EntryPart.this, MainActivity.class);
        intent.putExtra("username", username.getText().toString());
        startActivity(intent);

    }
    //endregion



}