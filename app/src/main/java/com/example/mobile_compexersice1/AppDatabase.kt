package com.example.mobile_compexersice1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Reminder :: class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun ReminderDao() : ReminderDao
}