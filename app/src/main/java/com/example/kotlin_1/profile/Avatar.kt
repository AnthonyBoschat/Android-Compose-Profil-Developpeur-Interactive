package com.example.kotlin_1.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kotlin_1.R

@Composable
fun Avatar(
    name: String,
    modifier: Modifier = Modifier
){
    Row(verticalAlignment = Alignment.CenterVertically){
        Image(
            contentDescription = "Avatar",
            painter = painterResource(R.drawable.ic_launcher_foreground),
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
    }
}
