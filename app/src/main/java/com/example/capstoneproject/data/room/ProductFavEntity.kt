package com.example.capstoneproject.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productfavdatabase")
data class ProductFavEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var productId: Int=0,

    @ColumnInfo(name = "productName")
    var productName: String?,

    @ColumnInfo(name = "productPrice")
    var productPrice: String?,

    @ColumnInfo(name = "productRate")
    var productRate: String?,

    @ColumnInfo(name = "productDesc")
    var productDesc: String?,

    @ColumnInfo(name = "productCategory")
    var productCategory: String?,

    @ColumnInfo(name = "productImageURL")
    var productImageURL: String?,
)