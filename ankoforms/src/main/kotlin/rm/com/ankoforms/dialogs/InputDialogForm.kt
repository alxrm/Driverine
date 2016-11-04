package rm.com.ankoforms.dialogs

import android.app.Fragment
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import org.jetbrains.anko.*
import rm.com.ankoforms.input.FormInput
import rm.com.ankoforms.input.TextFormInput

/**
 * Created by alex
 */

class InputDialogForm<F : Fragment> : DialogForm<F>() {

  var dialogName: String = ""
  var inputs: List<FormInput> = emptyList()
  var onClose: (Map<String, String>) -> Unit = {}

  private var data: Map<String, String> = mapOf()
  private var validated: Boolean = false

  private lateinit var dialogLayout: LinearLayout

  override var onOpen: F.() -> Unit
    set(value) = Unit
    get() = {
      alert {
        title(dialogName)

        customView {
          dialogLayout = verticalLayout {
            lparams(width = matchParent) {
              horizontalPadding = dip(20)
            }

            inputs.forEach { it.attachTo(this) }
          }
        }

        noButton {
          dismiss()
        }

        yesButton {
          dialogLayout.forEachChild {
            when (it) {
              is EditText -> data += it.getTag().toString() to it.text.toString()
              is Spinner -> data += it.getTag().toString() to it.selectedItem.toString()
            }
          }

          validated = inputs.any {
            it is TextFormInput && !it.validator(data[it.key].orEmpty())
          }

          when (validated) {
            false -> onClose(data)
            else -> Unit
          }
        }

        show()
      }
    }
}