package com.bda.purchases_buckets_main

import com.bda.purchases_buckets_main.models.ShoppingBucket
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class PurchasesBucketsMainViewModel {
    private val _state = MutableStateFlow(State.None)
    val state: StateFlow<State>
        get() = _state.asStateFlow()
}

sealed class State {

    object None : State()
    class Loading: State()
    class Error : State()
    class Success(shoppingBucketsList: List<ShoppingBucket>) : State()
}