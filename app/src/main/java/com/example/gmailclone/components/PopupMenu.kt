package com.example.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.example.gmailclone.R

@Composable
fun PopupMenu(togglePopup: () -> Unit) {
    Popup(
        alignment = Alignment.Center,
        onDismissRequest = { togglePopup() },
        properties = PopupProperties(focusable = true, dismissOnBackPress = true)
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(), modifier = Modifier.width(320.dp),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { togglePopup() }) {
                        Icon(imageVector = Icons.Outlined.Close, contentDescription = "close")
                    }
                    Text(text = "Google", modifier = Modifier.padding(start = 70.dp))
                }
                Row(modifier = Modifier.padding(top = 16.dp)) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "avatar",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(color = Color.Green)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(text = "John Doe", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(text = "johndoe@gmail.com", fontWeight = FontWeight.Bold)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedButton(onClick = { /*TODO*/ }) {
                        Text(text = "Add another account")
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Privacy Policy", fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Terms of service", fontSize = 14.sp)
                    }
                }
            }
        }

    }
}