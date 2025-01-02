package com.alaminkarno.notely.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(val title: String, val description: String?) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}