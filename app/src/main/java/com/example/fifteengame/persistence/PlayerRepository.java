package com.example.fifteengame.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.fifteengame.async_operations.InsertPlayerInfo;
import com.example.fifteengame.models.Player;

import java.util.List;

public class PlayerRepository {

    private PlayerDatabase mPlayerDatabase;

    public PlayerRepository(Context context) {
        mPlayerDatabase = PlayerDatabase.getInstance(context);
    }


    //region insert
    public void insertPayerInfo(Player player) {
        InsertPlayerInfo insertPlayerInfo = new InsertPlayerInfo(mPlayerDatabase.getPlayerDao(), player);
        insertPlayerInfo.start();
    }
    //endregion


    //region retrieve data from database
    public LiveData<List<Player>> retrievePlayerInfo(){
        return mPlayerDatabase.getPlayerDao().getPlayer();
    }
    //endregion


}
