package rm.com.driverine.fm

import android.widget.ArrayAdapter
import org.jetbrains.anko.*

class SpinnerFormInput : FormInput {

  lateinit var key: String
  lateinit var elements: List<String>

  var filler: () -> Int = { 0 }

  override fun draw(into: _LinearLayout) {
    with(into) {
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