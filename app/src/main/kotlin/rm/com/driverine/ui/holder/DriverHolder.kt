package rm.com.driverine.ui.holder

import android.view.View
import org.jetbrains.anko.onClick
import rm.com.driverine.data.model.Driver

/**
 * Created by alex
 */
class DriverHolder(itemView: View?) : BaseHolder<Driver>(itemView) {

  var onItemClick: (Driver) -> Unit = {}

  override fun bind(model: Driver) {
    itemView ?: return

    itemView.onClick { onItemClick(model) }
  }
}

