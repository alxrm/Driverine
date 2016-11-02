package rm.com.driverine.fm

import android.content.Context
import android.widget.LinearLayout
import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.alert
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.verticalLayout

class LayoutDialogForm : DialogForm<Context> {

  var name: String = ""
  var onLayout: _LinearLayout.() -> Unit = {}
  var onExtract: () -> Map<String, String> = { mapOf() }
  var onClose: (Map<String, String>) -> Unit = {}

  lateinit var dialogLayout: LinearLayout
    private set

  override fun onOpen(owner: Context) {
    owner.alert {
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
    }
  }
}