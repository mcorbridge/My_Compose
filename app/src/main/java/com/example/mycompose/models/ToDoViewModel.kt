package com.example.mycompose.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycompose.items.TodoItem

class TodoViewModel : ViewModel() {

    // state: todoItems
    private var _todoItems = MutableLiveData(listOf<TodoItem>())
    val todoItems: LiveData<List<TodoItem>> = _todoItems

    // event: addItem
    fun addItem(item: TodoItem) {
        /* ... */
    }

    // event: removeItem
    fun removeItem(item: TodoItem) {
        /* ... */
    }
}