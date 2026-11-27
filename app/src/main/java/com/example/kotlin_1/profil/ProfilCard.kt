package com.example.kotlin_1.profil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlin_1.Project
import com.example.kotlin_1.shared.Action
import com.example.kotlin_1.shared.Information
import com.example.kotlin_1.shared.SectionTitle



@Composable
fun ProfilCard(
    name: String,
    title: String,
    age: Int,
    description: String,
    skills: List<String>,
    projects : List<Project>,
    email: String,
    availability: String,
    onContactClick: () -> Unit,
    search: String,
    onSearch: (String) -> Unit,
    onToggleFavorite: (Int) -> Unit,
    onToggleFavoritesOnlyFilter: () -> Unit,
    onToggleDoneOnlyFilter: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cardShape     = RoundedCornerShape(12.dp)
    val cardElevation = 4.dp
    val sectionSpace  = 16.dp

    Surface(
        shape           = cardShape,
        shadowElevation = cardElevation,
        modifier        = modifier
    ) {
        var value = ""
        // The whole card scrolls, so the project list keeps its natural height.
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            ProfilHeader(
                name        = name,
                title       = title,
                age         = age,
                description = description,
                modifier    = Modifier.padding(bottom = sectionSpace)
            )


            SectionTitle(text = "Compétences")

            LazyRow(modifier    = Modifier.padding(bottom = sectionSpace)) {
                items(skills){ skill ->
                    Skill(
                        sentence = skill,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }

            SectionTitle(text = "Projets")



            OutlinedTextField(
                value = search,
                onValueChange = onSearch,
                label = { Text(text = "Rechercher un projet") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )



            LazyColumn(modifier = Modifier.heightIn(max = 320.dp)) {
                items(projects) { project ->
                    ProjectCard(
                        project  = project,
                        modifier = Modifier.padding(bottom = 6.dp).fillMaxWidth()
                    )
                }
            }


            Information(
                title    = "Contact",
                sentence = email,
                modifier = Modifier.padding(top = sectionSpace)
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
