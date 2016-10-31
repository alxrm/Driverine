package rm.com.driverine.ui.view.layout

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import rm.com.driverine.R
import rm.com.driverine.data.model.Driver
import rm.com.driverine.ui.adapter.DriverListAdapter
import rm.com.driverine.ui.presenter.DriversListFragment

/**
 * Created by alex
 */

class DriversListLayout : AnkoComponent<DriversListFragment> {
  override fun createView(ui: AnkoContext<DriversListFragment>): View = with(ui) {
    recyclerView {
      lparams(width = matchParent, height = matchParent)

      id = R.id.drivers_list
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(ctx)
      adapter = DriverListAdapter(listOf(Driver(), Driver()))
    }
  }
}

val DriversListFragment.list: RecyclerView get() = find(R.id.drivers_list)
