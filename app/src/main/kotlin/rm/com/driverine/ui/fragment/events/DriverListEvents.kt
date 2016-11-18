package rm.com.driverine.ui.fragment.events

import org.jetbrains.anko.withArguments
import rm.com.driverine.data.model.Driver
import rm.com.driverine.ui.fragment.AdditionFragment
import rm.com.driverine.ui.fragment.DriversListFragment
import rm.com.driverine.ui.fragment.constants.EXTRAS_KEY_DRIVER_ID
import rm.com.driverine.ui.fragment.owner

/**
 * Created by alex
 */
val DriversListFragment.onOpenDriver: (Driver) -> Unit
  get() = {
    owner.switchFragment(AdditionFragment().withArguments(EXTRAS_KEY_DRIVER_ID to it.id))
  }