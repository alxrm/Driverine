package common

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.View
import org.jetbrains.anko.dip

private val TV = TypedValue()

@ColorInt
fun Context.color(@ColorRes color: Int): Int =
		ContextCompat.getColor(this, color)

fun Context.dipF(what: Int): Float =
		dip(what).toFloat()

fun Context.drawable(@DrawableRes res: Int): Drawable =
		ContextCompat.getDrawable(this, res)

@AnyRes
fun Context.attr(@AttrRes attr: Int): Int =
		theme.resolveAttribute(attr, TV, true).let {
			assertMainThread()
			TV.resourceId
		}

@ColorInt
fun Context.attrColor(@AttrRes attr: Int): Int =
		theme.resolveAttribute(attr, TV, true).let {
			assertMainThread()
			TV.data
		}

@AnyRes
fun View.attr(@AttrRes attr: Int): Int =
		context.attr(attr)

@AnyRes
fun View.selectableBg(): Int =
		attr(android.R.attr.selectableItemBackground)

@DimenRes
fun Context.statusBarHeight(): Int {
	if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return 0

	val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")

	return when (resourceId) {
		0 -> 0
		else -> resources.getDimensionPixelSize(resourceId)
	}
}

@ColorInt
fun View.color(@ColorRes color: Int): Int =
		context.color(color)

fun View.dipF(what: Float): Float =
		dip(what).toFloat()

fun View.dipF(what: Int): Float =
		dip(what).toFloat()