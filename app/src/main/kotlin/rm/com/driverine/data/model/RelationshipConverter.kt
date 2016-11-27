package rm.com.driverine.data.model

import com.raizlabs.android.dbflow.converter.TypeConverter
import com.raizlabs.android.dbflow.annotation.TypeConverter as CustomTypeConverter

@CustomTypeConverter
class RelationshipConverter : TypeConverter<Int, Relationship?>() {

  override fun getModelValue(data: Int?): Relationship? =
      if (data == null || data < 0 || data > Relationship.values().size) {
        null
      } else {
        Relationship.values()[data]
      }

  override fun getDBValue(model: Relationship?): Int? =
      model?.ordinal

}