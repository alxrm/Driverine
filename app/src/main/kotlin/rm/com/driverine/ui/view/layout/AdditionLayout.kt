package rm.com.driverine.ui.view.layout

import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout

/**
 * Created by alex
 */

class AdditionLayout : AnkoComponent<AdditionLayout> {
	override fun createView(ui: AnkoContext<AdditionLayout>): View = with(ui) {
		relativeLayout {
			lparams(width = matchParent, height = matchParent)


		}
	}
}