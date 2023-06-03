package uz.it_school.zakovatclubapp.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "questions")
data class QuestionEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val groupId:Int,
    val question:String,
    val answer:String,
    var isFavorite:Boolean
        ): Serializable