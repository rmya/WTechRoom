package com.example.wtechroom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.wtechroom.GelirGiderDatabase
import com.example.wtechroom.R
import com.example.wtechroom.databinding.FragmentAnaSayfaBinding

class AnaSayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var gelirGiderDB : GelirGiderDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       gelirGiderDB = GelirGiderDatabase.getirGelirGiderDatabase(requireContext())!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnaSayfaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            tumGelirGiderlerButton.setOnClickListener {
                findNavController().navigate(R.id.action_anaSayfaFragment_to_tumGelirGiderlerFragment)
            }

            gelirGiderAraButton.setOnClickListener {
                findNavController().navigate(R.id.action_anaSayfaFragment_to_gelirGiderAraFragment)
            }

            gelirGiderEkleButton.setOnClickListener {
                findNavController().navigate(R.id.action_anaSayfaFragment_to_gelirGiderEkleFragment)
            }

            gelirGiderTemizleButton.setOnClickListener {
              gelirGiderDB.gelirGiderDAO().gelirGiderTemizle()
            }

        }

    }




}