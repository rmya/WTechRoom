package com.example.wtechroom

import androidx.room.*

@Dao
interface GelirGiderDAO {

   @Insert
   fun gelirGiderEkle(gelirgider: GelirGiderModel)

   @Update
   fun gelirGiderGuncelle(gelirgider: GelirGiderModel)

   @Delete
   fun gelirGiderSil(gelirgider: GelirGiderModel)

   @Query("DELETE FROM gelirgider")
   fun gelirGiderTemizle()

   @Query("SELECT * FROM gelirgider WHERE miktar = :miktarInput")
   fun gelirGiderAra(miktarInput: String): GelirGiderModel?

   @Query("DELETE FROM gelirgider WHERE id = :idInput")
   fun gelirGiderSilIdIle(idInput: Int)

   @Query("SELECT * FROM gelirgider")
   fun tumGelirGiderler(): List<GelirGiderModel?>

}