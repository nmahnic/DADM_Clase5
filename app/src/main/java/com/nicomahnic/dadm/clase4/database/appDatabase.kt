package com.nicomahnic.dadm.clase4.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nicomahnic.dadm.clase4.domain.DeviceDao
import com.nicomahnic.dadm.clase4.domain.UserDao
import com.nicomahnic.dadm.clase4.entities.DeviceEntity
import com.nicomahnic.dadm.clase4.entities.UserEntity

@Database(entities = [UserEntity::class, DeviceEntity::class], version = 1, exportSchema = false)

abstract class appDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun deviceDao(): DeviceDao

    companion object {
        var INSTANCE: appDatabase? = null

        fun getAppDataBase(context: Context): appDatabase? {
            if (INSTANCE == null) {
                synchronized(appDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        appDatabase::class.java,
                        "myDB"
                    ).allowMainThreadQueries().build() // No es lo mas recomendable que se ejecute en el mainthread
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}