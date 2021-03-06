package com.gmail.pmanenok.tasks.presentation.screen.student

import android.util.Log
import android.view.View
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.presentation.base.BaseRouter
import com.gmail.pmanenok.tasks.presentation.screen.student.details.StudentDetailsFragment
import com.gmail.pmanenok.tasks.presentation.screen.student.list.StudentListFragment

class StudentRouter(activity: StudentActivity) : BaseRouter<StudentActivity>(activity) {

    fun goBackFromDetails() {
        Log.e("bbb", "router goBackFromDetails")
        val containerDetails = activity.findViewById<View>(R.id.student_container_details)
        if (containerDetails == null) {
            Log.e("bbb", "router popBackStack")
            popBackStack()
        } else {
            Log.e("bbb", "router detach")
            val transaction = activity.supportFragmentManager.beginTransaction()
            val frag = activity.supportFragmentManager.findFragmentByTag(StudentListFragment::class.java.canonicalName)
            val fragDetail =
                activity.supportFragmentManager.findFragmentByTag(StudentDetailsFragment::class.java.canonicalName)
            if (frag != null && fragDetail != null) {
                transaction.detach(frag)
                transaction.detach(fragDetail)
                transaction.attach(frag)
            }
            transaction.commit()
        }
    }

    fun goToStudentList() {
        Log.e("bbb", "router goToStudentList")
        replaceFragment(
            activity.supportFragmentManager,
            StudentListFragment.getInstance(),
            R.id.student_container,
            false
        )
    }

    fun goToStudentDetails(id: String) {
        Log.e("bbb", "router goToStudentDetails")
        val containerDetails = activity.findViewById<View>(R.id.student_container_details)
        if (containerDetails == null) {
            replaceFragment(
                activity.supportFragmentManager,
                StudentDetailsFragment.getInstance(id),
                R.id.student_container,
                true
            )
        } else {
            replaceFragment(
                activity.supportFragmentManager,
                StudentDetailsFragment.getInstance(id),
                R.id.student_container_details,
                false
            )
        }
    }
}