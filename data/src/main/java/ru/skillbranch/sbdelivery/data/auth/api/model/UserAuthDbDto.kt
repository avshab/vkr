package ru.skillbranch.sbdelivery.data.auth.api.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING

/**
 * Created by Anna Shabaeva on 28.06.2020
 */

@Entity(tableName = "auth")
class UserAuthDbDto(
    val accessToken: String,
    val refreshToken: String
) {

    /**
     * Pre-define constant primary key to force single record in table.
     */
    @PrimaryKey
    var primaryKey: Int = 0

    val isNotEmpty: Boolean
        get() = accessToken.isNotBlank() && refreshToken.isNotBlank()

    companion object {
        val EMPTY: UserAuthDbDto =
            UserAuthDbDto(
                EMPTY_STRING,
                EMPTY_STRING
            )
    }

}
