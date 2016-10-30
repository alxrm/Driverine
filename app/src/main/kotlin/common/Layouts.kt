package common

import android.view.View

fun <T: View> T.lparamsRel(
		width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
		height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
		init: android.widget.RelativeLayout.LayoutParams.() -> Unit = {}
): T {
	val layoutParams = android.widget.RelativeLayout.LayoutParams(width, height)
	layoutParams.init()
	this@lparamsRel.layoutParams = layoutParams
	return this
}

fun <T: View> T.lparamsLin(
		width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
		height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
		init: android.widget.LinearLayout.LayoutParams.() -> Unit = {}
): T {
	val layoutParams = android.widget.LinearLayout.LayoutParams(width, height)
	layoutParams.init()
	this@lparamsLin.layoutParams = layoutParams
	return this
}