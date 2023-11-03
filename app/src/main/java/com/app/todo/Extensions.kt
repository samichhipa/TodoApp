package com.app.todo

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

fun error(view: View, text: String) {

    Snackbar.make(
        view, text, Snackbar.LENGTH_SHORT
    ).setTextColor(ContextCompat.getColor(view.context, R.color.white))
        .setBackgroundTint(ContextCompat.getColor(view.context, R.color.error_red_color)).show()

}

fun success(view: View, text: String) {

    Snackbar.make(
        view.rootView, text, Snackbar.LENGTH_SHORT
    ).setTextColor(ContextCompat.getColor(view.context, R.color.white))
        .setBackgroundTint(ContextCompat.getColor(view.context, R.color.success_green_color)).show()

}