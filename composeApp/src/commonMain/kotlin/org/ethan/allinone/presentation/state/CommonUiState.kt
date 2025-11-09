package org.ethan.allinone.presentation.state

sealed class CommonUiState<out T> {
    data class Success<T>(val data: T) : CommonUiState<T>()
    data class Error<T>(val message: String) : CommonUiState<T>()
    data object Loading : CommonUiState<Nothing>()
}