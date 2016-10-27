package rm.com.driverine.ext

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable

/**
 * Created by alex
 */

fun shadowDrawable(): Drawable = GradientDrawable(
		GradientDrawable.Orientation.TOP_BOTTOM,
		intArrayOf(0x40000000, 0x00000000)
)