package uz.it_school.zakovatclubapp.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "groups")
data class GroupEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val isFavorite:Boolean
        ):Serializable