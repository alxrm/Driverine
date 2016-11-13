package rm.com.driverine.util

import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.MenuItem

/**
 * Created by alex
 */
fun RecyclerView.onItemActions(dragDirs: Int = 0, swipeDirs: Int = 0, init: __ItemTouchHelper_SimpleCallback.() -> Unit) {
  val helperCallback = __ItemTouchHelper_SimpleCallback(dragDirs, swipeDirs).apply(init)
  ItemTouchHelper(helperCallback).attachToRecyclerView(this)
}

class __ItemTouchHelper_SimpleCallback(dragDirs: Int, swipeDirs: Int) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
  private var _onMove: ((RecyclerView?, RecyclerView.ViewHolder?, RecyclerView.ViewHolder?) -> Boolean)? = null
  private var _onSwiped: ((RecyclerView.ViewHolder?, Int) -> Unit)? = null

  override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean =
      _onMove?.invoke(recyclerView, viewHolder, target) ?: false

  fun onMove(listener: (RecyclerView?, RecyclerView.ViewHolder?, RecyclerView.ViewHolder?) -> Boolean) {
    _onMove = listener
  }

  override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) =
      _onSwiped?.invoke(viewHolder, direction) ?: Unit

  fun onSwiped(listener: (RecyclerView.ViewHolder?, Int) -> Unit) {
    _onSwiped = listener
  }
}

interface OnActionExpandListenerAdapter : MenuItemCompat.OnActionExpandListener {

  override fun onMenuItemActionExpand(item: MenuItem): Boolean = true

  override fun onMenuItemActionCollapse(item: MenuItem): Boolean
}