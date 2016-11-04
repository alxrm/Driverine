package rm.com.ankoforms.input

import android.widget.ArrayAdapter
import org.jetbrains.anko.*

class SpinnerFormInput : FormInput {

  var filler: () -> Int = { 0 }

  lateinit var key: String
  lateinit var elements: List<String>

  override fun attachTo(host: _LinearLayout) {
    with(host) {
      spinner {
        lparams(width = matchParent) {
          verticalMargin = dip(4)
        }

        tag = key
        adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, elements)
        setSelection(filler())
      }
    }
  }
}