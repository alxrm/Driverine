package rm.com.driverine.ui.item

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import common.selectableBg
import org.jetbrains.anko.*
import rm.com.driverine.R
import rm.com.driverine.ext.inflateOptional

/**
 * Created by alex
 */

fun ViewGroup?.driverItemView(): View? =
    inflateOptional {
      relativeLayout {
        lparams(width = matchParent, height = dip(56))

        isClickable = true
        backgroundResource = selectableBg()

        textView {
          lparams {
            centerVertically()
            horizontalMargin = dip(16)
          }

          id = R.id.driver_name
          text = "123"
          textColor = Color.BLACK
        }
      }
    }
