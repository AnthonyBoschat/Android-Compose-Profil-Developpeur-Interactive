package com.example.kotlin_1.profil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfilHeader(
    name: String,
    title: String,
    age: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Avatar(name = name)
        Text(
            text  = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text     = "$age ans",
            style    = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Text(
            text  = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
