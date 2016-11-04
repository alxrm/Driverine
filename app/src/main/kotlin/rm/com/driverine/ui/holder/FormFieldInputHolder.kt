package rm.com.driverine

import android.view.View
import android.widget.TextView
import rm.com.ankoforms.elements.FormElement
import rm.com.ankoforms.fields.InputFormField
import rm.com.driverine.ui.fragment.AdditionFragment
import rm.com.driverine.ui.holder.FormElementHolder
import rm.com.driverine.ui.holder.findOptional
import rm.com.driverine.ui.holder.onClick

/**
 * Created by alex
 */
class FormFieldInputHolder(itemView: View?) : FormElementHolder(itemView) {

  val data by lazy { findOptional<TextView>(R.id.form_field_input_data) }
  val name by lazy { findOptional<TextView>(R.id.form_field_input_name) }

  @Suppress("UNCHECKED_CAST")
  override fun bind(model: FormElement) {
    val elem = model as InputFormField<AdditionFragment>

    data?.text = elem.dataFiller()
    name?.text = elem.fieldName

    onClick {
      elem.dialog?.let {
        with(it) { holder.onOpen() }
      }
    }
  }

}