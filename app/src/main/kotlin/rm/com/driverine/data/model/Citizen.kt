package rm.com.driverine.data.model

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import rm.com.driverine.data.DriverineDatabase
import java.util.*

/**
 * Created by alex
 */
@Table(database = DriverineDatabase::class)
class Citizen : BaseModel() {

	@PrimaryKey(autoincrement = true)
	@Column
	var id: Long = 0

	@Column
	var first: String? = null

	@Column
	var second: String? = null

	@Column
	var patronymic: String? = null

	@Column
	var address: String? = null

	@Column
	var birthDate: Date? = null
}