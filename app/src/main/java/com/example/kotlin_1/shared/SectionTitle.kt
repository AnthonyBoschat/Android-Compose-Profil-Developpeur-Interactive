package com.example.kotlin_1.shared

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun SectionTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text            = text,
        style           = MaterialTheme.typography.titleSmall,
        fontWeight      = FontWeight.Bold,
        modifier        = modifier.padding(bottom = 8.dp),
        textDecoration  = TextDecoration.Underline,
        color           = MaterialTheme.colorScheme.secondary
    )
}
