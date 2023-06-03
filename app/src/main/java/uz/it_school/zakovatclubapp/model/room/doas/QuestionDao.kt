package uz.it_school.zakovatclubapp.model.room.doas

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.it_school.zakovatclubapp.model.room.entities.QuestionEntity

@Dao
interface QuestionDao {

    @Query("select * from questions where groupId=:idGroup")
    fun getQuestions(idGroup: Int): LiveData<List<QuestionEntity>>

    @Query("select * from questions where id=:id")
    fun getQuestion(id: Int): LiveData<QuestionEntity>

    @Insert
    fun insertAll(questions: List<QuestionEntity>)

    @Query("select * from questions where isFavorite=1")
    fun getFavorites(): LiveData<List<QuestionEntity>>

    @Update
    fun update(question: QuestionEntity)


}