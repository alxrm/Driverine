package rm.com.ankoforms.dialogs

import android.app.Fragment
import android.widget.LinearLayout
import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.alert
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.verticalLayout

class LayoutDialogForm<F : Fragment> : DialogForm<F>() {

  var name: String = ""
  var onLayout: _LinearLayout.() -> Unit = {}
  var onExtract: () -> Map<String, String> = { mapOf() }
  var onClose: (Map<String, String>) -> Unit = {}

  lateinit var dialogLayout: LinearLayout
    private set

  override var onOpen: F.() -> Unit
    set(value) = Unit
    get() = {
      alert {
        title(name)

        customView {
          dialogLayout = verticalLayout {
            lparams(width = matchParent)

            onLayout()
          }
        }

        noButton {
          dismiss()
        }

        yesButton {
          onClose(onExtract())
        }

        show()
      }
    }
}