package com.example.fifteengame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fifteengame.models.Player;
import com.example.fifteengame.persistence.PlayerRepository;
import com.example.fifteengame.recyclerview_adapter.PlayerRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserInfoActivity extends AppCompatActivity {


    //region vars
    RecyclerView mRecyclerView;
    PlayerRecyclerAdapter mAdapter;
    PlayerRepository mRepository;
    ArrayList<Player> mPlayers;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        mRecyclerView = findViewById(R.id.recyclerview);
        mPlayers = new ArrayList<>();
        mRepository = new PlayerRepository(this);

        getInfo();
        initRecyclerView();


    }
    //region init recycler view

    private void initRecyclerView(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new PlayerRecyclerAdapter(mPlayers);
        mRecyclerView.setAdapter(mAdapter);
    }
    //endregion

  /*  //region fakeNotes
   // private void insertPlayerInfo(){
        for(int i = 0; i<20; i++){
            mPlayers.add(new Player("Name: " + i, "100"));

        }
    }
    //endregion*/

    //region player info
    private void getInfo(){
        mRepository.retrievePlayerInfo().observe(this, players -> {
            if(mPlayers.size() > 0){
                mPlayers.clear();
            }
            mPlayers.addAll(players);
            mAdapter.notifyDataSetChanged();
        });
    }
    //endregion
}