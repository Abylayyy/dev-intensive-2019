package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

var check = false

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(view.windowToken, 0)
}

/*fun View.isKeyboardOpen() : Boolean {
    this.viewTreeObserver.addOnGlobalLayoutListener {
        val rect = Rect()
        this.getWindowVisibleDisplayFrame(rect)
        val s_height = this.rootView.height
        val k_height = s_height - rect.bottom

        if (k_height > s_height * 0.15) {
            if (!check) {
                check = true
            }
        }
    }
    return check
}

fun View.isKeyboardClosed(): Boolean {
    this.viewTreeObserver.addOnGlobalLayoutListener {
        val rect = Rect()
        this.getWindowVisibleDisplayFrame(rect)
        val s_height = this.rootView.height
        val k_height = s_height - rect.bottom

        if (k_height < s_height * 0.15) {
            if (check) {
                check = true
            }
        }
    }
    return check
}*/
