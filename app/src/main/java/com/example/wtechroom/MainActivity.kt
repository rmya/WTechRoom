package com.example.wtechroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var gelirGiderDB : GelirGiderDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gelirGiderDB = GelirGiderDatabase.getirGelirGiderDatabase(this) !!

        // !! double bang  boş olmayan kullanıcı operatörü!!, herhangi bir değeri boş olmayan tip değerine dönüştürür. ve değer null ise bir istisna atar.


    }
}