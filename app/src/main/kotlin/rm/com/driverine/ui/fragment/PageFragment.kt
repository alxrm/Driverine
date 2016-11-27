package rm.com.driverine.ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.act
import rm.com.driverine.MainActivity
import rm.com.driverine.ui.layout.screens.toolbar

/**
 * Created by alex
 */

abstract class PageFragment : Fragment() {

  abstract val name: String

  var isClosed = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
  }

  override fun onResume() {
    super.onResume()

    toolbar.title = name
  }

  override fun onDestroy() {
    isClosed = true
    super.onDestroy()
  }
}

val PageFragment.toolbar: Toolbar
  get() = owner.toolbar

val PageFragment.owner: MainActivity
  get() = act as MainActivity