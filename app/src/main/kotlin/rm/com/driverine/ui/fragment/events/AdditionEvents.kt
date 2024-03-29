package rm.com.driverine.ui.fragment.events

import common.toIntSafely
import rm.com.driverine.data.model.Citizen
import rm.com.driverine.data.model.Relative
import rm.com.driverine.ui.fragment.AdditionFragment
import rm.com.driverine.ui.fragment.constants.*
import rm.com.driverine.util.ext.dateOf
import rm.com.driverine.util.ext.relationships

/**
 * Created by alex
 */

val AdditionFragment.onNameChanged: (inputs: Map<String, String>) -> Unit
  get() = {
    driver.owner?.apply {
      last = it[KEY_INPUT_LAST_NAME]
      first = it[KEY_INPUT_FIRST_NAME]
      patronymic = it[KEY_INPUT_PATRONYMIC]
      save()
    }

    refreshForm()
  }

val AdditionFragment.onAddressChanged: (inputs: Map<String, String>) -> Unit
  get() = {
    driver.owner?.apply {
      address = it[KEY_INPUT_ADDRESS]
      save()
    }

    refreshForm()
  }

val AdditionFragment.onExperienceChanged: (inputs: Map<String, String>) -> Unit
  get() = {
    driver.owner?.apply {
      experience = it[KEY_INPUT_EXPERIENCE].toIntSafely(1)
      save()
    }

    refreshForm()
  }

val AdditionFragment.onDateSet: (year: Int, monthOfYear: Int, dayOfMonth: Int) -> Unit
  get() = { year: Int, monthOfYear: Int, dayOfMonth: Int ->
    driver.owner?.apply {
      birthDate = dateOf(year, monthOfYear, dayOfMonth)
      save()
    }

    refreshForm()
  }

val AdditionFragment.onBrandChange: (Map<String, String>) -> Unit
  get() = {
    driver.car?.apply {
      brand = it[KEY_INPUT_BRAND]
      save()
    }

    refreshForm()
  }

val AdditionFragment.onColorChange: (Map<String, String>) -> Unit
  get() = {
    driver.car?.apply {
      color = it[KEY_INPUT_COLOR]
      save()
    }

    refreshForm()
  }

val AdditionFragment.onNumberChange: (Map<String, String>) -> Unit
  get() = {
    driver.car?.apply {
      number = it[KEY_INPUT_NUMBER]
      save()
    }

    refreshForm()
  }

val AdditionFragment.onRelativeAdded: (Map<String, String>) -> Unit
  get() = {
    Relative().apply {
      carOwner = driver.owner
      type = relationships[it[KEY_INPUT_TYPE]]
      relative = Citizen().apply {
        last = it[KEY_INPUT_LAST_NAME]
        first = it[KEY_INPUT_FIRST_NAME]
        patronymic = it[KEY_INPUT_PATRONYMIC]
        experience = it[KEY_INPUT_EXPERIENCE].toIntSafely(1)
        insert()
      }

      relatives += this
      save()

      refreshForm()
    }
  }