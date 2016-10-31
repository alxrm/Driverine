package rm.com.driverine.ext

import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import common.color
import common.selectableBg
import org.jetbrains.anko.*
import rm.com.driverine.R

/**
 * Created by alex
 */

inline fun _LinearLayout.form(name: String, init: _LinearLayout.() -> Unit) {
  verticalLayout {
    lparams(width = matchParent, height = wrapContent) {
      topMargin = dip(8)
    }

    backgroundColor = Color.WHITE

    textView(name) {
      lparams {
        topMargin = dip(18)
        bottomMargin = dip(8)
        horizontalMargin = dip(16)
      }

      textColor = color(R.color.color_accent)
      textSize = 14F
      setTypeface(null, Typeface.BOLD)
    }

    init()

  }

  horizontalShadow()
}

inline fun _LinearLayout.field(
    fieldData: String,
    fieldName: String,
    key: String,
    crossinline onFieldClick: _LinearLayout.() -> Unit
) {
  verticalLayout {
    lparams(width = matchParent, height = dip(56)) {
      verticalGravity = Gravity.CENTER
    }

    isClickable = true
    backgroundResource = selectableBg()
    tag = listOf(key, fieldName)

    onClick {
      onFieldClick()
    }

    textView(fieldData) {
      lparams {
        horizontalMargin = dip(16)
        verticalMargin = dip(2)
      }

      tag = key
      textColor = Color.BLACK.withAlpha(0xDE)
      textSize = 16F
    }

    textView(fieldName) {
      lparams {
        horizontalMargin = dip(16)
        verticalMargin = dip(2)
      }

      textColor = Color.BLACK.withAlpha(0x8A)
      textSize = 12F
    }
  }

  view {
    lparams(width = matchParent, height = dip(0.5F))
    backgroundColor = color(R.color.color_separator)
  }
}

@Suppress("UNCHECKED_CAST")
inline fun _LinearLayout.dialog(
    crossinline onChange: (Map<String, String>) -> String,
    crossinline init: _LinearLayout.() -> Unit
) {
  val (key, name) = tag as List<String>
  var dialogView: LinearLayout? = null
  var data = mapOf<String, String>()

  context.alert {
    title(name)

    customView {
      dialogView = verticalLayout(init = init)
    }

    positiveButton("СОХРАНИТЬ") {
      dialogView?.forEachChild {
        it as? EditText ?: return@forEachChild

        data += it.tag.toString() to it.text.toString()
      }

      setTextByTag(key, onChange(data))
    }

    negativeButton("ОТМЕНИТЬ") {
      dismiss()
    }

    show()
  }
}

fun _LinearLayout.input(inputHint: String, key: String, init: () -> String = { "" }) {
  editText {
    lparams(width = matchParent) {
      verticalMargin = dip(4)
      horizontalMargin = dip(20)
    }

    tag = key
    hint = inputHint

    setText(init())
  }
}

fun _LinearLayout.setTextByTag(key: String, text: String) {
  (findViewWithTag(key) as? TextView)?.text = text
}