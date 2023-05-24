package com.example.gmailclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gmailclone.screens.AllInboxes
import com.example.gmailclone.screens.Promotions
import com.example.gmailclone.screens.Social

@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.AllInboxes.route)
    {
        composable(route = Screens.AllInboxes.route){
            AllInboxes(navController)
        }
        composable(route = Screens.Social.route){
            Social(navController)
        }
        composable(route = Screens.Promotions.route) {
            Promotions(navController)
        }
    }
}