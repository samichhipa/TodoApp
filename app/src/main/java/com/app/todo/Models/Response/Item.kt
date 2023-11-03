package com.app.todo.Models.Response

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity("ItemToSell")
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    var name: String? = "",
    var price: Int? = 0,
    var quantity: Int? = 0,
    var type: Int? = 0
) : Serializable