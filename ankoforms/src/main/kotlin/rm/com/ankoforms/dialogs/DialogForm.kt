package rm.com.ankoforms.dialogs

import android.app.Fragment

/**
 * Created by alex
 */

open class DialogForm<F : Fragment> {
  lateinit var holder: F
  open var onOpen: F.() -> Unit = {}
}