package rm.com.ankoforms.fields

import android.app.Fragment
import rm.com.ankoforms.dialogs.DialogForm

/**
 * Created by alex
 */

class ListFormField<F : Fragment> : FormField<F, DialogForm<F>> {

  override var dialog: DialogForm<F>? = null

  var secondFiller: () -> String = { "" }
  var primaryFiller: () -> String = { "" }

  var key: String = ""
}