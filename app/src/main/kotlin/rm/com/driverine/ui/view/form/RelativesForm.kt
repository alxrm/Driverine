package rm.com.driverine.ui.view.form

import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import common.color
import common.selectableBg
import org.jetbrains.anko.*
import rm.com.driverine.R

/**
 * Created by alex
 */
fun _LinearLayout.relativesForm() {
  verticalLayout {
    lparams(width = matchParent, height = wrapContent) {
      topMargin = dip(8)
    }

    backgroundColor = Color.WHITE

    textView("Семейное положение") {
      lparams {
        topMargin = dip(18)
        bottomMargin = dip(8)
        horizontalMargin = dip(16)
      }

      textColor = color(R.color.color_accent)
      textSize = 14F
      setTypeface(null, Typeface.BOLD)
    }

    relativeLayout {
      lparams(width = matchParent, height = dip(48))

      isClickable = true
      backgroundResource = selectableBg()

      textView("Иванов C. И.") {
        lparams {
          horizontalMargin = dip(16)
          centerVertically()
        }

        textColor = Color.BLACK.withAlpha(0xDE)
        textSize = 16F
      }

      textView("Сын") {
        lparams {
          horizontalMargin = dip(16)
          centerVertically()
          alignParentEnd()
        }

        textColor = color(R.color.color_accent)
        textSize = 16F
      }
    }

    view {
      lparams(width = matchParent, height = dip(0.5F))
      backgroundColor = color(R.color.color_separator)
    }

    textView("Добавить") {
      lparams(width = matchParent, height = dip(48)) {

      }

      isClickable = true
      backgroundResource = selectableBg()
      gravity = Gravity.CENTER
      textColor = color(R.color.color_accent)
      textSize = 16F
    }

  }
}