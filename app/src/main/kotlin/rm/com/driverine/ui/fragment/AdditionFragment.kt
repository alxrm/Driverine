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
import rm.com.driverine.ui.fragment.events.*
import rm.com.driverine.ui.view.form.carForm
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

  private val ownerInput: _LinearLayout.() -> Unit
    get() = { ownerForm(fragmentManager, mapOf(), onNameChanged, onAddressChanged, onDateSet) }

  private val carInput: _LinearLayout.() -> Unit
    get() = { carForm(mapOf(), onBrandChange, onColorChange, onNumberChange) }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
      AdditionLayout(ownerInput, carInput).createView(AnkoContext.create(ctx, this))

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

}