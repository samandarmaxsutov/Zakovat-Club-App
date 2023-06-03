package uz.it_school.zakovatclubapp.model.shared

import android.content.Context
import uz.it_school.zakovatclubapp.utils.SharedPreferenceHelper


class LocalStorage private constructor(context: Context): SharedPreferenceHelper(context){

    companion object{
        private var storage:LocalStorage?=null
        fun init(context: Context){
            if (storage==null){
                storage= LocalStorage(context)
            }
        }

        fun getLocalStorage()= storage!!
    }

    var first:Boolean by booleans(false)

}