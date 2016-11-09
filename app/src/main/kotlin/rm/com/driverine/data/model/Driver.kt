package rm.com.driverine.data.model

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import rm.com.driverine.data.DriverineDatabase

/**
 * Created by alex
 */
@Table(database = DriverineDatabase::class)
class Driver : BaseModel() {

  @PrimaryKey
  @Column
  var id: Long = System.currentTimeMillis()

  @ForeignKey
  var owner: Citizen? = null

  @ForeignKey
  var car: Car? = null
}