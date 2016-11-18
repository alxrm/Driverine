package rm.com.driverine.data.repo

import com.raizlabs.android.dbflow.sql.language.Select
import common.inUI
import common.inWorker
import common.year
import rm.com.driverine.data.model.Driver
import rm.com.driverine.data.model.Filter
import rm.com.driverine.data.model.Relationship
import rm.com.driverine.data.model.Relative
import rm.com.driverine.util.ext.isValid
import java.util.*

/**
 * Created by alex
 */

object DriversRepository {

  fun allDrivers(): List<Driver> =
      Select().from(Driver::class.java)
          .queryList()
          .toList()
          .filter(Driver::isValid)

  fun someDrivers(query: String, filters: List<Filter>, answer: (List<Driver>) -> Unit) =
      inWorker {
        val res = allDrivers()
            .filter { driver ->
              filters.all { it.disabled or it.predicate(driver) }
            }
            .filter {
              it matches query
            }

        inUI {
          answer(res)
        }
      }


  fun driverById(driverId: Long, answer: (Driver) -> Unit) {
    inWorker {
      val driver = allDrivers().first { it.id == driverId }

      inUI {
        answer(driver)
      }
    }
  }
}

fun Driver.relatives(): List<Relative> =
    Select()
        .from(Relative::class.java)
        .queryList()
        .filter { it.carOwner?.id == id }

fun Driver.hasMarriage(): Boolean =
    relatives().any {
      it.type == Relationship.HUSBAND || it.type == Relationship.WIFE
    }

fun Driver.hasChildren(): Boolean =
    relatives().any {
      it.type == Relationship.DAUGHTER
          || it.type == Relationship.SON
          || it.type == Relationship.G_DAUGHTER
          || it.type == Relationship.G_SON
    }

fun Driver.under40(): Boolean =
    (owner?.birthDate?.time ?: -1) > Calendar.getInstance().apply { year -= 40 }.timeInMillis

infix fun Driver.matches(query: String) =
    owner?.let {
      it.first!!.contains(query, ignoreCase = true)
          || it.last!!.contains(query, ignoreCase = true)
          || it.patronymic!!.contains(query, ignoreCase = true)
    } ?: false