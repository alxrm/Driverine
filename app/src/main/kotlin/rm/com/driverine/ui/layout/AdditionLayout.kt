package rm.com.driverine.ui.layout

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import common.color
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import rm.com.driverine.R
import rm.com.driverine.ui.fragment.AdditionFragment

/**
 * Created by alex
 */
class AdditionLayout : AnkoComponent<AdditionFragment> {
  override fun createView(ui: AnkoContext<AdditionFragment>): View = with(ui) {
    recyclerView {
      lparams(width = matchParent, height = matchParent)

      id = R.id.form_fields
      setHasFixedSize(true)
      visibility = View.GONE
      layoutManager = LinearLayoutManager(ctx)
      backgroundColor = color(R.color.color_primary_light)
      adapter = owner.formAdapter
    }
  }
}

val AdditionFragment.form: RecyclerView? get() = findOptional(R.id.form_fields)
