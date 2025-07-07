package com.sobolev.carsappshift2025.presentation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.usecases.GetAllCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getAllUsersUseCase: GetAllCarsUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow<CarsScreenState>(CarsScreenState.Initial)
    val screenState = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            _screenState.value = CarsScreenState.Loading
            try {
                val cars = getAllUsersUseCase()
                if (cars.isEmpty()) {
                    _screenState.value = CarsScreenState.Error("Машины не найдены")
                } else {
                    _screenState.value = CarsScreenState.Content(cars)
                }
            } catch (e: Exception) {
                _screenState.value = CarsScreenState.Error(e.message ?: "Неизвестная ошибка")
            }
        }
    }
}


sealed interface CarsScreenState {
    data object Initial : CarsScreenState
    data object Loading : CarsScreenState
    data class Content(val cars: List<Car>) : CarsScreenState
    data class Error(val message: String) : CarsScreenState
}

