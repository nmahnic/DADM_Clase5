package com.nicomahnic.dadm.clase5.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "devices")
data class DeviceEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    @ColumnInfo(name = "device_name")
    val name: String,

    @ColumnInfo(name = "device_description")
    val description: String
)