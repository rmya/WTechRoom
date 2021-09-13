package com.example.wtechroom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wtechroom.GelirGiderDatabase
import com.example.wtechroom.R
import com.example.wtechroom.databinding.FragmentGelirGiderAraBinding


class GelirGiderAraFragment : Fragment() {

    private lateinit var binding : FragmentGelirGiderAraBinding
    private lateinit var gelirGiderDB: GelirGiderDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gelirGiderDB = GelirGiderDatabase.getirGelirGiderDatabase(requireContext())!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGelirGiderAraBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.araButton.setOnClickListener {
            val bulunanSatir = gelirGiderDB.gelirGiderDAO().gelirGiderAra(binding.araEditText.text.toString())
            println(bulunanSatir)

            //veri silme
            gelirGiderDB.gelirGiderDAO().gelirGiderSilIdIle(bulunanSatir!!.id)

        }
    }


}