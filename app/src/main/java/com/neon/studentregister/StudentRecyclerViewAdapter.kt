package com.neon.studentregister

import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.neon.studentregister.databinding.ListItemBinding
import com.neon.studentregister.db.Student

class StudentRecyclerViewAdapter(private val clickListener: (Student) -> Unit): RecyclerView.Adapter<StudentViewHolder>() {
    private val studentList = ArrayList<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun setList(students: List<Student>) {
        studentList.clear()
        studentList.addAll(students)
    }
}

class StudentViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(student: Student, clickListener: (Student) -> Unit) {
        binding.apply {

            tvName.text = student.name
            tvEmail.text = student.email
            root.setOnClickListener {
                clickListener(student)
            }
        }
    }
}