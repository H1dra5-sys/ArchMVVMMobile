package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DessertUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0
)

class DessertViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    private val desserts = listOf(
        Dessert(1, "Cupcake", 2, 5),
        Dessert(5, "Donut", 4, 10),
        Dessert(9, "Eclair", 5, 15),
        Dessert(15, "Froyo", 10, 20),
        Dessert(20, "Gingerbread", 15, 25)
    )

    fun onDessertClicked() {
        _uiState.update { currentState ->
            val newRevenue = currentState.revenue + desserts[currentState.currentDessertIndex].price
            val newSold = currentState.dessertsSold + 1

            var newIndex = currentState.currentDessertIndex
            if (newSold >= desserts[newIndex].startProductionAmount && newIndex < desserts.size - 1) {
                newIndex++
            }

            currentState.copy(
                revenue = newRevenue,
                dessertsSold = newSold,
                currentDessertIndex = newIndex
            )
        }
    }
}

data class Dessert(
    val id: Int,
    val name: String,
    val price: Int,
    val startProductionAmount: Int
)