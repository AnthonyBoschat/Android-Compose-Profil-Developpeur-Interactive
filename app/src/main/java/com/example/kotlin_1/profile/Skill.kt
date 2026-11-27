package com.example.kotlin_1.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Skill(
    sentence: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Text(
            text     = sentence,
            style    = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}
