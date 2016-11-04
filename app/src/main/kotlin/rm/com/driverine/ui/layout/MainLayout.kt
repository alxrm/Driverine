package rm.com.driverine.ui.layout

import android.graphics.Color
import android.os.Build
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.Toolbar
import android.view.View
import common.color
import common.lparamsRel
import common.statusBarHeight
import common.vectorOf
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.floatingActionButton
import rm.com.driverine.MainActivity
import rm.com.driverine.R

/**
 * Created by alex
 */
class MainLayout : AnkoComponent<MainActivity> {
  override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
    relativeLayout {
      lparams {
        width = matchParent
        height = matchParent
      }

      appBarLayout(R.style.AppTheme_AppBarOverlay) {
        lparams(width = matchParent)

        id = R.id.appbar
        fitsSystemWindows = true

        toolbar {
          lparams(width = matchParent)

          id = R.id.toolbar
          backgroundColor = color(R.color.color_primary)
          minimumHeight = dip(56)

          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setPadding(0, context.statusBarHeight(), 0, 0)
          }

          owner.setSupportActionBar(this)
        }
      }

      frameLayout {
        lparamsRel(width = matchParent, height = matchParent) {
          below(R.id.appbar)
        }

        id = R.id.container
      }

      floatingActionButton {
        lparams {
          alignParentBottom()
          alignParentEnd()
          margin = dip(16)
        }

        id = R.id.add_driver
        isClickable = true
        setImageDrawable(vectorOf(R.drawable.ic_add_white_24dp))
        rippleColor = Color.WHITE
      }
    }
  }
}

val MainActivity.layout by lazy { MainLayout() }
val MainActivity.toolbar: Toolbar get() = find(R.id.toolbar)
val MainActivity.add: FloatingActionButton get() = find(R.id.add_driver)