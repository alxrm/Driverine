package rm.com.driverine.ui.item

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import common.imageDrawable
import common.selectableBg
import common.vectorOf
import org.jetbrains.anko.*
import rm.com.driverine.R
import rm.com.driverine.util.ext.inflateOptional

/**
 * Created by alex
 */

fun ViewGroup?.driverItemView(): View? =
    inflateOptional {
      relativeLayout {
        lparams(width = matchParent, height = dip(72))

        isClickable = true
        backgroundResource = selectableBg()

        verticalLayout {
          lparams(height = matchParent) {
            verticalPadding = dip(16)
          }

          id = R.id.driver_credits

          textView {
            lparams {
              horizontalMargin = dip(16)
            }

            id = R.id.driver_name
            textColor = Color.BLACK.withAlpha(0xDE)
            textSize = 16F
          }

          textView {
            lparams {
              horizontalMargin = dip(16)
            }

            id = R.id.driver_birth
            textColor = Color.BLACK.withAlpha(0x8A)
            textSize = 14F
          }
        }

        imageView {
          lparams(width = dip(48), height = dip(48)) {
            centerVertically()
            alignParentEnd()
            horizontalMargin = dip(12)
            padding = dip(12)
          }

          id = R.id.driver_car
          backgroundResource = R.drawable.bg_clickable
          imageDrawable = vectorOf(R.drawable.ic_car_24dp)
          isClickable = true
        }

        imageView {
          lparams(width = dip(48), height = dip(48)) {
            centerVertically()
            leftOf(R.id.driver_car)
            padding = dip(12)
          }

          id = R.id.driver_relatives
          backgroundResource = R.drawable.bg_clickable
          imageDrawable = vectorOf(R.drawable.ic_people_24dp)
          isClickable = true
        }
      }
    }
