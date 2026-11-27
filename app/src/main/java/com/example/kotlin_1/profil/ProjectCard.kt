package com.example.kotlin_1.profil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kotlin_1.Project
import androidx.compose.material.icons.filled.Star


@Composable
fun ProjectCard(
    project: Project,
    onToggleFavorite: (Int) -> Unit,
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
){
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text       = project.name,
                    style      = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier   = Modifier.weight(1f)
                )
                IconButton(onClick = { onToggleFavorite(project.id) }) {
                    Icon(
                        imageVector        = Icons.Default.Star,
                        contentDescription = if (isFavorite) "Retirer des favoris" else "Ajouter aux favoris",
                        tint               = if (isFavorite) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.outline
                    )
                }
            }

            Text(
                text = if(project.done) "Terminée" else "En cours",
                color = if(project.done) MaterialTheme.colorScheme.onTertiaryContainer else MaterialTheme.colorScheme.tertiaryContainer,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text  = project.description,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text  = project.technologies.joinToString(separator = " • "),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.alpha(0.7f)
            )
        }
    }
}
