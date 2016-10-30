package rm.com.driverine.ui.form

/**
 * Created by alex
 */

data class Form(
    val name: String,
    val inputs: List<FormInput>
)

data class FormInput(
    val title: String = "",
    var data: String = "",
    val dialog: DialogForm? = null,
    val onClick: () -> Unit = {}
)

data class DialogForm(
    val name: String,
    val inputs: List<DialogInput>,
    val onNextData: DialogForm.() -> String,
    val onClose: (Map<String, String>) -> Unit
)

data class DialogInput(
    val hint: String = "",
    val key: String = "",
    var data: String = "",
    val onValidate: (String) -> Boolean
)