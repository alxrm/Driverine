package rm.com.driverine.ui.item

import android.view.View
import android.view.ViewGroup
import rm.com.driverine.ext.horizontalShadow
import rm.com.driverine.ext.inflateOptional

/**
 * Created by alex
 */

fun ViewGroup?.formSeparatorView(): View? =
    inflateOptional { horizontalShadow() }