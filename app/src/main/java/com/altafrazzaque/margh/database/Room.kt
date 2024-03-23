package com.altafrazzaque.margh.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.altafrazzaque.margh.model.QuoteItem

@Dao
interface ExpenseDao {
    @Query("select * from QuoteItem")
    fun getQuotes(): LiveData<List<QuoteItem>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<QuoteItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: QuoteItem)
}

@Database(entities = [QuoteItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val quotesDao: ExpenseDao
}