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
import rm.com.driverine.data.repo.DriversRepository
import rm.com.driverine.data.repo.relatives
import rm.com.driverine.ui.adapter.FormAdapter
import rm.com.driverine.ui.fragment.constants.EXTRAS_KEY_DRIVER_ID
import rm.com.driverine.ui.fragment.form.carForm
import rm.com.driverine.ui.fragment.form.ownerForm
import rm.com.driverine.ui.fragment.form.relativesForm
import rm.com.driverine.ui.layout.screens.AdditionLayout
import rm.com.driverine.ui.layout.screens.form
import rm.com.driverine.util.ext.formatName
import rm.com.driverine.util.ext.isNotValid

/**
 * Created by alex
 */
class AdditionFragment : PageFragment() {

  override val name: String
    get() = "Добавить"

  var driver = Driver().apply {
    owner = Citizen().apply { insert() }
    car = Car().apply { insert() }
    insert()
  }

  val relatives = mutableListOf<Relative>()
  val formAdapter = FormAdapter(additionForm())

  private var isEditing = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val driverId = arguments?.getLong(EXTRAS_KEY_DRIVER_ID) ?: return

    isEditing = true

    DriversRepository.driverById(driverId) {
      if (isClosed) return@driverById

      deleteIfEmpty()

      driver = it
      relatives += driver.relatives()
      refreshForm()

      toolbar.title = driver.owner!!.formatName()
      showForm()
    }
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
      AdditionLayout().createView(AnkoContext.create(ctx, this))

  override fun onResume() {
    super.onResume()

    if (!isEditing) showForm()
    else toolbar.title = "Автовладелец"
  }

  override fun onDestroy() {
    deleteIfEmpty()
    super.onDestroy()
  }

  fun deleteIfEmpty() {
    if (driver.isNotValid()) {
      with(driver) {
        delete()
        car?.delete()
        owner?.delete()
      }
    }
  }

  fun showForm() {
    form?.visibility = View.VISIBLE
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

