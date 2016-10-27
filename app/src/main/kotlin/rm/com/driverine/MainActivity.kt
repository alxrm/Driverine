package rm.com.driverine

import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.onClick
import org.jetbrains.anko.setContentView
import rm.com.driverine.ui.presenter.AdditionFragment
import rm.com.driverine.ui.presenter.DriversListFragment
import rm.com.driverine.ui.view.layout.add
import rm.com.driverine.ui.view.layout.layout

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		layout.setContentView(this)

		switchFragment(next = DriversListFragment(), shouldAdd = false)

		add.onClick { switchFragment(AdditionFragment()) }
	}

	fun switchFragment(next: Fragment, shouldAdd: Boolean = true) =
			fragmentManager
					.beginTransaction()
					.apply {
						replace(R.id.container, next)
						setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
						if (shouldAdd) addToBackStack(null)
					}
					.commit()

}
