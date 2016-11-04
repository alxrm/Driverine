package rm.com.driverine.ui.item

import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import common.color
import org.jetbrains.anko.*
import rm.com.driverine.R
import rm.com.driverine.ext.inflateOptional

/**
 * Created by alex
 */

fun ViewGroup?.formHeaderView(): View? =
    inflateOptional {
      verticalLayout {
        lparams(width = matchParent, height = wrapContent) {
          topMargin = dip(8)
        }

        backgroundColor = Color.WHITE

        textView {
          lparams {
            topMargin = dip(18)
            bottomMargin = dip(8)
            horizontalMargin = dip(16)
          }

          id = R.id.form_header_text
          textColor = color(R.color.color_accent)
          textSize = 14F
          setTypeface(null, Typeface.BOLD)
        }
      }
    }