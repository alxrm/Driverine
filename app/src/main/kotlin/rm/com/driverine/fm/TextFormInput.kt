package rm.com.driverine.fm

import org.jetbrains.anko.*

class TextFormInput : FormInput {

  lateinit var inputHint: String
  lateinit var key: String

  var validator: (String) -> Boolean = String::isNotEmpty
  var filler: () -> String = { "" }

  override fun draw(into: _LinearLayout) {
    with(into) {
      editText {
        lparams(width = matchParent) {
          verticalMargin = dip(4)
        }

        tag = key
        hint = inputHint

        setText(filler())
      }
    }
  }
}