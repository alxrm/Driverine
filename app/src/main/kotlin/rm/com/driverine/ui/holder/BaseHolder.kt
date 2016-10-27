package rm.com.driverine.ui.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by alex
 */
abstract class BaseHolder<in T : BaseModel>(itemView: View?) : RecyclerView.ViewHolder(itemView) {
	abstract fun bind(model: T)
}

inline fun <reified T : View> BaseHolder<*>.find(id: Int): T = itemView?.findViewById(id) as T