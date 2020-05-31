package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object Activity {
    fun hideKeyBoard() {
    }
}

fun Activity.hideKey() {
    hideBoard(currentFocus ?: View(this))
}

fun Context.hideBoard(view: View) {
    val inputManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(view.windowToken, 0)
}