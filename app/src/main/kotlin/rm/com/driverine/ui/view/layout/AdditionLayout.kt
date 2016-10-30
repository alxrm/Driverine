package rm.com.driverine.ui.view.layout

import android.view.View
import common.color
import org.jetbrains.anko.*
import rm.com.driverine.R
import rm.com.driverine.ui.presenter.AdditionFragment
import rm.com.driverine.ui.view.form.driverForm

/**
 * Created by alex
 */
class AdditionLayout : AnkoComponent<AdditionFragment> {
  override fun createView(ui: AnkoContext<AdditionFragment>): View = with(ui) {
    scrollView {
      lparams(width = matchParent, height = matchParent)

      backgroundColor = color(R.color.color_primary_light)

      verticalLayout {
        lparams(width = matchParent, height = wrapContent)

        driverForm()
      }
    }
  }
}