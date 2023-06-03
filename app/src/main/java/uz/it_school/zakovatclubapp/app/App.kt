package uz.it_school.zakovatclubapp.app

import android.app.Application
import uz.it_school.zakovatclubapp.model.room.AppDatabase
import uz.it_school.zakovatclubapp.model.shared.LocalStorage


class App:Application() {
    override fun onCreate() {
        super.onCreate()
        LocalStorage.init(this)
        AppDatabase.init(this)
    }
}