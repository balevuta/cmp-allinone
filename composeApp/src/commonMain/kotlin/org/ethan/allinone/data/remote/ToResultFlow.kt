package org.ethan.allinone.data.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.ethan.allinone.utils.UiState

fun <T> toResultFlow(call: suspend () -> T?): Flow<UiState<T?>> {
    return flow<UiState<T?>> {
        emit(UiState.Loading)
        val c = call.invoke()
        c.let { response ->
            try {
                emit(UiState.Success(response))
            } catch (e: Exception) {
                emit(UiState.Error(e.toString()))
            }
        }
    }.flowOn(Dispatchers.IO)
}
