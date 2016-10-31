package rm.com.driverine.ui.fragment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.ctx
import rm.com.driverine.data.model.Driver
import rm.com.driverine.ui.adapter.DriverListAdapter
import rm.com.driverine.ui.view.layout.DriversListLayout
import rm.com.driverine.ui.view.layout.add

/**
 * Created by alex
 */

class DriversListFragment : PageFragment() {

  override val name: String
    get() = "Автовладельцы"

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
      DriversListLayout().createView(AnkoContext.create(ctx, this))

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  override fun onResume() {
    super.onResume()
    owner.add.show()
    // TODO reload entities
  }

  override fun onPause() {
    super.onPause()
    owner.add.hide()
  }
}

private fun RecyclerView.update(drivers: List<Driver>) =
    (adapter as DriverListAdapter).updateData(drivers)