package rm.com.driverine.ui.holder

import android.view.View
import android.widget.TextView
import org.jetbrains.anko.onClick
import rm.com.driverine.R
import rm.com.driverine.data.model.Driver
import rm.com.driverine.util.ext.formatDate
import rm.com.driverine.util.ext.formatName

/**
 * Created by alex
 */
class DriverHolder(itemView: View?) : BaseHolder<Driver>(itemView) {

  var onItemClick: (Driver) -> Unit = {}

  private val name by lazy { findOptional<TextView>(R.id.driver_name) }
  private val birth by lazy { findOptional<TextView>(R.id.driver_birth) }

  override fun bind(model: Driver) {
    name?.text = model.owner?.formatName()
    birth?.text = model.owner?.birthDate?.formatDate()

    itemView.onClick { onItemClick(model) }
  }
}

