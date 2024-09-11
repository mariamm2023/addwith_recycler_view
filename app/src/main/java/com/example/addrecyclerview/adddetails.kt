package com.example.addrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.addrecyclerview.databinding.AdddetailsBinding

class adddetails : Fragment() {
    lateinit var binding:AdddetailsBinding
    lateinit var name:String
    lateinit var mail:String
   // private lateinit var viewmodel:viewmodel
    private val dataList = mutableListOf<Pair<String, String>>() // قائمة لتخزين العناصر
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=AdddetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
        //viewmodel=ViewModelProvider(this).get(viewmodel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.doAfterTextChanged {
            name=binding.name.text.toString()

        }
        binding.email.doAfterTextChanged {
            mail=binding.email.text.toString()
        }
        binding.addpatient.setOnClickListener {
            findNavController().navigate(R.id.recycler, bundleOf(

                "name" to name,
                "email" to  mail
            ))
            binding.name.text=null
            binding.email.text=null
        }
        binding.deletpatient.setOnClickListener {
            binding.name.text=null
            binding.email.text=null

        }
    }
}