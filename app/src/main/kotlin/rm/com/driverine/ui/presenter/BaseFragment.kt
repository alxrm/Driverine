package rm.com.driverine.ui.presenter

import android.app.Fragment
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.act
import rm.com.driverine.MainActivity
import rm.com.driverine.ui.view.layout.toolbar

/**
 * Created by alex
 */

abstract class BaseFragment : Fragment() {

	abstract val name: String

	override fun onResume() {
		super.onResume()

		toolbar.title = name
	}
}

val BaseFragment.toolbar: Toolbar
	get() = owner.toolbar

val BaseFragment.owner: MainActivity
	get() = act as MainActivity