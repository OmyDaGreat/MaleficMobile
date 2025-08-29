package com.jetbrains.kmpapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jetbrains.kmpapp.screens.DemoScreen
import com.jetbrains.kmpapp.screens.EmptyScreenContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var showDemo by remember { mutableStateOf(false) }

    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme(),
    ) {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            TopAppBar(
                title = { Text(if (showDemo) "Demo" else "Home") },
                actions = {
                    TextButton(onClick = { showDemo = false }) { Text("Home") }
                    TextButton(onClick = { showDemo = true }) { Text("Demo") }
                },
            )
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                if (showDemo) {
                    DemoScreen(Modifier.fillMaxWidth())
                } else {
                    EmptyScreenContent(Modifier.fillMaxWidth())
                }
            }
        }
    }
}
