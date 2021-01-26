package com.example.fadel.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fadel.data.dao.UserDao
import com.example.fadel.data.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class CoreDatabase : RoomDatabase() {
    abstract fun UserDao() : UserDao

    companion object{

        @Volatile
        private var INSTANCE: CoreDatabase? = null

        fun getDatabase(context: Context): CoreDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CoreDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}