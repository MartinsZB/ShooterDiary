package lv.zabarovski.martins.shooterdiary

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [ItemDiaryNote::class,ItemDiaryImage::class])
abstract class DiaryDatabase : RoomDatabase() {

    abstract fun diaryNotesDao(): DiaryNotesDao
    abstract fun diaryImagesDao(): DiaryImagesDao
}

object Database {
    private var instance: DiaryDatabase? = null

    fun getInstance(context: Context) = instance ?: Room.databaseBuilder(
        context.applicationContext, DiaryDatabase::class.java, "diary-db"
    )
        .allowMainThreadQueries()
        .build()
        .also { instance = it }
}