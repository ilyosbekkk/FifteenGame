package com.example.fifteengame.async_operations;


import com.example.fifteengame.models.Player;
import com.example.fifteengame.persistence.PlayerDao;

public class InsertPlayerInfo extends Thread {

    PlayerDao mPlayerDao;
    Player mPlayer;


    public InsertPlayerInfo(PlayerDao playerDao, Player player) {
        mPlayerDao = playerDao;
        mPlayer = player;
    }

    @Override
    public void run() {
        mPlayerDao.insertPlayerInfo(mPlayer);
    }
}
