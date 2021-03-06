package com.gmail.pmanenok.tasks.presentation.screen.student.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.tasks.databinding.ItemStudentListBinding


class StudentListAdapter(val onItemClick: (Student) -> Unit) : RecyclerView.Adapter<StudentListAdapter.Holder>() {
    var itemList: List<Student> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStudentListBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class Holder(val binding: ItemStudentListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.item = StudentItem(student)
            binding.executePendingBindings()
            itemView.setOnClickListener {
                onItemClick(student)
            }
        }
    }
}