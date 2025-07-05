package com.sobolev.carsappshift2025.presentation.screens.cars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.usecases.GetAllCarsUseCase
import com.sobolev.carsappshift2025.domain.usecases.RefreshCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getAllUsersUseCase: GetAllCarsUseCase,
    private val refreshUsersUseCase: RefreshCarsUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(UsersScreenState(isLoading = true))
    val screenState = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            refreshUsersUseCase()

            getAllUsersUseCase().collect { cars ->
                _screenState.value = UsersScreenState(
                    allCars = cars,
                    isLoading = false
                )
            }
        }
    }
}

data class UsersScreenState(
    val allCars: List<Car> = emptyList(),
    val isLoading: Boolean = false
)
