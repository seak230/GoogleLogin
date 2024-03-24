package com.nohjason.logintest.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseUser

@Composable
fun Profile (navController: NavController, user: FirebaseUser?, googleSignInClient: GoogleSignInClient) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box {
            AsyncImage(
                model = "${user!!.photoUrl}",
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = " ${user!!.displayName}",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            googleSignInClient.signOut()
            navController.navigate("login")
        }) {
            Text("Sign out")
        }
    }
}