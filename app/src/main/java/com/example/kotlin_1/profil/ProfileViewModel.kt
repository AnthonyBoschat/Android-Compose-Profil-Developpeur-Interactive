package com.example.kotlin_1.profil

import androidx.lifecycle.ViewModel
import com.example.kotlin_1.Project
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel: ViewModel(){
    private val allProjects : List<Project> = listOf(
        Project(
            id = 1,
            name = "Google 2",
            description = "Un moteur de recherche comme Google, mais plus beua, plus rapide, parceque les ingénieurs de google sont mauvais",
            done = true,
            technologies = listOf("HTML", "CSS", "Javascript", "PHP")

        ),
        Project(
            id = 2,
            name = "Ariane 6",
            description = "Projet qui vise à éviter à nos fusée de se crasher.",
            done = true,
            technologies = listOf("React", "PHP (Laravel)")
        ),
        Project(
            id = 3,
            name = "Orion",
            description = "Une application qui permet de savoir ou se trouve les constellations dans le ciel.",
            done = false,
            technologies = listOf("Angular", "Node (Javascript)")
        ),
        Project(
            id = 4,
            name = "Share-Care",
            description = "Une application qui permet de contacter des proches de confiance lorsqu'on ne se sent pas bien, qu'on subit une crise.",
            done = false,
            technologies = listOf("React", "Django (Python)")
        ),
        Project(
            id = 5,
            name = "Edusign 2",
            description = "Une application qui fonctionne enfin correctement.",
            done = false,
            technologies = listOf("HTML", "CSS", "Javascript", "PHP")
        ),
    )

    private val _uiState = MutableStateFlow(
        value = ProfileUiState(
            allProjects
        )
    )

    val uiState : StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private fun filterProjects(state: ProfileUiState): List<Project>{
        return allProjects.filter{ project -> 
            val matchesSearch = project.name.contains(state.search, ignoreCase = true) ||
                    project.description.contains(state.search, ignoreCase = true) ||
                    project.technologies.any { technology ->
                        technology.contains(state.search, ignoreCase = true)
                    }

            val matchesFavorite =
                !state.filterFavorites || project.id in state.favorites

            val matchesDone =
                !state.filterDone || project.done

            matchesSearch && matchesFavorite && matchesDone

        }
    }

    private fun updateState(transform: (ProfileUiState) -> ProfileUiState) {
        _uiState.update { currentState ->
            val newState = transform(currentState)
            newState.copy(projects = filterProjects(newState))
        }
    }


    fun onSearchQueryChange(newValue: String){
        updateState { currentState -> currentState.copy(search = newValue) }
    }

    fun onToggleFavoriteOnlyFilter(){
        updateState { currentState -> currentState.copy(filterFavorites = !currentState.filterFavorites) }
    }

    fun onToggleDoneOnlyFilter(){
        updateState { currentState -> currentState.copy(filterDone = !currentState.filterDone) }
    }

    fun onFavoriteClick(projectId: Int){
        updateState { currentState ->

            val newFavorites =
                if(projectId in currentState.favorites){
                    currentState.favorites - projectId
                } else {
                    currentState.favorites + projectId
                }

            currentState.copy(favorites = newFavorites)
        }
    }

}