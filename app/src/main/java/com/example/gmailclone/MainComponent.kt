package com.example.gmailclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.gmailclone.components.AppBar
import com.example.gmailclone.components.BottomNav
import com.example.gmailclone.navigation.DrawerItems
import com.example.gmailclone.navigation.NavGraph
import com.example.gmailclone.ui.theme.GmailCloneTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainComponent() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedItem = remember { mutableStateOf(DrawerItems[0]) }
    val navController = rememberNavController()

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Spacer(Modifier.height(12.dp))
            NavigationDrawerItem(label = { Text(text = "Gmail" , fontSize = 20.sp) }, icon = {
                Image(
                    painter = painterResource(id = R.drawable.gmail),
                    contentDescription = "gmail",
                    modifier = Modifier.size(40.dp)
                )
            }, onClick = { /*TODO*/ }, selected = false)
            Divider()
            Spacer(Modifier.height(6.dp))
            DrawerItems.forEach { item ->
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            item.icon,
                            contentDescription = "Localized description"
                        )
                    },
                    label = { Text(item.title) },
                    selected = item == selectedItem.value,
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                        }
                        scope.launch { drawerState.close() }
                        selectedItem.value = item
                    })
            }
            Spacer(Modifier.height(6.dp))
            Divider()
        }
    }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Scaffold(topBar = { AppBar(scope, drawerState) },
                bottomBar = { BottomNav() },
                content = { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        NavGraph(navController = navController)
                    }
                })
        }
    })

}


@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    GmailCloneTheme {
        MainComponent()
    }
}