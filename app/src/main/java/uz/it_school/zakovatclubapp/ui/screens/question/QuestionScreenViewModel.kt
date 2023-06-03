package uz.it_school.zakovatclubapp.ui.screens.question

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.zakovatclubapp.model.room.AppDatabase
import uz.it_school.zakovatclubapp.model.room.entities.QuestionEntity

class QuestionScreenViewModel : ViewModel() {
    var id=0
    private val appDatabase= AppDatabase.getAppDatabase()
    val getUiChange= MediatorLiveData<QuestionEntity>()
    private var bookEntity:QuestionEntity?=null
    fun update(){
        bookEntity!!.isFavorite=!bookEntity!!.isFavorite
        appDatabase.getQuestionDao().update(bookEntity!!)
    }
    fun init(book:QuestionEntity) {
        getUiChange.addSource(appDatabase.getQuestionDao().getQuestion(book.id)){
            bookEntity=it
            getUiChange.value=it
        }
    }

}