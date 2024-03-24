package com.nohjason.logintest.screen

import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.nohjason.logintest.R

@Composable
fun Login(
    navController: NavController,
    googleSignInClient: GoogleSignInClient,
    user: FirebaseUser?,
    launcher: ManagedActivityResultLauncher<Intent, androidx.activity.result.ActivityResult>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(painter = painterResource(id = R.drawable.vector), contentDescription = null)

        Spacer(modifier = Modifier.height(60.dp))

        Icon(painter = painterResource(id = R.drawable.loginfirsttext), contentDescription = null)
        
        Spacer(modifier = Modifier.height(200.dp))

        Text(
            "SNS 로그인",
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp,
            color = Color.DarkGray
        )

        Canvas(
            modifier = Modifier
                .width(346.dp)
                .padding(top = 15.dp, bottom = 10.dp)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawLine(
                start = Offset(x = 0.dp.toPx(), y = canvasHeight / 2),
                end = Offset(x = canvasWidth, y = canvasHeight / 2),
                color = Color.DarkGray,
                strokeWidth = 1.dp.toPx() // instead of 5.dp.toPx() , you can also pass 5f
            )
        }
        IconButton(onClick = {
            launcher.launch(googleSignInClient.signInIntent)
            navController.navigate("profile")
        }) {
            Icon(
                painter = painterResource(com.google.android.gms.base.R.drawable.googleg_disabled_color_18),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}