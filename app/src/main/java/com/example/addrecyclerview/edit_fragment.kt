package com.example.addrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.example.addrecyclerview.databinding.EditFragmentBinding


class edit_fragment : Fragment() {
    lateinit var binding: EditFragmentBinding
    lateinit var name:String
    lateinit var mail:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=EditFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.setText(arguments?.getString("name"))
        binding.email.setText(arguments?.getString("email"))
            binding.name.doAfterTextChanged {
                name= binding.name.text.toString()
            }

            binding.email.doAfterTextChanged {
                mail=binding.email.text.toString()
            }
        binding.edit.setOnClickListener {
            // جمع البيانات المعدلة
            val updatedName = binding.name.text.toString()
            val updatedEmail = binding.email.text.toString()

            // إعداد Bundle مع البيانات المعدلة
            val bundle = Bundle().apply {
                putString("updated_name", updatedName)
                putString("updated_email", updatedEmail)
            }

            findNavController().navigateUp()
        }

    }
    }


