package rm.com.ankoforms.fields

import android.app.Fragment
import rm.com.ankoforms.dialogs.DialogForm

/**
 * Created by alex
 */

class ButtonFormField<F : Fragment> : FormField<F, DialogForm<F>> {

  override var dialog: DialogForm<F>? = null

  var name: String = ""
}