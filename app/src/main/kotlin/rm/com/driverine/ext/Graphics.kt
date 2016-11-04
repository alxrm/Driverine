package rm.com.driverine.ext

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import common.lparamsLin
import org.jetbrains.anko.*

/**
 * Created by alex
 */

fun shadowDrawable(): Drawable = GradientDrawable(
    GradientDrawable.Orientation.TOP_BOTTOM,
    intArrayOf(0x40000000, 0x00000000)
)

fun <T : ViewManager> T.horizontalShadow() {
  view {
    lparamsLin(width = matchParent, height = dip(2))

    backgroundDrawable = shadowDrawable()
  }
}

fun ViewGroup?.inflateOptional(init: AnkoContext<Context>.() -> Unit): View? = this?.context?.UI(init)?.view