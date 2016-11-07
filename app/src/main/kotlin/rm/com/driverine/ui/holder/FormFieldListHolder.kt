package rm.com.driverine.ui.holder

import android.view.View
import android.widget.TextView
import rm.com.ankoforms.elements.FormElement
import rm.com.ankoforms.fields.ListFormField
import rm.com.driverine.R
import rm.com.driverine.ui.fragment.AdditionFragment

/**
 * Created by alex
 */
class FormFieldListHolder(itemView: View?) : FormElementHolder(itemView) {

  private val primary by lazy { findOptional<TextView>(R.id.form_field_list_primary) }
  private val secondary by lazy { findOptional<TextView>(R.id.form_field_list_secondary) }

  @Suppress("UNCHECKED_CAST")
  override fun bind(model: FormElement) {
    val elem = model as ListFormField<AdditionFragment>

    primary?.text = elem.primaryFiller()
    secondary?.text = elem.secondFiller()

    onClick {
      elem.dialog?.let {
        with(it) { holder.onOpen() }
      }
    }
  }

}