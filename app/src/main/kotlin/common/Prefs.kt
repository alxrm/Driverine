package common

import android.content.Context
import android.content.SharedPreferences
import android.support.v4.app.Fragment
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.support.v4.defaultSharedPreferences

inline fun Context.toPref(write: SharedPreferences.Editor.() -> Unit) =
		defaultSharedPreferences.edit().let { it.write(); it.apply() }

inline fun <T> Context.fromPref(getter: SharedPreferences.() -> T?): T =
		defaultSharedPreferences.getter() ?: error("Value cannot be null")

inline fun Fragment.toPref(write: SharedPreferences.Editor.() -> Unit) =
		defaultSharedPreferences.edit().let { it.write(); it.apply() }

inline fun <T> Fragment.fromPref(getter: SharedPreferences.() -> T?): T =
		defaultSharedPreferences.getter() ?: error("Value cannot be null")