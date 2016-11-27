package rm.com.driverine.ui.fragment.form

import common.orStub
import rm.com.ankoforms.FormBuilder
import rm.com.driverine.data.model.Relative
import rm.com.driverine.ui.fragment.AdditionFragment
import rm.com.driverine.ui.fragment.constants.*
import rm.com.driverine.ui.fragment.events.onRelativeAdded
import rm.com.driverine.util.ext.formatName
import rm.com.driverine.util.ext.relationships
import rm.com.driverine.util.ext.toReadableString

/**
 * Created by alex
 */

fun FormBuilder<AdditionFragment>.relativesForm(createdRelatives: List<Relative> = emptyList()) {
  with(host) {
    header("Родственники")

    list(createdRelatives) {
      primaryFiller = { it.relative?.formatName().orStub(PLACEHOLDER_NAME) }
      secondFiller = { it.type.toReadableString().orStub(PLACEHOLDER_RELATIVE) }

      key = "${KEY_INPUT_RELATIVE}_${it.id}"
    }

    buttonField {
      name = "Добавить"

      inputDialog {
        dialogName = "Родственник"
        onClose = onRelativeAdded

        textInput {
          inputHint = "Фамилия"
          key = KEY_INPUT_LAST_NAME
        }

        textInput {
          inputHint = "Имя"
          key = KEY_INPUT_FIRST_NAME
        }

        textInput {
          inputHint = "Отчество"
          key = KEY_INPUT_PATRONYMIC
        }

        textInput {
          inputHint = "Стаж"
          key = KEY_INPUT_EXPERIENCE
        }

        selectorInput {
          selectorName = "Родственная связь"
          items = relationships.keys.toList()
          key = KEY_INPUT_TYPE
        }
      }
    }

    separator()
  }
}