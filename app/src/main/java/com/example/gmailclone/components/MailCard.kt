package com.example.gmailclone.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailclone.data.MailData


@Composable
fun MailCard(mailData: MailData) {
    Row(modifier = Modifier.padding(8.dp)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
        ) {
            Text(
                text = mailData.userName[0].toString().toUpperCase(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(modifier = Modifier.weight(2.0f)) {
            Text(text = mailData.userName, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = mailData.subject, fontWeight = FontWeight.Bold)
            Text(text = mailData.body)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = mailData.timeStamp)
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 16.dp)) {
                Icon(imageVector = Icons.Outlined.Star, contentDescription = "star")

            }
        }
    }
    Divider()
}