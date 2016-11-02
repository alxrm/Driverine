package rm.com.driverine.fm

/**
 * Created by alex
 */

open class FormField<H, T : DialogForm<*>>() : FormElement {
  lateinit var dialog: T

  var holder: H? = null
  var name: String = ""
  var dataFiller: H.() -> String = { "" }
  var key: String = ""
}