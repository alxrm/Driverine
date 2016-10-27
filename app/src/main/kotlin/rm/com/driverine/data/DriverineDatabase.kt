package rm.com.driverine.data

import com.raizlabs.android.dbflow.annotation.Database

/**
 * Created by alex
 */
@Database(name = DriverineDatabase.NAME, version = DriverineDatabase.VERSION,  generatedClassSeparator = "_")
object DriverineDatabase {
	const val NAME: String = "DriverineDB"
	const val VERSION: Int = 1
}