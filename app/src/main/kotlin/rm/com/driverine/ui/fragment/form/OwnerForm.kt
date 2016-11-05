package rm.com.driverine.ui.fragment.form

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import common.component1
import common.component2
import common.component3
import common.orStub
import rm.com.ankoforms.FormBuilder
import rm.com.driverine.ext.formatDate
import rm.com.driverine.ext.formatName
import rm.com.driverine.ui.fragment.AdditionFragment
import rm.com.driverine.ui.fragment.constants.*
import rm.com.driverine.ui.fragment.events.onAddressChanged
import rm.com.driverine.ui.fragment.events.onDateSet
import rm.com.driverine.ui.fragment.events.onNameChanged
import java.util.*

/**
 * Created by alex
 */

fun FormBuilder<AdditionFragment>.ownerForm() {
  with(host) {
    header("Владелец")

    field {
      fieldName = "ФИО"
      dataFiller = { driver.owner?.formatName().orStub(PLACEHOLDER_NAME) }

      inputDialog {
        onClose = onNameChanged

        textInput {
          inputHint = "Фамилия"
          filler = { driver.owner?.last.orStub("Иванов") }
          key = KEY_INPUT_LAST_NAME
        }

        textInput {
          inputHint = "Имя"
          filler = { driver.owner?.first.orStub("Иван") }
          key = KEY_INPUT_FIRST_NAME
        }

        textInput {
          inputHint = "Отчество"
          filler = { driver.owner?.patronymic.orStub("Иванович") }
          key = KEY_INPUT_PATRONYMIC
        }
      }
    }

    field {
      fieldName = "Дата рождения"
      dataFiller = { driver.owner?.birthDate?.formatDate().orStub(PLACEHOLDER_BIRTH) }

      onFieldClick {
        val (year, month, day) = Calendar.getInstance().apply {
          driver.owner?.birthDate?.let { time = it }
        }

        val dpd = DatePickerDialog.newInstance(
            { dialog, year, month, day -> onDateSet(year, month, day) },
            year,
            month,
            day
        )

        dpd.show(fragmentManager, "dpd")
      }
    }

    singleField("Адрес", KEY_INPUT_ADDRESS, onAddressChanged) {
      driver.owner?.address.orStub(PLACEHOLDER_ADDRESS)
    }

    separator()
  }
}