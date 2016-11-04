package rm.com.driverine.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import rm.com.driverine.data.model.Driver
import rm.com.driverine.ui.holder.DriverHolder
import rm.com.driverine.ui.item.driverItemView

/**
 * Created by alex
 */
class DriverListAdapter(var drivers: List<Driver> = emptyList()) : RecyclerView.Adapter<DriverHolder>() {

  var onItemClick: (Driver) -> Unit = {}

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DriverHolder =
      DriverHolder(parent.driverItemView())

  override fun getItemCount(): Int = drivers.size

  override fun onBindViewHolder(holder: DriverHolder?, position: Int) =
      holder?.let {
        it.bind(drivers[position])
        it.onItemClick = onItemClick
      } ?: Unit

  fun updateData(drivers: List<Driver>) {
    this.drivers = drivers
    notifyDataSetChanged()
  }
}