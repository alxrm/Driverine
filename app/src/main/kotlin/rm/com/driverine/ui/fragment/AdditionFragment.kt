package rm.com.driverine.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.ctx
import rm.com.driverine.data.model.Car
import rm.com.driverine.data.model.Citizen
import rm.com.driverine.data.model.Driver
import rm.com.driverine.ui.fragment.events.onAddressChanged
import rm.com.driverine.ui.fragment.events.onDateSet
import rm.com.driverine.ui.fragment.events.onNameChanged
import rm.com.driverine.ui.view.form.ownerForm
import rm.com.driverine.ui.view.layout.AdditionLayout

/**
 * Created by alex
 */
class AdditionFragment : PageFragment() {

  override val name: String
    get() = "Добавить"

  val driver: Driver = Driver().apply {
    owner = Citizen()
    car = Car()
  }

  private val owner: _LinearLayout.() -> Unit
    get() = { ownerForm(fragmentManager, mapOf(), onNameChanged, onAddressChanged, onDateSet) }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
      AdditionLayout(owner).createView(AnkoContext.create(ctx, this))

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

}