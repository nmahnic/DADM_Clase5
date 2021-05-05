package com.nicomahnic.dadm.clase4.domain

import androidx.room.*
import com.nicomahnic.dadm.clase4.entities.DeviceEntity
import com.nicomahnic.dadm.clase4.entities.UserEntity

@Dao
interface DeviceDao {

    @Query("SELECT * FROM users ORDER BY id")
    fun loadAllDevices(): MutableList<DeviceEntity?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDevice(user: DeviceEntity?)

    @Update
    fun updateDevice(user: DeviceEntity?)

    @Delete
    fun delete(user: DeviceEntity?)

    @Query("SELECT * FROM users WHERE id = :id")
    fun loadDeviceById(id: Int): DeviceEntity?
}