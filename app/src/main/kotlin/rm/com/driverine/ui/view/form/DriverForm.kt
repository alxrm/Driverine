package rm.com.driverine.ui.view.form

import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.verticalLayout
import rm.com.driverine.ext.horizontalShadow

/**
 * Created by alex
 */
fun _LinearLayout.driverForm() {
	verticalLayout {
		ownerForm()

		horizontalShadow(dip(2))

		carForm()

		horizontalShadow(dip(2))

		relativesForm()
	}
}