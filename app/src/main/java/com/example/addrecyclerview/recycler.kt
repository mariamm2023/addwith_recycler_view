package com.example.addrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.addrecyclerview.databinding.FragmentRecyclerBinding
class recycler : Fragment() {
    lateinit var binding:FragmentRecyclerBinding
    val userdatalist:MutableList<patient_information> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRecyclerBinding.inflate(layoutInflater,container,false)
        additemlist()

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.patient.layoutManager=LinearLayoutManager(requireContext())
        binding.patient.adapter=dataAdapter(userdatalist){
            findNavController().navigate(R.id.edit_fragment, bundleOf(
                "name" to it.name,
                "email" to it.email
            ))

        }
    }
    fun additemlist(){
        userdatalist.add(patient_information(name=arguments?.getString("name").toString(), email =arguments?.getString("email").toString()))
        userdatalist.add(patient_information(name = "Mariam", email = "mrym90233@gmail.com"))
        userdatalist.add(patient_information(name = "mohamed", email = "moha90233@gmail.com"))
        userdatalist.add(patient_information(name = "mohamed", email = "moha90233@gmail.com"))
        userdatalist.add(patient_information(name = "mohamed", email = "moha90233@gmail.com"))
        userdatalist.add(patient_information(name = "mohamed", email = "moha90233@gmail.com"))
    }

}