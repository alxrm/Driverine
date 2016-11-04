package rm.com.driverine.ui.item

import android.graphics.Color
import android.view.ViewGroup
import common.color
import common.selectableBg
import org.jetbrains.anko.*
import rm.com.driverine.R
import rm.com.driverine.ext.inflateOptional

/**
 * Created by alex
 */

fun ViewGroup?.formFieldListView() =
    inflateOptional {
      verticalLayout {
        lparams(width = matchParent)

        isClickable = true
        backgroundColor = Color.WHITE

        relativeLayout {
          lparams(width = matchParent, height = dip(48))

          backgroundResource = selectableBg()

          textView {
            lparams {
              horizontalMargin = dip(16)
              centerVertically()
            }

            id = R.id.form_field_list_primary
            textColor = Color.BLACK.withAlpha(0xDE)
            textSize = 16F
          }

          textView {
            lparams {
              horizontalMargin = dip(16)
              centerVertically()
              alignParentEnd()
            }

            id = R.id.form_field_list_secondary
            textColor = color(R.color.color_accent)
            textSize = 16F
          }
        }

        view {
          lparams(width = matchParent, height = dip(0.5F))
          backgroundColor = color(R.color.color_separator)
        }
      }
    }