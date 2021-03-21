package com.depo.bookstoreclient.data.model.listeler

import com.google.gson.annotations.SerializedName

data class ListelerList(
    @SerializedName("listeler")
    val listelers: List<Liste>
)
