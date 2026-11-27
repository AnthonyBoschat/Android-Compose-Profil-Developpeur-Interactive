package com.example.kotlin_1.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kotlin_1.Project
import com.example.kotlin_1.shared.Action
import com.example.kotlin_1.shared.Information
import com.example.kotlin_1.shared.SectionTitle

val skills: List<String> = listOf(
    "Kotlin et Jetpack Compose",
    "JavaScript, TypeScript et React",
    "Python et Django (Framework)",
    "Conception de bases de données",
    "Git et DevOps (CICD)"
)

@Composable
fun ProfileCard(
    name: String,
    title: String,
    age: Int,
    description: String,
    projects : List<Project>,
    email: String,
    availability: String,
    onContactClick: () -> Unit,
    search: String,
    favorites: List<Int>,
    onSearch: (String) -> Unit,
    filterFavorites: Boolean,
    filterDone: Boolean,
    onToggleFavorite: (Int) -> Unit,
    onToggleFavoritesOnlyFilter: () -> Unit,
    onToggleDoneOnlyFilter: () -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(
        shape           = RoundedCornerShape(12.dp),
        shadowElevation = 4.dp,
        modifier        = modifier
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            ProfileHeader(
                name        = name,
                title       = title,
                age         = age,
                description = description,
                modifier    = Modifier.padding(bottom = 16.dp)
            )


            SectionTitle(text = "Compétences")

            LazyRow(modifier    = Modifier.padding(bottom = 16.dp)) {
                items(skills){ skill ->
                    Skill(
                        sentence = skill,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }

            SectionTitle(text = "Projets (${projects.size})")



            OutlinedTextField(
                value = search,
                onValueChange = onSearch,
                label = { Text(text = "Rechercher un projet") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )

            Row(modifier = Modifier.padding(bottom = 16.dp)){


                val favoriteOnlyContainerColor = if (filterFavorites) MaterialTheme.colorScheme.primary else Color.Transparent
                val favoriteOnlyContentColor   = if (filterFavorites) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary

                val doneContainerColor = if (filterDone) MaterialTheme.colorScheme.primary else Color.Transparent
                val doneContentColor   = if (filterDone) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary


                OutlinedButton(
                    onClick = onToggleFavoritesOnlyFilter,
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = favoriteOnlyContainerColor,
                        contentColor = favoriteOnlyContentColor
                    )
                ) {
                    Text("Mes favoris")
                }

                Spacer(modifier = Modifier.width(4.dp))

                OutlinedButton(
                    onClick = onToggleDoneOnlyFilter,
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = doneContainerColor,
                        contentColor = doneContentColor
                    )
                ) {
                    Text("Projet terminées")
                }

            }



            LazyColumn(modifier = Modifier.heightIn(max = 320.dp)) {
                items(projects) { project ->
                    ProjectCard(
                        project  = project,
                        modifier = Modifier.padding(bottom = 6.dp).fillMaxWidth(),
                        onToggleFavorite = onToggleFavorite,
                        isFavorite = project.id in favorites
                    )
                }
            }


            Information(
                title    = "Contact",
                sentence = email,
                modifier = Modifier.padding(top = 16.dp)
            )

            Information(
                title    = "Disponibilité",
                sentence = availability,
                modifier = Modifier.padding(top = 12.dp)
            )

            Action(
                title    = "Contacter $name",
                onClick  = onContactClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            )
        }
    }
}
