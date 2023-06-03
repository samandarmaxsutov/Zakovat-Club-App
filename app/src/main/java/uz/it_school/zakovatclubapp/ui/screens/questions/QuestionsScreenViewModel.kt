package uz.it_school.zakovatclubapp.ui.screens.questions

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.zakovatclubapp.model.room.AppDatabase
import uz.it_school.zakovatclubapp.model.room.entities.QuestionEntity

class QuestionsScreenViewModel : ViewModel() {


    private val appDatabase= AppDatabase.getAppDatabase()
    val questionsLiveData= MediatorLiveData<List<QuestionEntity>>()


    fun init(id:Int) {
        questionsLiveData.addSource(appDatabase.getQuestionDao().getQuestions(id)){
            questionsLiveData.value=it
        }
    }
}