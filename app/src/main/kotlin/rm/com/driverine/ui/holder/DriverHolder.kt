package rm.com.driverine.ui.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.onClick
import rm.com.driverine.R
import rm.com.driverine.data.model.Driver
import rm.com.driverine.data.repo.relatives
import rm.com.driverine.ui.layout.item.carDialog
import rm.com.driverine.ui.layout.item.relativesDialog
import rm.com.driverine.util.ext.formatDate
import rm.com.driverine.util.ext.formatName

/**
 * Created by alex
 */
class DriverHolder(itemView: View?) : BaseHolder<Driver>(itemView) {

  var onItemClick: (Driver) -> Unit = {}

  private val name by lazy { findOptional<TextView>(R.id.driver_name) }
  private val birth by lazy { findOptional<TextView>(R.id.driver_birth) }
  private val car by lazy { findOptional<ImageView>(R.id.driver_car) }
  private val relatives by lazy { findOptional<ImageView>(R.id.driver_relatives) }

  override fun bind(model: Driver) {
    name?.text = model.owner?.formatName()
    birth?.text = model.owner?.birthDate?.formatDate()

    car?.onClick { carDialog(model.car!!) }
    relatives?.onClick { relativesDialog(model.relatives()) }

    itemView.onClick { onItemClick(model) }
  }
}

