package rm.com.driverine.fm

import android.content.Context
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import org.jetbrains.anko.*

/**
 * Created by alex
 */

class InputDialogForm : DialogForm<Context> {

  var name: String = ""
  var inputs: List<FormInput> = emptyList()
  var onClose: (Map<String, String>) -> Unit = {}

  private lateinit var dialogLayout: LinearLayout
  private lateinit var data: Map<String, String>
  private var validated: Boolean = false

  override fun onOpen(owner: Context) {
    owner.alert {

      title(name)

      customView {
        dialogLayout = verticalLayout {
          lparams(width = matchParent) {
            horizontalPadding = dip(20)
          }

          inputs.forEach { it.draw(this) }
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
    }
  }
}