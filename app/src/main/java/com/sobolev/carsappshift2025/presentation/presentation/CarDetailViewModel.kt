package com.sobolev.carsappshift2025.presentation.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.usecases.GetCarUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = CarDetailViewModel.Factory::class)
class CarDetailViewModel @AssistedInject constructor(
    @Assisted("carId") private val carId: String,
    private val getCarUseCase: GetCarUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<CarDetailScreen>(CarDetailScreen.Initial)
    val state = _state.asStateFlow()

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("carId") carId: String
        ): CarDetailViewModel
    }

    init {
        viewModelScope.launch {
            try {
                val car = getCarUseCase(carId)
                _state.value = CarDetailScreen.Booking(car)
            } catch (e: Exception) {
                Log.e("CarDetailViewModel", "Error: ${e.message}")
                _state.value = CarDetailScreen.Error("Ошибка загрузки")
            }
        }
    }

    fun processCommand(command: CarDetailCommand) {
        when (command) {
            CarDetailCommand.Back -> {
                _state.update {
                    CarDetailScreen.Finished
                }
            }
        }
    }


}

sealed interface CarDetailCommand {

    data object Back : CarDetailCommand

}

sealed interface CarDetailScreen {
    data object Initial : CarDetailScreen
    data class Booking(val car: Car) : CarDetailScreen
    data class Error(val message: String) : CarDetailScreen
    data object Finished : CarDetailScreen
}
