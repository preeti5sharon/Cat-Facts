package com.example.catfactapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(private val repository: CatRepository) : ViewModel() {
    private var _catFact = MutableStateFlow<CatResponse?>(null)
    val catFact = _catFact.asStateFlow()
    fun getCatDetails() = viewModelScope.launch(Dispatchers.IO) {
        while (true) {
            delay(3000)
            _catFact.value = repository.getCatFact().body()
        }
    }
}
