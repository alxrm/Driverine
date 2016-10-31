package rm.com.driverine.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import rm.com.driverine.data.model.Driver
import rm.com.driverine.ui.holder.DriverHolder
import rm.com.driverine.ui.view.items.driverItemView

/**
 * Created by alex
 */
class DriverListAdapter(var drivers: List<Driver> = emptyList()) : RecyclerView.Adapter<DriverHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DriverHolder =
      DriverHolder(parent?.context?.driverItemView())

  override fun getItemCount(): Int = drivers.size

  override fun onBindViewHolder(holder: DriverHolder?, position: Int) =
      holder?.let {
//				it.onItemClick =
        it.bind(drivers[position])
      } ?: Unit

  fun updateData(drivers: List<Driver>) {
    this.drivers = drivers
    notifyDataSetChanged()
  }
}