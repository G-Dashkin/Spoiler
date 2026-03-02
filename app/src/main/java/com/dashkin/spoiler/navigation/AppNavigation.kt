package com.dashkin.spoiler.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dashkin.spoiler.feature.result.presentation.screen.ResultScreen
import com.dashkin.spoiler.feature.search.presentation.screen.SearchScreen
import kotlinx.serialization.Serializable

@Serializable
private data object SearchRoute

@Serializable
private data class ResultRoute(
    val title: String,
    val categoryLabel: String?,
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SearchRoute,
    ) {
        composable<SearchRoute> {
            SearchScreen(
                onSpoilClicked = { query, category ->
                    navController.navigate(ResultRoute(query, category?.label))
                },
            )
        }

        composable<ResultRoute> { backStackEntry ->
            val route: ResultRoute = backStackEntry.toRoute()
            ResultScreen(
                title = route.title,
                categoryLabel = route.categoryLabel,
                onNewSpoilerClicked = { navController.navigateUp() },
            )
        }
    }
}
