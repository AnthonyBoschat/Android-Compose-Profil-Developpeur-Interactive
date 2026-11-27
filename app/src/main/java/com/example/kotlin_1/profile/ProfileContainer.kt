package com.example.kotlin_1.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileContainer(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel()
){
    val uiState by viewModel.uiState.collectAsState()

    ProfileScreen(
        projects = uiState.projects,
        search = uiState.search,
        favorites = uiState.favorites,
        onSearch = viewModel::onSearchQueryChange,
        filterFavorites = uiState.filterFavorites,
        filterDone = uiState.filterDone,
        onToggleFavorite = viewModel::onFavoriteClick,
        onToggleFavoritesOnlyFilter = viewModel::onToggleFavoriteOnlyFilter,
        onToggleDoneOnlyFilter = viewModel::onToggleDoneOnlyFilter,
    )
}