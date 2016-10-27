package rm.com.driverine.ui.view.layout

import android.view.View
import org.jetbrains.anko.*
import rm.com.driverine.ui.presenter.AdditionFragment

/**
 * Created by alex
 */
class AdditionLayout : AnkoComponent<AdditionFragment> {
	override fun createView(ui: AnkoContext<AdditionFragment>): View = with(ui) {
		relativeLayout {
			lparams(width = matchParent, height = matchParent)

			editText {
				lparams(width = matchParent) {
					horizontalMargin = dip(16)
				}
			}
		}
	}
}