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
class Relative : BaseModel() {

  @PrimaryKey(autoincrement = true)
  @Column
  var id: Long = 0

  @ForeignKey
  var relative: Citizen? = null

  @ForeignKey
  var carOwner: Citizen? = null

  @Column
  var type: Relationship? = null
}