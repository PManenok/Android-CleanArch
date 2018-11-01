package com.gmail.pmanenok.domain.usecases

import com.gmail.pmanenok.domain.entity.student.Student
import com.gmail.pmanenok.domain.executor.PostExecutorThread
import com.gmail.pmanenok.domain.repositories.StudentRepository
import io.reactivex.Observable

class GetStudentsUseCase(postExecutorThread: PostExecutorThread, val studentRepository: StudentRepository) :
    BaseUseCase(postExecutorThread) {
    fun get(): Observable<List<Student>> {
        return studentRepository.get()
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }
}