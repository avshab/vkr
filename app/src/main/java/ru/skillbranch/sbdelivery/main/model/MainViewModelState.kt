package ru.skillbranch.sbdelivery.main.model

sealed class MainViewModelState {

    object Loading : MainViewModelState()

    data class AuthState(val userName: String, val email: String) : MainViewModelState()

    object NoAuthState : MainViewModelState()

    data class Error(val message: String) : MainViewModelState()
}