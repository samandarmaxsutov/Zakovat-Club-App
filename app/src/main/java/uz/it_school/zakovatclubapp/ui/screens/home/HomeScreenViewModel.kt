package uz.it_school.zakovatclubapp.ui.screens.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.zakovatclubapp.model.room.AppDatabase
import uz.it_school.zakovatclubapp.model.room.entities.GroupEntity

class HomeScreenViewModel : ViewModel() {
    private val appDatabase= AppDatabase.getAppDatabase()
    val groupLiveData= MediatorLiveData<List<GroupEntity>>()
    val openQuestionScreen= MutableLiveData<GroupEntity>()
    fun open(country: GroupEntity) {
        openQuestionScreen.value=country
    }


    init {
        groupLiveData.addSource(appDatabase.getGroupDao().getAllGroups()){
            groupLiveData.value=it
        }

    }

    fun search(words:String){
        if (words.isNotEmpty()) {
            groupLiveData.addSource(appDatabase.getGroupDao().getGroupsByName(words)) {
                groupLiveData.value = it
            }
        }else{
            groupLiveData.addSource(appDatabase.getGroupDao().getAllGroups()){
                groupLiveData.value=it
            }
        }
    }
}