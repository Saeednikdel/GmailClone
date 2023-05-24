package com.example.gmailclone.navigation

sealed class Screens(val route: String) {
    object AllInboxes: Screens("all_inboxes")
    object Social: Screens("social")
    object Promotions: Screens("promotions")
}