package rm.com.driverine.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import common.orStub
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.ctx
import rm.com.ankoforms.elements.FormElement
import rm.com.ankoforms.form
import rm.com.driverine.data.model.Car
import rm.com.driverine.data.model.Citizen
import rm.com.driverine.data.model.Driver
import rm.com.driverine.data.model.Relative
import rm.com.driverine.ext.formatName
import rm.com.driverine.ui.fragment.constants.*
import rm.com.driverine.ui.fragment.events.*
import rm.com.driverine.ui.layout.AdditionLayout
import java.util.*

/**
 * Created by alex
 */
class AdditionFragment : PageFragment() {

  override val name: String
    get() = "Добавить"

  val driver: Driver = Driver().apply {
    owner = Citizen()
    car = Car()
  }

  val relatives: List<Relative> = mutableListOf()

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
      AdditionLayout().createView(AnkoContext.create(ctx, this))

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}

fun AdditionFragment.additionForm(): List<FormElement> =
    form {
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
        dataFiller = { driver.owner?.birthDate?.toString().orStub(PLACEHOLDER_BIRTH) }

        onFieldClick {
          val birth = Calendar.getInstance()
          val dpd = DatePickerDialog.newInstance(
              { dialog, year, month, day -> onDateSet(year, month, day) },
              birth.get(Calendar.YEAR),
              birth.get(Calendar.MONTH),
              birth.get(Calendar.DAY_OF_MONTH)
          )

          dpd.show(fragmentManager, "dpd")
        }
      }

      singleField("Адрес", KEY_INPUT_BRAND, onAddressChanged) {
        driver.owner?.address.orStub(PLACEHOLDER_ADDRESS)
      }

      separator()

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

      header("Родственники")

      list(relatives) {
        primaryFiller = { it.relative?.formatName().orStub(PLACEHOLDER_NAME) }
        secondFiller = { it.type?.name.orStub(PLACEHOLDER_RELATIVE) }
        key = "${KEY_INPUT_RELATIVE}_${it.id}"
      }

      buttonField {
        name = "Добавить"
      }

      separator()
    }