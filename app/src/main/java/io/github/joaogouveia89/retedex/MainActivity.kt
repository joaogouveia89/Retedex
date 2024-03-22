package io.github.joaogouveia89.retedex

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.joaogouveia89.retedex.core.presentation.MainScreen
import io.github.joaogouveia89.retedex.ui.theme.RetedexTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetedexTheme {
                MainScreen(navController = rememberNavController())
            }
        }
    }
}