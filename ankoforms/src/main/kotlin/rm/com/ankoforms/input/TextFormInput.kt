package rm.com.ankoforms.input

import org.jetbrains.anko.*

class TextFormInput : FormInput {

  var validator: (String) -> Boolean = String::isNotEmpty
  var filler: () -> String = { "" }
  var inputHint: String = ""

  lateinit var key: String

  override fun attachTo(host: _LinearLayout) {
    with(host) {
      editText {
        lparams(width = matchParent) {
          verticalMargin = dip(4)
        }

        tag = key
        hint = inputHint

        setText(filler())

        textChangedListener {
          afterTextChanged {
            val inputStr = it?.toString().orEmpty()

            if (!validator(inputStr)) error = "Неверный формат"
          }
        }
      }
    }
  }
}