package rm.com.driverine.ui.holder

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by alex
 */
abstract class BaseHolder<in T>(itemView: View?) : RecyclerView.ViewHolder(itemView) {
  abstract fun bind(model: T)
}

fun BaseHolder<*>.onClick(l: (v: android.view.View?) -> Unit) = itemView?.setOnClickListener(l)

inline fun <reified T : View> BaseHolder<*>.findOptional(id: Int): T? = itemView?.findViewById(id) as T