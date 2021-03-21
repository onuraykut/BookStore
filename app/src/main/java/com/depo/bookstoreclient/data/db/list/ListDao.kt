package com.depo.bookstoreclient.data.db.list

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.depo.bookstoreclient.data.model.book.Book
import com.depo.bookstoreclient.data.model.listeler.Liste

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLists(lists: List<Liste>)

    @Query("DELETE FROM liste")
    suspend fun deleteAllLists()

    @Query("SELECT * FROM liste")
    suspend fun getLists(): List<Liste>
}