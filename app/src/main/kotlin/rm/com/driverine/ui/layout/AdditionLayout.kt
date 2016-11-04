package rm.com.driverine.ui.layout

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import common.color
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import rm.com.driverine.R
import rm.com.driverine.ui.adapter.FormAdapter
import rm.com.driverine.ui.fragment.AdditionFragment
import rm.com.driverine.ui.fragment.additionForm

/**
 * Created by alex
 */
class AdditionLayout : AnkoComponent<AdditionFragment> {
  override fun createView(ui: AnkoContext<AdditionFragment>): View = with(ui) {
    recyclerView {
      lparams(width = matchParent, height = matchParent)

      id = R.id.drivers_list
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(ctx)
      backgroundColor = color(R.color.color_primary_light)
      adapter = FormAdapter(owner.additionForm())
    }
  }
}
