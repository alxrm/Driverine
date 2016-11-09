package rm.com.driverine.ui.fragment

import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.view.*
import common.inUiDelayed
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.onQueryTextListener
import org.jetbrains.anko.ctx
import rm.com.driverine.R
import rm.com.driverine.data.model.Driver
import rm.com.driverine.data.model.Filter
import rm.com.driverine.data.repo.DriversRepository
import rm.com.driverine.data.repo.hasChildren
import rm.com.driverine.data.repo.hasMarriage
import rm.com.driverine.data.repo.under40
import rm.com.driverine.ui.adapter.DriverListAdapter
import rm.com.driverine.ui.fragment.events.onOpenDriver
import rm.com.driverine.ui.layout.DriversListLayout
import rm.com.driverine.ui.layout.add
import rm.com.driverine.util.OnActionExpandListenerAdapter

/**
 * Created by alex
 */

class DriversListFragment : PageFragment(), OnActionExpandListenerAdapter {

  override val name: String
    get() = "Автовладельцы"

  val driverAdapter = DriverListAdapter()

  val filters = mapOf(
      R.id.action_filter_married to Filter(predicate = Driver::hasMarriage),
      R.id.action_filter_parenting to Filter(predicate = Driver::hasChildren),
      R.id.action_filter_under_forty to Filter(predicate = Driver::under40)
  )

  private var search: SearchView? = null
    set(value) {
      field = value

      field?.onQueryTextListener {
        onQueryTextChange {
          searchDrivers(it.orEmpty())
          true
        }
      }
    }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
      DriversListLayout().createView(AnkoContext.create(ctx, this))

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    driverAdapter.onItemClick = onOpenDriver
  }

  override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
    inflater?.inflate(R.menu.menu_drivers, menu)
    super.onCreateOptionsMenu(menu, inflater)

    menu?.findItem(R.id.action_search)?.let {
      MenuItemCompat.setOnActionExpandListener(it, this)
      search = it.actionView as SearchView
    }
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    item ?: return super.onOptionsItemSelected(item)

    applyFilterIfNeeded(item)

    return true
  }

  override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
    refreshDrivers()
    return true
  }

  override fun onResume() {
    super.onResume()

    inUiDelayed(250) {
      owner.add.show()
      refreshDrivers()
    }
  }

  override fun onPause() {
    super.onPause()
    owner.add.hide()
  }

  private fun refreshDrivers(drivers: List<Driver> = DriversRepository.allDrivers()) {
    val withFilters = drivers.filter { driver ->
      filters.values.all { it.disabled || it.predicate(driver) }
    }

    driverAdapter.updateData(withFilters)
  }

  private fun searchDrivers(criteria: String) {
    refreshDrivers(DriversRepository.findDrivers(criteria))
  }

  private fun applyFilterIfNeeded(item: MenuItem) {
    if (item.itemId !in filters) return

    item.isChecked = !item.isChecked
    filters[item.itemId]?.disabled = !item.isChecked

    refreshDrivers()
  }
}