package rm.com.driverine.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import rm.com.ankoforms.elements.FormElement
import rm.com.ankoforms.elements.HeaderFormElement
import rm.com.ankoforms.elements.SeparatorFormElement
import rm.com.ankoforms.fields.ButtonFormField
import rm.com.ankoforms.fields.InputFormField
import rm.com.ankoforms.fields.ListFormField
import rm.com.driverine.ui.holder.*
import rm.com.driverine.ui.layout.item.*

/**
 * Created by alex
 */
const val VIEW_TYPE_UNDEFINED = -1
const val VIEW_TYPE_HEADER = 0
const val VIEW_TYPE_SEPARATOR = 1
const val VIEW_TYPE_FIELD_INPUT = 2
const val VIEW_TYPE_FIELD_LIST = 3
const val VIEW_TYPE_FIELD_BUTTON = 4

class FormAdapter(var elements: List<FormElement> = emptyList()) : RecyclerView.Adapter<FormElementHolder>() {

  override fun getItemViewType(position: Int): Int =
      when (elements[position]) {
        is HeaderFormElement -> VIEW_TYPE_HEADER
        is SeparatorFormElement -> VIEW_TYPE_SEPARATOR
        is InputFormField<*> -> VIEW_TYPE_FIELD_INPUT
        is ListFormField<*> -> VIEW_TYPE_FIELD_LIST
        is ButtonFormField<*> -> VIEW_TYPE_FIELD_BUTTON
        else -> VIEW_TYPE_UNDEFINED
      }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FormElementHolder =
      when (viewType) {
        VIEW_TYPE_HEADER -> FormHeaderHolder(parent.formHeaderView())
        VIEW_TYPE_SEPARATOR -> FormSeparatorHolder(parent.formSeparatorView())
        VIEW_TYPE_FIELD_INPUT -> FormFieldInputHolder(parent.formFieldInputView())
        VIEW_TYPE_FIELD_LIST -> FormFieldListHolder(parent.formFieldListView())
        VIEW_TYPE_FIELD_BUTTON -> FormFieldButtonHolder(parent.formFieldButtonView())
        else -> error("Wrong view type passed in")
      }

  override fun getItemCount(): Int = elements.size

  override fun onBindViewHolder(holder: FormElementHolder?, position: Int) =
      holder?.bind(elements[position]) ?: Unit

  fun updateData(next: List<FormElement>) {
    elements = next
    notifyDataSetChanged()
  }
}