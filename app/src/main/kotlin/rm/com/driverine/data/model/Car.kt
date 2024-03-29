package rm.com.driverine.data.model

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import rm.com.driverine.data.DriverineDatabase

/**
 * Created by alex
 */
@Table(database = DriverineDatabase::class)
class Car : BaseModel() {

  @PrimaryKey
  @Column
  var id: Long = System.currentTimeMillis()

  @Column
  var number: String? = null

  @Column
  var brand: String? = null

  @Column
  var color: String? = null

}