package rm.com.driverine.ui.view.items

import android.content.Context
import android.graphics.Color
import android.view.View
import common.selectableBg
import org.jetbrains.anko.*
import rm.com.driverine.R

/**
 * Created by alex
 */

fun Context.driverItemView(): View =
    UI {
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
    }.view
