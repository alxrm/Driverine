package rm.com.driverine.ui.layout.item

import android.view.View
import android.view.ViewGroup
import rm.com.driverine.util.ext.horizontalShadow
import rm.com.driverine.util.ext.inflateOptional

/**
 * Created by alex
 */

fun ViewGroup?.formSeparatorView(): View? =
    inflateOptional { horizontalShadow() }