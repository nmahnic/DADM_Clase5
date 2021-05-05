package com.nicomahnic.dadm.clase5.domain

import androidx.room.*
import com.nicomahnic.dadm.clase5.entities.DeviceEntity

@Dao
interface DeviceDao {

    @Query("SELECT * FROM devices ORDER BY id")
    fun loadAllDevices(): List<DeviceEntity?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDevice(user: DeviceEntity?)

    @Update
    fun updateDevice(user: DeviceEntity?)

    @Delete
    fun delete(user: DeviceEntity?)

    @Query("SELECT * FROM devices WHERE id = :id")
    fun loadDeviceById(id: Int): DeviceEntity?
}