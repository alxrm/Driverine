package rm.com.ankoforms

import android.app.Fragment
import rm.com.ankoforms.dialogs.CustomDialogForm
import rm.com.ankoforms.dialogs.DialogForm
import rm.com.ankoforms.dialogs.InputDialogForm
import rm.com.ankoforms.dialogs.LayoutDialogForm
import rm.com.ankoforms.elements.FormElement
import rm.com.ankoforms.elements.HeaderFormElement
import rm.com.ankoforms.elements.SeparatorFormElement
import rm.com.ankoforms.fields.ButtonFormField
import rm.com.ankoforms.fields.InputFormField
import rm.com.ankoforms.fields.ListFormField
import rm.com.ankoforms.input.SpinnerFormInput
import rm.com.ankoforms.input.TextFormInput

/**
 * Created by alex
 */

class FormBuilder<F : Fragment>(val host: F) {

  val formElements = mutableListOf<FormElement>()

  inline fun header(init: HeaderFormElement.() -> Unit) =
      formElements.add(HeaderFormElement().apply(init))

  fun header(name: String) =
      header { this.name = name }

  fun separator() =
      formElements.add(SeparatorFormElement())

  inline fun field(init: InputFormField<F>.() -> Unit): InputFormField<F> {
    val f = InputFormField<F>().apply(init)
    formElements.add(f)
    return f
  }

  inline fun buttonField(init: ButtonFormField<F>.() -> Unit): ButtonFormField<F> {
    val f = ButtonFormField<F>().apply(init)
    formElements.add(f)
    return f
  }

  inline fun listField(init: ListFormField<F>.() -> Unit): ListFormField<F> {
    val f = ListFormField<F>().apply(init)
    formElements.add(f)
    return f
  }

  fun singleField(
      name: String,
      key: String,
      onChange: (Map<String, String>) -> Unit = {},
      filler: () -> String = { "" }
  ): InputFormField<F> {
    val f = InputFormField<F>().apply {
      fieldName = name
      dataFiller = filler

      inputDialog {
        dialogName = name
        onClose = onChange

        textInput {
          this.inputHint = name
          this.filler = filler
          this.key = key
        }
      }
    }

    formElements.add(f)
    return f
  }

  inline fun <T> list(data: List<T> = emptyList(), transform: ListFormField<F>.(T) -> Unit) =
      data.map({ listField { transform(it) } })

  inline fun InputFormField<F>.inputDialog(init: InputDialogForm<F>.() -> Unit) =
      dialog(InputDialogForm<F>()) { dialogName = fieldName; init() }

  inline fun InputFormField<F>.layoutDialog(init: LayoutDialogForm<F>.() -> Unit) =
      dialog(LayoutDialogForm<F>(), init)

  inline fun InputFormField<F>.customDialog(init: CustomDialogForm<F>.() -> Unit) =
      dialog(CustomDialogForm<F>(), init)

  fun InputFormField<F>.onFieldClick(init: F.() -> Unit) {
    customDialog { onOpen = init }
  }

  inline fun <D : DialogForm<F>> InputFormField<F>.dialog(dialogForm: D, init: D.() -> Unit) {
    dialog = dialogForm.apply {
      holder = host
      init()
    }
  }

  inline fun ButtonFormField<F>.inputDialog(init: InputDialogForm<F>.() -> Unit) =
      dialog(InputDialogForm<F>(), init)

  inline fun ButtonFormField<F>.layoutDialog(init: LayoutDialogForm<F>.() -> Unit) =
      dialog(LayoutDialogForm<F>(), init)

  inline fun ButtonFormField<F>.customDialog(init: CustomDialogForm<F>.() -> Unit) =
      dialog(CustomDialogForm<F>(), init)

  fun ButtonFormField<F>.onFieldClick(init: F.() -> Unit) {
    customDialog { onOpen = init }
  }

  inline fun <D : DialogForm<F>> ButtonFormField<F>.dialog(dialogForm: D, init: D.() -> Unit) {
    dialog = dialogForm.apply {
      holder = host
      init()
    }
  }

  inline fun ListFormField<F>.inputDialog(init: InputDialogForm<F>.() -> Unit) =
      dialog(InputDialogForm<F>(), init)

  inline fun ListFormField<F>.layoutDialog(init: LayoutDialogForm<F>.() -> Unit) =
      dialog(LayoutDialogForm<F>(), init)

  inline fun ListFormField<F>.customDialog(init: CustomDialogForm<F>.() -> Unit) =
      dialog(CustomDialogForm<F>(), init)

  fun ListFormField<F>.onFieldClick(init: F.() -> Unit) {
    customDialog { onOpen = init }
  }

  inline fun <D : DialogForm<F>> ListFormField<F>.dialog(dialogForm: D, init: D.() -> Unit) {
    dialog = dialogForm.apply {
      holder = host
      init()
    }
  }

  inline fun InputDialogForm<F>.textInput(init: TextFormInput.() -> Unit) {
    inputs += TextFormInput().apply(init)
  }

  inline fun InputDialogForm<F>.selectorInput(init: SpinnerFormInput.() -> Unit) {
    inputs += SpinnerFormInput().apply(init)
  }
}

inline fun <F : Fragment> F.form(init: FormBuilder<F>.() -> Unit): List<FormElement> {
  val builder = FormBuilder(this)
  builder.init()
  return builder.formElements.toList()
}