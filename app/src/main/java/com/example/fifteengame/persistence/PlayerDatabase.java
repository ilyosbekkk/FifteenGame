package com.example.fifteengame.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fifteengame.models.Player;

@Database(entities = {Player.class}, version = 1)
public abstract class PlayerDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "playerinfo_db";


    //region Singleton
    private static PlayerDatabase instance;

    static PlayerDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), PlayerDatabase.class, DATABASE_NAME).build();
        }
        return instance;
    }

    //endregion

    //region referenceToDao
    public abstract PlayerDao getPlayerDao();
    //endregion0

}
