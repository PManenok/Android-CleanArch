package com.gmail.pmanenok.data.db.entity

import com.gmail.pmanenok.data.entity.StudentResponse
import com.gmail.pmanenok.domain.entity.student.Student

fun StudentDb.transformToDomain(): Student {
    return Student(id = id, name = name, age = Integer.valueOf(age), gender = gender, imageUrl = imageUrl)
}

fun StudentResponse.transformToDb(): StudentDb {
    return StudentDb(
        id = id,
        name = name,
        age = Integer.toString(age),
        gender = gender ?: "female",
        imageUrl = imageUrl ?: ""
    )
}

fun Student.transformToDb(): StudentDb {
    return StudentDb(
        id = id,
        name = name,
        age = age.toString(),
        gender = gender,
        imageUrl = imageUrl
    )
}

//error: Not sure how to convert a Cursor to this method's return type
//    public abstract io.reactivex.Observable<com.gmail.pmanenok.data.db.entity.StudentDb> getById(@org.jetbrains.annotations.NotNull()
//
// error: Not sure how to convert a Cursor to this method's return type
//    public abstract io.reactivex.Observable<java.util.List<com.gmail.pmanenok.data.db.entity.StudentDb>> getAll();
//                                                                                                         ^	                                                                                    ^


