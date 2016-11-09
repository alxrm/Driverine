package rm.com.driverine.data.model

/**
 * Created by alex
 */

data class Filter(
    val predicate: (Driver) -> Boolean,
    var disabled: Boolean = true
)