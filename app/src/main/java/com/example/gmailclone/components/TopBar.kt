package com.example.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gmailclone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(scope: CoroutineScope, drawerState: DrawerState) {
    var popupControl by remember {
        mutableStateOf(false)
    }
    if (popupControl) {
        AccountMenu { popupControl = false }
    }
    Box(modifier = Modifier.padding(10.dp)) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(50.dp), elevation = CardDefaults.cardElevation()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { scope.launch { drawerState.open() } }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")

                }
                BasicTextField(
                    value = "search in mail", singleLine = true, onValueChange = {},
                    modifier = Modifier.weight(weight = 2.0f)
                )
                IconButton(onClick = { popupControl = !popupControl}) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "avatar",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(color = Color.Green)
                    )
                }

            }
        }
    }
}



