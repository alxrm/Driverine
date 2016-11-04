package rm.com.driverine.ui.holder

import android.view.View
import android.widget.TextView
import rm.com.ankoforms.elements.FormElement
import rm.com.ankoforms.fields.ButtonFormField
import rm.com.driverine.R
import rm.com.driverine.ui.fragment.AdditionFragment

/**
 * Created by alex
 */
class FormFieldButtonHolder(itemView: View?) : FormElementHolder(itemView) {

  val name by lazy { findOptional<TextView>(R.id.form_field_button) }

  @Suppress("UNCHECKED_CAST")
  override fun bind(model: FormElement) {
    val elem = model as ButtonFormField<AdditionFragment>

    name?.text = elem.name

    onClick {
      elem.dialog?.let {
        with(it) { holder.onOpen() }
      }
    }
  }

}