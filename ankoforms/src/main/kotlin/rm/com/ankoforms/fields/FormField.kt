package rm.com.ankoforms.fields

import android.app.Fragment
import rm.com.ankoforms.dialogs.DialogForm
import rm.com.ankoforms.elements.FormElement

/**
 * Created by alex
 */

interface FormField<F : Fragment, D : DialogForm<F>> : FormElement {
  var dialog: D?
}