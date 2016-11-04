package rm.com.driverine.ui.holder

import android.view.View
import android.widget.TextView
import rm.com.ankoforms.elements.FormElement
import rm.com.ankoforms.elements.HeaderFormElement
import rm.com.driverine.R

/**
 * Created by alex
 */
class FormHeaderHolder(itemView: View?) : FormElementHolder(itemView) {

  val headerText by lazy { findOptional<TextView>(R.id.form_header_text) }

  override fun bind(model: FormElement) {
    val (name) = model as HeaderFormElement

    headerText?.text = name
  }
}