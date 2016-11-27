package rm.com.driverine.data

import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.annotation.Migration
import com.raizlabs.android.dbflow.sql.SQLiteType
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration
import com.raizlabs.android.dbflow.sql.migration.UpdateTableMigration
import rm.com.driverine.data.model.Citizen
import rm.com.driverine.data.model.Citizen_Table


/**
 * Created by alex
 */
@Database(name = DriverineDatabase.NAME, version = DriverineDatabase.VERSION, generatedClassSeparator = "_")
object DriverineDatabase {
  const val NAME: String = "DriverineDB"
  const val VERSION: Int = 3

  @Migration(version = 2, database = DriverineDatabase::class)
  class Migration2(table: Class<Citizen>?) : AlterTableMigration<Citizen>(table) {
    override fun onPreMigrate() {
      super.onPreMigrate()
      addColumn(SQLiteType.INTEGER, "experience")
    }
  }

  @Migration(version = 3, database = DriverineDatabase::class)
  class Migration3(table: Class<Citizen>?) : UpdateTableMigration<Citizen>(table) {
    init {
      set(Citizen_Table.experience.eq(1))
    }
  }
}