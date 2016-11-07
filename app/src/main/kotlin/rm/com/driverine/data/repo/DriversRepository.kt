package rm.com.driverine.data.repo

import com.raizlabs.android.dbflow.sql.language.Select
import rm.com.driverine.data.model.Driver
import rm.com.driverine.ext.isNotValid

/**
 * Created by alex
 */

object DriversRepository {

  fun allDrivers(): List<Driver> =
      Select().from(Driver::class.java)
          .queryList()
          .toList().filterNot { it.owner.isNotValid() }

}