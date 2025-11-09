package org.ethan.allinone.presentation.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.ethan.allinone.platform.getPlatform

fun <T> toCommonResultFlow(call: suspend () -> T): Flow<CommonUiState<T>> {
    return flow<CommonUiState<T>> {
        emit(CommonUiState.Loading)
        try {
            val response = call.invoke()
            emit(CommonUiState.Success(response))
        } catch (e: Exception) {
            emit(CommonUiState.Error(e.message ?: "Unknown error"))
        }
    }.flowOn(getPlatform().coroutineDispatcher)
}
