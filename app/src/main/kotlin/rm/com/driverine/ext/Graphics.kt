package rm.com.driverine.ext

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.widget.LinearLayout
import common.lparamsLin
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.view

/**
 * Created by alex
 */

fun shadowDrawable(): Drawable = GradientDrawable(
		GradientDrawable.Orientation.TOP_BOTTOM,
		intArrayOf(0x40000000, 0x00000000)
)

fun LinearLayout.horizontalShadow(height: Int = dip(2)) {
	view {
		lparamsLin(width = matchParent, height = height)

		backgroundDrawable = shadowDrawable()
	}
}