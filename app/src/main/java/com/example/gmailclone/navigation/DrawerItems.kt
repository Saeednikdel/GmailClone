package com.example.gmailclone.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person

val DrawerItems = arrayListOf(
    DrawerItemClass(
        "All Inboxes",
        Screens.AllInboxes.route,
        Icons.Default.MailOutline
    ),
    DrawerItemClass(
        "Socials",
        Screens.Social.route,
        Icons.Default.Person
    ),
    DrawerItemClass(
        "Promotions",
        Screens.Promotions.route,
        Icons.Default.AccountBox
    ),
)