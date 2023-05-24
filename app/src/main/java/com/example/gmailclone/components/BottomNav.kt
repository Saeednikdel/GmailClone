package com.example.gmailclone.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.gmailclone.navigation.DrawerItems
import kotlinx.coroutines.launch
import androidx.compose.material3.Icon
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmailclone.navigation.DrawerItemClass
import com.example.gmailclone.navigation.Screens
import com.example.gmailclone.ui.theme.GmailCloneTheme

@Composable
fun BottomNav() {
    var selectedItem by remember { mutableStateOf(BottomNavItems[0]) }
    NavigationBar {
        BottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = selectedItem == item,
                onClick = { selectedItem = item },
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) })
        }
    }

}

val BottomNavItems = arrayListOf(
    DrawerItemClass(
        "mail",
        "",
        Icons.Default.Email
    ),
    DrawerItemClass(
        "meet",
        "",
        Icons.Default.Call
    )
)

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    GmailCloneTheme {
        BottomNav()
    }
}