package com.example.kotlin_1.shared

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Action(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick  = onClick,
        modifier = modifier,
        shape    = RoundedCornerShape(8.dp),
    ) {
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = "Envoyer un mail à Anthony Boschay"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title)
    }
}
