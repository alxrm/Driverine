package rm.com.driverine.data.repo

import com.raizlabs.android.dbflow.sql.language.Select
import common.year
import rm.com.driverine.data.model.Driver
import rm.com.driverine.data.model.Relationship
import rm.com.driverine.data.model.Relative
import rm.com.driverine.util.ext.isNotValid
import java.util.*

/**
 * Created by alex
 */

object DriversRepository {

  fun allDrivers(): List<Driver> =
      Select().from(Driver::class.java)
          .queryList()
          .toList()
          .filterNot { it.isNotValid() }

  fun findDrivers(criteria: String): List<Driver> =
      Select().from(Driver::class.java)
          .queryList()
          .toList()
          .filterNot { it.isNotValid() }
          .filter {
            it.owner!!.let {
              it.first!!.contains(criteria)
                  || it.last!!.contains(criteria)
                  || it.patronymic!!.contains(criteria)
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