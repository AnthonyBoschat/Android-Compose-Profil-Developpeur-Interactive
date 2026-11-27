package com.example.kotlin_1.profil

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_1.Project
import com.example.kotlin_1.theme.Kotlin1Theme

@Composable
fun Profil(modifier: Modifier = Modifier) {
    val skills: List<String> = listOf(
        "Kotlin et Jetpack Compose",
        "JavaScript, TypeScript et React",
        "Python et Django (Framework)",
        "Conception de bases de données",
        "Git et DevOps (CICD)"
    )
    val projects: List<Project> = listOf(
        Project("Google 2", "Un moteur de recherche comme Google, mais plus beua, plus rapide, parceque les ingénieurs de google sont mauvais"),
        Project("Ariane 6", "Projet qui vise à éviter à nos fusée de se crasher."),
        Project("Orion", "Une application qui permet de savoir ou se trouve les constellations dans le ciel.")
    )

    ProfilCard(
        name         = "Anthony Boschat",
        title        = "Concepteur & développeur d'application",
        age          = 32,
        description  = "Développeur full-stack passionné par la compréhension des systèmes, les sciences et l’automatisation. Je conçois et développe des solutions adaptées à vos besoins.",
        skills       = skills,
        projects = projects,
        email        = "AnthonyBoschat.dev@hotmail.com",
        availability = "Non disponible",
        onContactClick = {

        },
        modifier     = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilLightPreview() {
    Kotlin1Theme {
        Profil(
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilDarkPreview() {
    Kotlin1Theme(darkTheme = true) {
        Profil(
            modifier = Modifier.padding(16.dp)
        )
    }
}
