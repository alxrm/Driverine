package rm.com.driverine.ui.item

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import common.color
import common.selectableBg
import org.jetbrains.anko.*
import rm.com.driverine.R
import rm.com.driverine.ext.inflateOptional

/**
 * Created by alex
 */

fun ViewGroup?.formFieldInputView(): View? =
    inflateOptional {
      verticalLayout {
        lparams(width = matchParent)

        isClickable = true
        backgroundColor = Color.WHITE

        verticalLayout {
          lparams(width = matchParent, height = dip(56)) {
            verticalGravity = Gravity.CENTER
          }

          backgroundResource = selectableBg()

          textView {
            lparams {
              horizontalMargin = dip(16)
              verticalMargin = dip(2)
            }

            id = R.id.form_field_input_data
            textColor = Color.BLACK.withAlpha(0xDE)
            textSize = 16F
          }

          textView {
            lparams {
              horizontalMargin = dip(16)
              verticalMargin = dip(2)
            }

            id = R.id.form_field_input_name
            textColor = Color.BLACK.withAlpha(0x8A)
            textSize = 12F
          }
        }

        view {
          lparams(width = matchParent, height = dip(0.5F))
          backgroundColor = color(R.color.color_separator)
        }
      }
    }
