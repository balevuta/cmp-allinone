package org.ethan.allinone.viewmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.ethan.allinone.utils.UiState

open class BaseViewModel() {

    suspend fun <T> fetchData(
        uiStateFlow: MutableStateFlow<UiState<T?>>,
        apiCall: suspend () -> Flow<UiState<T?>>
    ) {
        uiStateFlow.value = UiState.Loading
        try {
            apiCall().collect {
                uiStateFlow.value = it
            }
        } catch (e: Exception) {
            uiStateFlow.value = UiState.Error(e.message ?: "")
        }
    }
}