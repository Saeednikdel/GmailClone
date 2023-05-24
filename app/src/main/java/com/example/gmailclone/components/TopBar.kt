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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmailclone.R
import com.example.gmailclone.ui.theme.GmailCloneTheme
import kotlinx.coroutines.CoroutineScope

@Composable
fun AppBar() {
    Box(modifier = Modifier.padding(10.dp)){
        Card(modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")

                }
                BasicTextField(value ="search in mail", singleLine = true, onValueChange = {},
                    modifier = Modifier.weight(weight = 2.0f))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "avatar",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(color = Color.Green))
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    GmailCloneTheme {
        AppBar()
    }
}