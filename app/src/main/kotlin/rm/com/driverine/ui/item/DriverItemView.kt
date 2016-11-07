package rm.com.driverine.ui.item

import android.graphics.Color
import android.view.Gravity
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

        verticalLayout {
          lparams(width = matchParent, height = matchParent) {
            verticalGravity = Gravity.CENTER
          }

          textView {
            lparams {
              horizontalMargin = dip(16)
              verticalMargin = dip(2)
            }

            id = R.id.driver_name
            textColor = Color.BLACK.withAlpha(0xDE)
            textSize = 16F
          }

          textView {
            lparams {
              horizontalMargin = dip(16)
              verticalMargin = dip(2)
            }

            id = R.id.driver_birth
            textColor = Color.BLACK.withAlpha(0x8A)
            textSize = 12F
          }
        }

      }
    }
