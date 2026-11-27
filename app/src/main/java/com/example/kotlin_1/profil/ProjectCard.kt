package com.example.kotlin_1.profil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kotlin_1.Project

@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text       = project.name,
                style      = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text  = project.description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
