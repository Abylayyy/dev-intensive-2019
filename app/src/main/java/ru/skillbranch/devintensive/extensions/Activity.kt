package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


fun Activity.hideKeyBoard() {
    hideKeyBoard(currentFocus ?: View(this))
}

fun Context.hideKeyBoard(view: View) {
    val inputManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(view.windowToken, 0)
}