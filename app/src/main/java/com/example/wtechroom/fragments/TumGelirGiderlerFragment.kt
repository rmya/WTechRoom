package com.example.wtechroom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wtechroom.GelirGiderDatabase
import com.example.wtechroom.GelirGiderModel
import com.example.wtechroom.R
import com.example.wtechroom.databinding.FragmentTumGelirGiderlerBinding
import com.google.android.material.snackbar.Snackbar

class TumGelirGiderlerFragment : Fragment() {

    private lateinit var binding: FragmentTumGelirGiderlerBinding
    private lateinit var gelirGiderDB : GelirGiderDatabase
    private lateinit var gelirGiderList : List<GelirGiderModel?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gelirGiderDB = GelirGiderDatabase.getirGelirGiderDatabase(requireContext())!!

        //Tüm Gelir ve Giderleri çağırma
        gelirGiderList = gelirGiderDB.gelirGiderDAO().tumGelirGiderler()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tum_gelir_giderler, container, false)
        binding = FragmentTumGelirGiderlerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bilgileriYazdir()

        binding.apply {
            guncelleButton.setOnClickListener {

                gelirGiderDB.gelirGiderDAO().gelirGiderGuncelle(
                    GelirGiderModel(
                        idEditText.text.toString().toInt(),
                        gelirGiderEditText.text.toString(),
                        harcamaTurEditText.text.toString(),
                        miktarEditText.text.toString()
                    ))

                //Yukarıda güncelledikten sonra, aşağıda veri çekme kodunu tekrar çağırıp yazdırıyoruz.
                gelirGiderList = gelirGiderDB.gelirGiderDAO().tumGelirGiderler()
            }
        }

    }

    fun bilgileriYazdir() {

        binding.apply {

            if(gelirGiderList.isEmpty()){
                Snackbar.make(requireView(),"Bilgiler bulunamadı !",1000).show()
            }   else {
                gelirGiderTurText.text = gelirGiderList[0]?.gelirgidertur
                harcamaTurText.text = gelirGiderList[0]?.harcamatur
                miktarText.text = gelirGiderList[0]?.miktar

                gelirGiderTurText2.text = gelirGiderList[1]?.gelirgidertur
                harcamaTurText2.text = gelirGiderList[1]?.harcamatur
                miktarText2.text = gelirGiderList[1]?.miktar

                gelirGiderTurText3.text = gelirGiderList[2]?.gelirgidertur
                harcamaTurText3.text = gelirGiderList[2]?.harcamatur
                miktarText3.text = gelirGiderList[2]?.miktar
            }


        }

    }

}