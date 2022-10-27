package com.neon.studentregister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neon.studentregister.db.Student
import com.neon.studentregister.db.StudentDao
import kotlinx.coroutines.launch

class StudentViewModel(private val dao: StudentDao): ViewModel() {
    val students = dao.getAllStudents()
    fun insertStudent(student: Student) = viewModelScope.launch {
        dao.insertStudent(student)
    }
    fun deleteStudent(student: Student) = viewModelScope.launch {
        dao.deleteStudent(student)
    }
    fun updateStudent(student: Student) = viewModelScope.launch {
        dao.updateStudent(student)
    }
}