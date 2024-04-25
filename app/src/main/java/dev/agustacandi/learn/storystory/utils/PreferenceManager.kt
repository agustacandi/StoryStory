package dev.agustacandi.learn.storystory.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val editor = prefs.edit()

    val getToken = prefs.getString(KEY_TOKEN, "")
    val getName = prefs.getString(KEY_NAME, "")

    fun setLoginPrefs() {

    }

    fun clearAllPreferences() {
        editor.remove(KEY_TOKEN)
        editor.remove(KEY_NAME)
        editor.apply()
    }
}