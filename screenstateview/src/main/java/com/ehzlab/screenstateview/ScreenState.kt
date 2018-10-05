package com.ehzlab.screenstateview

sealed class ScreenState {
    object Loading : ScreenState()
    object Empty : ScreenState()
    object Error : ScreenState()
    object Show : ScreenState()
}