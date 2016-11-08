package rm.com.driverine.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import common.inUiDelayed
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.ctx
import rm.com.driverine.data.repo.DriversRepository
import rm.com.driverine.ui.adapter.DriverListAdapter
import rm.com.driverine.ui.layout.DriversListLayout
import rm.com.driverine.ui.layout.add

/**
 * Created by alex
 */

class DriversListFragment : PageFragment() {

  override val name: String
    get() = "Автовладельцы"

  val driverAdapter = DriverListAdapter()

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
      DriversListLayout().createView(AnkoContext.create(ctx, this))

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  override fun onResume() {
    super.onResume()

    inUiDelayed(250) {
      owner.add.show()
      updateDrivers()
    }
  }

  override fun onPause() {
    super.onPause()
    owner.add.hide()
  }

  fun updateDrivers() {
    val drivers = DriversRepository.allDrivers()

    driverAdapter.updateData(drivers)
  }
}