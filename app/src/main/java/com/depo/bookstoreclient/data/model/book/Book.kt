package com.depo.bookstoreclient.data.model.book

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "book")
data class Book(
    @PrimaryKey
    @SerializedName("Book-ID")
    val bookId: Int,
    @SerializedName("Book-Title")
    val title: String,
    @SerializedName("Book-Description")
    @Nullable
    val description: String?,
    @SerializedName("Book-Cover-URL")
    val thumbnail: String,
    @SerializedName("Book-Page-Number")
    val pageNumber: Int,
    @SerializedName("Book-URL")
    val bookURL: String,
    @SerializedName("Book-Author")
    val bookAuthor: String,
    @SerializedName("Category")
    @Nullable
    val category: String?,
)
