package com.example.kotlin_1.profil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
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
        Column(modifier = Modifier.padding(20.dp)) {
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

            LazyColumn() {
                items(projects){ project ->
                    ProjectCard(
                        project = project,
                        modifier = Modifier.padding(bottom = 6.dp)
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
