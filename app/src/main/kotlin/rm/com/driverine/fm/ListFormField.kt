package rm.com.driverine.fm

/**
 * Created by alex
 */

class ListFormField<H, T : DialogForm<*>> : FormElement {
  lateinit var dialog: T

  var holder: H? = null
  var secondFiller: H.() -> String = { "" }
  var primaryFiller: H.() -> String = { "" }
  var key: String = ""
}