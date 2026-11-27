package com.example.kotlin_1.profile

import com.example.kotlin_1.Project

data class ProfileUiState(
    val projects: List<Project> = emptyList(),
    val search: String = "",
    val favorites: List<Int> = emptyList(),
    val filterFavorites: Boolean = false,
    val filterDone: Boolean = false,
)