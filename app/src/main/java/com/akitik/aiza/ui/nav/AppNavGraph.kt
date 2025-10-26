package com.akitik.aiza.ui.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.*
import com.akitik.aiza.ui.chat.ChatScreen
import com.akitik.aiza.ui.history.HistoryScreen
import com.akitik.aiza.ui.settings.SettingsScreen


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "chat") {
        composable("chat") { ChatScreen() }
        composable("history") { HistoryScreen() }
        composable("settings") { SettingsScreen() }
    }
}
