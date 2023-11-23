package com.curso.android.app.practica.textcompare.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.textcompare.model.TextComparison
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel : ViewModel() {
    val result: LiveData<TextComparison> get() = _result
    private var _result = MutableLiveData(TextComparison(true, Date()))

    fun makeTextComparison(text1: String, text2: String) {
        val value = text1 == text2

        updateTextComparison(value)
    }

    private fun updateTextComparison(value: Boolean) {
        viewModelScope.launch {
            _result.value = TextComparison(value, Date())
        }
    }
}
