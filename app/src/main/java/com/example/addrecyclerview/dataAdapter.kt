package com.example.addrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.addrecyclerview.databinding.PatientsBinding

class dataAdapter(
    val userlist: MutableList<patient_information> = mutableListOf(),
    val onItemClick: (patient_information) -> Unit
) : RecyclerView.Adapter<dataAdapter.dataHolder>() {
    inner class dataHolder(val binding: PatientsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun binddata(patient: patient_information) {
            binding.name.text = patient.name
            binding.email.text = patient.email
            binding.deletpatient.setOnClickListener {
                // حذف العنصر من القائمة
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    userlist.removeAt(position)
                    // إبلاغ الـ RecyclerView بأن عنصرًا قد تم حذفه
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, userlist.size)
                }
            }
            binding.root.setOnClickListener {
                onItemClick(patient)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dataHolder {
        val binding = PatientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return dataHolder(binding)
    }

    override fun getItemCount() = userlist.size

    override fun onBindViewHolder(holder: dataHolder, position: Int) {
        holder.binddata(userlist[position])
    }
}
