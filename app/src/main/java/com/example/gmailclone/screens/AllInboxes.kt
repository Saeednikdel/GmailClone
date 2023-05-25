package com.example.gmailclone.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.gmailclone.components.MailCard
import com.example.gmailclone.data.mailList


@Composable
fun AllInboxes(navController: NavController) {
    LazyColumn {
        items(mailList){
            MailCard(mailData = it)
        }
    }
}
