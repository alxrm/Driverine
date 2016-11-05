package rm.com.driverine.ui.fragment.form

import common.orStub
import rm.com.ankoforms.FormBuilder
import rm.com.driverine.ui.fragment.AdditionFragment
import rm.com.driverine.ui.fragment.constants.*
import rm.com.driverine.ui.fragment.events.onBrandChange
import rm.com.driverine.ui.fragment.events.onColorChange
import rm.com.driverine.ui.fragment.events.onNumberChange

/**
 * Created by alex
 */

fun FormBuilder<AdditionFragment>.carForm() {
  with(host) {
    header("Автомобиль")

    singleField("Марка", KEY_INPUT_BRAND, onBrandChange) {
      driver.car?.brand.orStub(PLACEHOLDER_BRAND)
    }

    singleField("Цвет", KEY_INPUT_COLOR, onColorChange) {
      driver.car?.color.orStub(PLACEHOLDER_COLOR)
    }

    singleField("Номер", KEY_INPUT_NUMBER, onNumberChange) {
      driver.car?.number.orStub(PLACEHOLDER_NUMBER)
    }

    separator()
  }
}