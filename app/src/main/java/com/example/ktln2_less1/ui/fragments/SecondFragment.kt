package com.example.ktln2_less1.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktln2_less1.adapters.SecondAdapter
import com.example.ktln2_less1.data.dataclass.FirstModel
import com.example.ktln2_less1.data.repository.LanguageRepository
import com.example.ktln2_less1.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val listLanguage = mutableListOf<FirstModel>()
    private val repository = LanguageRepository()
    private val adapter = SecondAdapter(listLanguage)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cleanList()
        initialize()
    }

    private fun cleanList() {
        listLanguage.clear()
    }

    private fun initialize() {
        binding.rvLanguage.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        listLanguage.addAll(repository.getListOfLanguages())
        binding.rvLanguage.adapter = adapter
    }
}