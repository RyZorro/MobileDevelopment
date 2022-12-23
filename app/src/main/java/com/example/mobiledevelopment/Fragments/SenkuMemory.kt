package com.example.mobiledevelopment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobiledevelopment.SenkuMemory.ElementAdapter
import com.example.mobiledevelopment.SenkuMemory.ElementViewModel
import com.example.mobiledevelopment.databinding.FragmentSenkuMemoryBinding

class SenkuMemory : Fragment() {

    lateinit var binding: FragmentSenkuMemoryBinding
    lateinit var myViewModel: ElementViewModel
    lateinit var surveyAdapter: ElementAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSenkuMemoryBinding.inflate(inflater,container,false)

        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity()).get(ElementViewModel::class.java)
        var myModel=myViewModel.myLiveModel.value
        binding.taskRv.layoutManager=
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)

        if(myModel !=null) {
            val survey = myModel.elementList
            surveyAdapter = ElementAdapter(survey)
            binding.taskRv.adapter=surveyAdapter
        }
    }
}