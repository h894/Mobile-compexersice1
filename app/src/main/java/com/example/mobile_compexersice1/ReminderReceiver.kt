package com.example.mobile_compexersice1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.room.Room
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast

class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        val uid = intent.getIntExtra("uid", 0)
        val text = intent.getStringExtra("message")

        MainActivity.showNotification(context,text!!)

        doAsync {
            val db = Room.databaseBuilder(context, AppDatabase::class.java,"reminders").build()
            db.ReminderDao().delete(uid)
            db.close()
        }
    }
}


