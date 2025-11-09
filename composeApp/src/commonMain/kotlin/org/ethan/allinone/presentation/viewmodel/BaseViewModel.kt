package org.ethan.allinone.presentation.viewmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.ethan.allinone.presentation.state.CommonUiState

open class BaseViewModel() {
    suspend fun <T> fetchData(
        uiStateFlow: MutableStateFlow<CommonUiState<T>>,
        apiCall: suspend () -> Flow<CommonUiState<T>>
    ) {
        uiStateFlow.value = CommonUiState.Loading
        try {
            apiCall().collect {
                uiStateFlow.value = it
            }
        } catch (e: Exception) {
            uiStateFlow.value = CommonUiState.Error(e.message ?: "Unknown error")
        }
    }
}