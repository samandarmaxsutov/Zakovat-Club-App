package uz.it_school.zakovatclubapp.ui.screens.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.it_school.zakovatclubapp.model.Questions
import uz.it_school.zakovatclubapp.model.room.AppDatabase
import uz.it_school.zakovatclubapp.model.shared.LocalStorage

class SplashScreenViewModel : ViewModel() {

    private val localStorage= LocalStorage.getLocalStorage()
    private val appDatabase= AppDatabase.getAppDatabase()
    private val booksList=Questions()
    val openMainScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            if (!localStorage.first){
                localStorage.first=true
                appDatabase.getGroupDao().insertAll(booksList.groups)
                appDatabase.getQuestionDao().insertAll(booksList.questions)
            }
            delay(1500)

            openMainScreenLiveData.value=Unit

        }
    }
}
