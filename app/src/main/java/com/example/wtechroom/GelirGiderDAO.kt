package com.example.wtechroom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface GelirGiderDao {

   @Insert
   fun gelirGiderEkle(gelirgider: GelirGiderModel)

   @Update
   fun gelirGiderGuncelle(gelirgider: GelirGiderModel)

   @Delete
   fun gelirGiderSil(gelirgider: GelirGiderModel)

}