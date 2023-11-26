package vn.edu.hust.androidweek8

import android.view.View

interface ItemClickListener {
    fun onClick(view: View?, position: Int, isLongClick: Boolean)
}