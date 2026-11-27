package com.example.kotlin_1.profil

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfilContainer(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel()
){
    val uiState by viewModel.uiState.collectAsState()

    ProfileScreen(
        projects = uiState.projects,
        search = uiState.search,
        onSearch = viewModel::onSearchQueryChange,
        filterFavorites = uiState.filterFavorites,
        filterDone = uiState.filterDone,
        onToggleFavorite = viewModel::onFavoriteClick,
        onToggleFavoritesOnlyFilter = viewModel::onToggleFavoriteOnlyFilter,
        onToggleDoneOnlyFilter = viewModel::onToggleDoneOnlyFilter,
    )
}