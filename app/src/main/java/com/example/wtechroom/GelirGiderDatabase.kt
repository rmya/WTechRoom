package com.example.wtechroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities = [GelirGiderModel::class], version = 1)
abstract class GelirGiderDatabase {

    abstract fun gelirGiderDao():GelirGiderDao

    companion object {

        private var instance : GelirGiderDatabase ?= null

        fun getirGelirGiderDatabase(context: Context): GelirGiderDatabase? {

       /*     if ( instance == null){
                instance = Room.databaseBuilder(
                    context,
                    GelirGiderDatabase::class.java,
                    "gelirgider.db")
                    .allowMainThreadQueries()
                    .build()
            }*/

            return instance
        }

    }


}