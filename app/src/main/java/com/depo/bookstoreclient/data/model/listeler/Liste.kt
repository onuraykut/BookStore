package com.depo.bookstoreclient.data.model.listeler

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "liste")
data class Liste(
    @PrimaryKey
    @SerializedName("ID")
    val id: Int,
    @SerializedName("UUID")
    val uid: String,
    @SerializedName("Liste_adi")
    val listeAdi: String,
    @SerializedName("kitapSayisi")
    val listeKitapsayisi: String,
    @SerializedName("isim")
    val listeOlusturan: String,
    @SerializedName("coverURL1")
    val image1: String,
    @SerializedName("coverURL2")
    val image2: String,
    @SerializedName("coverURL3")
    val image3: String,
)
