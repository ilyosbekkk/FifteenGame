package com.example.fifteengame.persistence;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fifteengame.models.Player;

import java.util.List;

@Dao
public interface PlayerDao {

    //region insert
    @Insert
    void insertPlayerInfo(Player... players);
    //endregion

    //region query
    @Query("SELECT * from player_info")
    LiveData<List<Player>> getPlayer();
    //endregion

}
