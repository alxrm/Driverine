package rm.com.ankoforms.input

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ArrayAdapter
import org.jetbrains.anko.*

class SpinnerFormInput : FormInput {

  var filler: () -> Int = { 0 }
  var selectorName: String = ""

  lateinit var key: String
  lateinit var items: List<String>

  override fun attachTo(host: _LinearLayout) {
    with(host) {
      textView {

        textSize = 12F
        text = selectorName

        visibility = if (selectorName.isNullOrBlank()) GONE else VISIBLE
      }

      spinner {
        lparams(width = matchParent) {
          verticalMargin = dip(4)
        }

        tag = key
        adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, items)
        setSelection(filler())
      }
    }
  }
}