package uz.it_school.zakovatclubapp.model

import uz.it_school.zakovatclubapp.model.room.entities.GroupEntity
import uz.it_school.zakovatclubapp.model.room.entities.QuestionEntity

class Questions {

    val questions= arrayListOf(
        QuestionEntity(id=0, groupId = 1, question = "5+9*7=?", answer = "68", isFavorite =false),
        QuestionEntity(id=0, groupId = 2, question = "5+9*7=?", answer = "68", isFavorite =false),
        QuestionEntity(id=0, groupId = 3, question = "5+9*7=?", answer = "68", isFavorite =false),
        QuestionEntity(id=0, groupId = 2, question = "5+9*7=?", answer = "68", isFavorite =false),
        QuestionEntity(id=0, groupId = 1, question = "5+9*7=?", answer = "68", isFavorite =false),
        QuestionEntity(id=0, groupId = 3, question = "5+9*7=?", answer = "68", isFavorite =false),
        QuestionEntity(id=0, groupId = 1, question = "5+9*7=?", answer = "68", isFavorite =false),
        QuestionEntity(id=0, groupId = 2, question = "5+9*7=?", answer = "68", isFavorite =false),
    )

    val groups= arrayListOf(
        GroupEntity(id=0, name="Math",isFavorite = false),
        GroupEntity(id=0, name="Sport",isFavorite = false),
        GroupEntity(id=0, name="English",isFavorite = false),
    )
}