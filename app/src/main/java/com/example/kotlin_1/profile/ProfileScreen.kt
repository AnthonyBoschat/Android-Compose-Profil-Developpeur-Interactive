package com.example.kotlin_1.profile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_1.Project
import com.example.kotlin_1.theme.Kotlin1Theme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    projects: List<Project>,
    search: String,
    favorites: List<Int>,
    onSearch: (String) -> Unit,
    filterFavorites: Boolean,
    filterDone: Boolean,
    onToggleFavorite: (Int) -> Unit,
    onToggleFavoritesOnlyFilter: () -> Unit,
    onToggleDoneOnlyFilter: () -> Unit,
) {



    ProfileCard(
        name         = "Anthony Boschat",
        title        = "Concepteur & développeur d'application",
        age          = 32,
        description  = "Développeur full-stack passionné par la compréhension des systèmes, les sciences et l’automatisation. Je conçois et développe des solutions adaptées à vos besoins.",
        projects     = projects,
        email        = "AnthonyBoschat.dev@hotmail.com",
        availability = "Non disponible",
        onContactClick = {},

        search = search,
        onSearch = onSearch,
        favorites = favorites,
        filterFavorites = filterFavorites,
        filterDone = filterDone,
        onToggleFavorite = onToggleFavorite,
        onToggleFavoritesOnlyFilter = onToggleFavoritesOnlyFilter,
        onToggleDoneOnlyFilter = onToggleDoneOnlyFilter,

        modifier     = modifier.fillMaxWidth(),
    )
}















//////////////////////////////
// Preview
//////////////////////////////



private val googleProject = Project(
    id           = 1,
    name         = "Google 2",
    description  = "Un moteur de recherche comme Google, mais plus beau et plus rapide.",
    technologies = listOf("HTML", "CSS", "Javascript", "PHP"),
    done         = true
)

private val arianeProject = Project(
    id           = 2,
    name         = "Ariane 6",
    description  = "Projet qui vise à éviter à nos fusées de se crasher.",
    technologies = listOf("React", "PHP (Laravel)"),
    done         = true
)

private val orionProject = Project(
    id           = 3,
    name         = "Orion",
    description  = "Une application qui permet de savoir où se trouvent les constellations dans le ciel.",
    technologies = listOf("Angular", "Node (Javascript)"),
    done         = false
)

// Stateless previews: fixed state, no ViewModel. The projects list is what the ViewModel filter would return.

@Preview(name = "Aucun filtre", showBackground = true, showSystemUi = true)
@Composable
fun ProfileNoFilterPreview() {
    Kotlin1Theme {
        ProfileScreen(
            modifier                    = Modifier.padding(16.dp),
            projects                    = listOf(googleProject, arianeProject, orionProject),
            search                      = "",
            favorites                   = emptyList(),
            onSearch                    = {},
            filterFavorites             = false,
            filterDone                  = false,
            onToggleFavorite            = {},
            onToggleFavoritesOnlyFilter = {},
            onToggleDoneOnlyFilter      = {},
        )
    }
}

@Preview(name = "Projets terminés", showBackground = true, showSystemUi = true)
@Composable
fun ProfileDoneFilterPreview() {
    Kotlin1Theme {
        ProfileScreen(
            modifier                    = Modifier.padding(16.dp),
            projects                    = listOf(googleProject, arianeProject),
            search                      = "",
            favorites                   = emptyList(),
            onSearch                    = {},
            filterFavorites             = false,
            filterDone                  = true,
            onToggleFavorite            = {},
            onToggleFavoritesOnlyFilter = {},
            onToggleDoneOnlyFilter      = {},
        )
    }
}

@Preview(name = "Un favori + filtre favoris", showBackground = true, showSystemUi = true)
@Composable
fun ProfileFavoritesFilterPreview() {
    Kotlin1Theme {
        ProfileScreen(
            modifier                    = Modifier.padding(16.dp),
            projects                    = listOf(arianeProject),
            search                      = "",
            favorites                   = listOf(2),
            onSearch                    = {},
            filterFavorites             = true,
            filterDone                  = false,
            onToggleFavorite            = {},
            onToggleFavoritesOnlyFilter = {},
            onToggleDoneOnlyFilter      = {},
        )
    }
}

@Preview(name = "Recherche « google »", showBackground = true, showSystemUi = true)
@Composable
fun ProfileSearchGooglePreview() {
    Kotlin1Theme {
        ProfileScreen(
            modifier                    = Modifier.padding(16.dp),
            projects                    = listOf(googleProject),
            search                      = "google",
            favorites                   = emptyList(),
            onSearch                    = {},
            filterFavorites             = false,
            filterDone                  = false,
            onToggleFavorite            = {},
            onToggleFavoritesOnlyFilter = {},
            onToggleDoneOnlyFilter      = {},
        )
    }
}

@Preview(name = "Recherche « Javascript »", showBackground = true, showSystemUi = true)
@Composable
fun ProfileSearchJavascriptPreview() {
    Kotlin1Theme {
        ProfileScreen(
            modifier                    = Modifier.padding(16.dp),
            projects                    = listOf(googleProject, orionProject),
            search                      = "Javascript",
            favorites                   = emptyList(),
            onSearch                    = {},
            filterFavorites             = false,
            filterDone                  = false,
            onToggleFavorite            = {},
            onToggleFavoritesOnlyFilter = {},
            onToggleDoneOnlyFilter      = {},
        )
    }
}
