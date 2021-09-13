package com.example.wtechroom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wtechroom.GelirGiderDatabase
import com.example.wtechroom.GelirGiderModel
import com.example.wtechroom.R
import com.example.wtechroom.databinding.FragmentGelirGiderEkleBinding


class GelirGiderEkleFragment : Fragment() {

    private lateinit var binding: FragmentGelirGiderEkleBinding
    private lateinit var gelirGiderDB: GelirGiderDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gelirGiderDB = GelirGiderDatabase.getirGelirGiderDatabase(requireContext())!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_gelir_gider_ekle, container, false)
        binding = FragmentGelirGiderEkleBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            ekleButton.setOnClickListener {
                val gelirGiderTurInput = gelirGiderTurEditText.text.toString()
                val harcamaTurInput = harcamaTurEditText.text.toString()
                val miktarInput = miktarEditText.text.toString()

                //Veri ekleme
                gelirGiderDB.gelirGiderDAO().gelirGiderEkle(
                    GelirGiderModel(
                        gelirgidertur = gelirGiderTurInput,
                        harcamatur = harcamaTurInput,
                        miktar = miktarInput
                    )
                )
            }
        }

    }
}