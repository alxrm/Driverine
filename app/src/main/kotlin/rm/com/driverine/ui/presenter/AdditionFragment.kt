package rm.com.driverine.ui.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.ctx
import rm.com.driverine.ui.view.layout.AdditionLayout

/**
 * Created by alex
 */

class AdditionFragment : BaseFragment() {

	override val name: String
		get() = "Добавить"

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
			AdditionLayout().createView(AnkoContext.create(ctx, this))

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

	}
}