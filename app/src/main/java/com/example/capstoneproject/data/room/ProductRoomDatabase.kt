package com.example.capstoneproject.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductFavEntity::class], version = 1)
abstract class ProductRoomDatabase : RoomDatabase() {

    abstract fun productFavDAOInterface(): ProductFavDAOInterface

    companion object {
        private var instance: ProductRoomDatabase? = null

        fun productFavDatabase(context: Context): ProductRoomDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    ProductRoomDatabase::class.java,
                    "productfavdatabase.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}