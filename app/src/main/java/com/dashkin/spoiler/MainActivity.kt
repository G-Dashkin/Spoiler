package com.dashkin.spoiler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dashkin.spoiler.ui.theme.SpoilerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpoilerTheme {
                // Navigation graph will be wired here once feature modules are implemented
            }
        }
    }
}
