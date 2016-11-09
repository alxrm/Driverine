package rm.com.driverine.util.ext

import rm.com.driverine.data.model.Relationship

/**
 * Created by alex
 */

val relationships: Map<String, Relationship> =
    mapOf(
        "Сын" to Relationship.SON,
        "Дочь" to Relationship.DAUGHTER,
        "Брат" to Relationship.BROTHER,
        "Сестра" to Relationship.SISTER,
        "Отец" to Relationship.FATHER,
        "Мать" to Relationship.MOTHER,
        "Бабушка" to Relationship.G_MOTHER,
        "Дедушка" to Relationship.G_FATHER,
        "Муж" to Relationship.HUSBAND,
        "Жена" to Relationship.WIFE,
        "Внучка" to Relationship.G_DAUGHTER,
        "Внук" to Relationship.G_SON
    )

fun Relationship?.toReadableString(): String? =
    relationships.entries.find { it.value == this }?.key