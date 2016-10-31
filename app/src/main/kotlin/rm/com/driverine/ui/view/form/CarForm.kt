package rm.com.driverine.ui.view.form

import org.jetbrains.anko._LinearLayout
import rm.com.driverine.ext.dialog
import rm.com.driverine.ext.field
import rm.com.driverine.ext.form
import rm.com.driverine.ext.input
import rm.com.driverine.ui.fragment.constants.*

/**
 * Created by alex
 */

inline fun _LinearLayout.carForm(
    inputFillers: Map<String, () -> String>,
    crossinline onBrandChange: (fields: Map<String, String>) -> String,
    crossinline onColorChange: (fields: Map<String, String>) -> String,
    crossinline onNumberChange: (fields: Map<String, String>) -> String
) {
  form("Автомобиль") {
    field(PLACEHOLDER_BRAND, "Марка", KEY_FIELD_BRAND) {
      dialog(onBrandChange) {
        input("Марка", KEY_INPUT_BRAND)
      }
    }

    field(PLACEHOLDER_COLOR, "Цвет", KEY_FIELD_COLOR) {
      dialog(onColorChange) {
        input("Цвет", KEY_INPUT_COLOR)
      }
    }

    field(PLACEHOLDER_NUMBER, "Номер", KEY_FIELD_NUMBER) {
      dialog(onNumberChange) {
        input("Номер", KEY_INPUT_NUMBER)
      }
    }
  }
}