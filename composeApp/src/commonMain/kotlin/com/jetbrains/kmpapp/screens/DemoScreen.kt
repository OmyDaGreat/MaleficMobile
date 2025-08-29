package com.jetbrains.kmpapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DemoScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var greetedName by remember { mutableStateOf<String?>(null) }
    var counter by remember { mutableStateOf(0) }

    Column(
        modifier.padding(16.dp),
        Arrangement.spacedBy(12.dp),
        Alignment.CenterHorizontally,
    ) {
        Text("Demo page")

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Your name") },
        )

        Button(onClick = { greetedName = name.ifBlank { null } }) {
            Text("Greet")
        }

        greetedName?.let {
            Text("Hello, $it!")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text("Counter: $counter")
            Button(onClick = { counter-- }) { Text("-") }
            Button(onClick = { counter++ }) { Text("+") }
        }
    }
}
