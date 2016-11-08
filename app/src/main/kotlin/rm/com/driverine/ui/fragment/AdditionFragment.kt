package rm.com.driverine.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.ctx
import rm.com.ankoforms.elements.FormElement
import rm.com.ankoforms.form
import rm.com.driverine.data.model.Car
import rm.com.driverine.data.model.Citizen
import rm.com.driverine.data.model.Driver
import rm.com.driverine.data.model.Relative
import rm.com.driverine.ext.isNotValid
import rm.com.driverine.ui.adapter.FormAdapter
import rm.com.driverine.ui.fragment.form.carForm
import rm.com.driverine.ui.fragment.form.ownerForm
import rm.com.driverine.ui.fragment.form.relativesForm
import rm.com.driverine.ui.layout.AdditionLayout

/**
 * Created by alex
 */
class AdditionFragment : PageFragment() {

  override val name: String
    get() = "Добавить"

  val driver: Driver = Driver().apply {
    owner = Citizen().apply { insert() }
    car = Car().apply { insert() }
    insert()
  }

  val relatives = mutableListOf<Relative>()
  val formAdapter = FormAdapter(additionForm())

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
      AdditionLayout().createView(AnkoContext.create(ctx, this))

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  override fun onDestroy() {
    if (driver.isNotValid()) {
      with(driver) {
        delete()
        car?.delete()
        owner?.delete()
      }
    }

    super.onDestroy()
  }

  fun refreshForm() =
      formAdapter.updateData(additionForm())

  fun additionForm(): List<FormElement> =
      form {
        ownerForm()
        carForm()
        relativesForm(relatives)
      }
}

