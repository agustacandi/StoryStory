package dev.agustacandi.learn.storystory.utils

import android.content.Context
import com.shashank.sony.fancytoastlib.FancyToast

object Helper {
    fun showSuccessToast(context: Context, message: String) {
        FancyToast.makeText(context, message, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show()
    }

    fun showErrorToast(context: Context, message: String) {
        FancyToast.makeText(context, message, FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show()
    }
}