package rm.com.ankoforms.dialogs

import android.app.Fragment

class CustomDialogForm<F : Fragment> : DialogForm<F>() {
  override var onOpen: F.() -> Unit = {}
}