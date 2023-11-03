package com.app.todo.Domain.Repositories.SellItemUseCase

data class SellItemUseCase(
    val addItem: AddItem,
    val updateItem: UpdateItem,
    val removeItem: RemoveItem,
    val getItems: GetItems
)