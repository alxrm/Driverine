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

	@PrimaryKey(autoincrement = true)
	@Column
	var id: Long = 0

	@ForeignKey
	@Column
	var owner: Citizen? = null

	@ForeignKey
	@Column
	var car: Car? = null
}