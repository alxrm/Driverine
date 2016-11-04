package rm.com.driverine.ui.item

import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import common.color
import common.selectableBg
import org.jetbrains.anko.*
import rm.com.driverine.R
import rm.com.driverine.ext.inflateOptional

/**
 * Created by alex
 */

fun ViewGroup?.formFieldButtonView() =
    inflateOptional {
      verticalLayout {
        lparams(width = matchParent)

        isClickable = true
        backgroundColor = Color.WHITE

        textView {
          lparams(width = matchParent, height = dip(48))

          id = R.id.form_field_button
          backgroundResource = selectableBg()
          gravity = Gravity.CENTER
          textColor = color(R.color.color_accent)
          textSize = 16F
        }
      }
    }