package rm.com.driverine.ui.view.form

import android.app.FragmentManager
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import org.jetbrains.anko._LinearLayout
import rm.com.driverine.ext.*
import rm.com.driverine.ui.fragment.constants.*
import java.util.*

/**
 * Created by alex
 */

inline fun _LinearLayout.ownerForm(
    fragmentManager: FragmentManager,
    inputFillers: Map<String, () -> String>,
    crossinline onChangeName: (fields: Map<String, String>) -> String,
    crossinline onChangeAddress: (fields: Map<String, String>) -> String,
    noinline onDateSet: (year: Int, monthOfYear: Int, dayOfMonth: Int) -> Unit
) {
  form("Владелец") {
    field(PLACEHOLDER_NAME, "ФИО", KEY_FIELD_NAME) {
      dialog(onChangeName) {
        input("Фамилия", KEY_INPUT_LAST_NAME)

        input("Имя", KEY_INPUT_FIRST_NAME)

        input("Отчество", KEY_INPUT_PATRONYMIC)
      }
    }

    field(PLACEHOLDER_BIRTH, "Дата рождения", KEY_FIELD_BIRTH) {
      val birth = Calendar.getInstance()
      val dpd = DatePickerDialog.newInstance(
          { dialog, year, month, day ->
            setTextByTag(KEY_FIELD_BIRTH, formatDateOf(year, month, day))
            onDateSet(year, month, day)
          },
          birth.get(Calendar.YEAR),
          birth.get(Calendar.MONTH),
          birth.get(Calendar.DAY_OF_MONTH)
      )

      dpd.show(fragmentManager, "dpd")
    }

    field(PLACEHOLDER_ADDRESS, "Адрес", KEY_FIELD_ADDRESS) {
      dialog(onChangeAddress) {
        input("Адрес", KEY_INPUT_ADDRESS)
      }
    }
  }
}