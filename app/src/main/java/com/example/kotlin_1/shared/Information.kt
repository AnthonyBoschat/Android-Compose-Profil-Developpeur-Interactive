package com.example.kotlin_1.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Information(
    title: String,
    sentence: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value         = sentence,
        onValueChange = {},
        readOnly      = true,
        label         = {
            Text(text = title)
        },
        modifier = modifier.fillMaxWidth()
    )
}
