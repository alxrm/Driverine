package common

import android.app.Activity
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.view.View

fun View.vectorOf(id: Int): Drawable = vectorOf(resources, id)

fun Activity.vectorOf(id: Int): Drawable = vectorOf(resources, id)

fun vectorOf(res: Resources, id: Int): Drawable {
	val drawable = VectorDrawableCompat.create(res, id, null) as Drawable
	return DrawableCompat.wrap(drawable)
}