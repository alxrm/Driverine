package rm.com.driverine.ui.fragment

import android.app.Fragment
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.act
import rm.com.driverine.MainActivity
import rm.com.driverine.ui.view.layout.toolbar

/**
 * Created by alex
 */

abstract class PageFragment : Fragment() {

  abstract val name: String

  override fun onResume() {
    super.onResume()

    toolbar.title = name
  }
}

val PageFragment.toolbar: Toolbar
  get() = owner.toolbar

val PageFragment.owner: MainActivity
  get() = act as MainActivity