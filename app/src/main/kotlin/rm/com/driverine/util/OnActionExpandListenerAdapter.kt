package rm.com.driverine.util

import android.support.v4.view.MenuItemCompat
import android.view.MenuItem

/**
 * Created by alex
 */
interface OnActionExpandListenerAdapter : MenuItemCompat.OnActionExpandListener {

  override fun onMenuItemActionExpand(item: MenuItem): Boolean = true

  override fun onMenuItemActionCollapse(item: MenuItem): Boolean
}