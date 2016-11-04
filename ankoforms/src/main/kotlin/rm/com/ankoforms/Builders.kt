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

class __FormBuilder<H : Fragment>(val host: H) {

  val formElements = mutableListOf<FormElement>()

  inline fun header(init: HeaderFormElement.() -> Unit) =
      formElements.add(HeaderFormElement().apply(init))

  fun header(name: String) =
      header { this.name = name }

  fun separator() =
      formElements.add(SeparatorFormElement())

  inline fun field(init: InputFormField<H>.() -> Unit): InputFormField<H> {
    val f = InputFormField<H>().apply(init)
    formElements.add(f)
    return f
  }

  inline fun buttonField(init: ButtonFormField<H>.() -> Unit): ButtonFormField<H> {
    val f = ButtonFormField<H>().apply(init)
    formElements.add(f)
    return f
  }

  inline fun listField(init: ListFormField<H>.() -> Unit): ListFormField<H> {
    val f = ListFormField<H>().apply(init)
    formElements.add(f)
    return f
  }

  fun singleField(
      name: String,
      key: String,
      onChange: (Map<String, String>) -> Unit = {},
      filler: () -> String = { "" }
  ): InputFormField<H> {
    val f = InputFormField<H>().apply {
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

  inline fun <T> list(data: List<T> = emptyList(), transform: ListFormField<H>.(T) -> Unit) =
      data.map({ listField { transform(it) } })

  inline fun InputFormField<H>.inputDialog(init: InputDialogForm<H>.() -> Unit) =
      dialog(InputDialogForm<H>()) { dialogName = fieldName; init() }

  inline fun InputFormField<H>.layoutDialog(init: LayoutDialogForm<H>.() -> Unit) =
      dialog(LayoutDialogForm<H>(), init)

  inline fun InputFormField<H>.customDialog(init: CustomDialogForm<H>.() -> Unit) =
      dialog(CustomDialogForm<H>(), init)

  fun InputFormField<H>.onFieldClick(init: H.() -> Unit) {
    customDialog { onOpen = init }
  }

  inline fun <D : DialogForm<H>> InputFormField<H>.dialog(dialogForm: D, init: D.() -> Unit) {
    dialog = dialogForm.apply {
      holder = host
      init()
    }
  }

  inline fun ButtonFormField<H>.inputDialog(init: InputDialogForm<H>.() -> Unit) =
      dialog(InputDialogForm<H>(), init)

  inline fun ButtonFormField<H>.layoutDialog(init: LayoutDialogForm<H>.() -> Unit) =
      dialog(LayoutDialogForm<H>(), init)

  inline fun ButtonFormField<H>.customDialog(init: CustomDialogForm<H>.() -> Unit) =
      dialog(CustomDialogForm<H>(), init)

  fun ButtonFormField<H>.onFieldClick(init: H.() -> Unit) {
    customDialog { onOpen = init }
  }

  inline fun <D : DialogForm<H>> ButtonFormField<H>.dialog(dialogForm: D, init: D.() -> Unit) {
    dialog = dialogForm.apply {
      holder = host
      init()
    }
  }

  inline fun ListFormField<H>.inputDialog(init: InputDialogForm<H>.() -> Unit) =
      dialog(InputDialogForm<H>(), init)

  inline fun ListFormField<H>.layoutDialog(init: LayoutDialogForm<H>.() -> Unit) =
      dialog(LayoutDialogForm<H>(), init)

  inline fun ListFormField<H>.customDialog(init: CustomDialogForm<H>.() -> Unit) =
      dialog(CustomDialogForm<H>(), init)

  fun ListFormField<H>.onFieldClick(init: H.() -> Unit) {
    customDialog { onOpen = init }
  }

  inline fun <D : DialogForm<H>> ListFormField<H>.dialog(dialogForm: D, init: D.() -> Unit) {
    dialog = dialogForm.apply {
      holder = host
      init()
    }
  }

  inline fun InputDialogForm<H>.textInput(init: TextFormInput.() -> Unit) {
    inputs += TextFormInput().apply(init)
  }

  inline fun InputDialogForm<H>.selectorInput(init: SpinnerFormInput.() -> Unit) {
    inputs += SpinnerFormInput().apply(init)
  }
}

inline fun <T : Fragment> T.form(init: __FormBuilder<T>.() -> Unit): List<FormElement> {
  val builder = __FormBuilder(this)
  builder.init()
  return builder.formElements.toList()
}