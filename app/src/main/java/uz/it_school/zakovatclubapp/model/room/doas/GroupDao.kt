package uz.it_school.zakovatclubapp.model.room.doas

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.it_school.zakovatclubapp.model.room.entities.GroupEntity

@Dao
interface GroupDao {

    @Query("select * from groups ")
    fun getAllGroups():LiveData<List<GroupEntity>>

    @Query  ("SELECT * FROM groups where id =:ID")
    fun getGroup(ID:Int):LiveData<GroupEntity>

    @Insert
    fun insertAll(group:List<GroupEntity>)

    @Query("select * from groups where name LIKE '%'||:name||'%'")
    fun getGroupsByName(name:String):LiveData<List<GroupEntity>>
}