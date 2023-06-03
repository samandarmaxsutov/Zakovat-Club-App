package uz.it_school.zakovatclubapp.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.it_school.zakovatclubapp.model.room.doas.GroupDao
import uz.it_school.zakovatclubapp.model.room.doas.QuestionDao
import uz.it_school.zakovatclubapp.model.room.entities.GroupEntity
import uz.it_school.zakovatclubapp.model.room.entities.QuestionEntity


@Database(entities = [QuestionEntity::class,GroupEntity::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    companion object{
        @Volatile var instance: AppDatabase? = null
        fun init(context: Context) {
            if (instance == null) instance = Room.databaseBuilder(context,AppDatabase::class.java,"AppDatabase")
                .allowMainThreadQueries()
                .build()
        }
        fun getAppDatabase()=instance!!
    }
    abstract fun getQuestionDao():QuestionDao
    abstract fun getGroupDao():GroupDao

}