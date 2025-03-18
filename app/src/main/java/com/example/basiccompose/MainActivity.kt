package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                ChatScreen()
            }
        }
    }
}

@Composable
fun ChatScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF1F8E9))
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            ChatBubble(
                name = "Danny",
                message = "Little Orange.",
                time = "10:30 AM",
                backgroundColor = Color(0xFFFFF176),
                textColor = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            ChatBubble(
                name = "Danny",
                message = "Testing membuat sebuah project dari Jetpack Composeable UI.",
                time = "10:32 AM",
                backgroundColor = Color(0xFF4DB6AC),
                textColor = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            ChatBubble(
                name = "Danny",
                message = "Nama : Danny, dengan Nim : 42330039",
                time = "10:35 AM",
                backgroundColor = Color(0xFFBA68C8),
                textColor = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))


            HorizontalDivider(
                thickness = 3.dp,
                color = Color(0xFF81C784)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "📨 Percakapan Terakhir",
                    fontSize = 24.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Selamat Belajar tentang Jetpack Compose. Semoga harimu menyenangkan.",
                    fontSize = 22.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun ChatBubble(
    name: String,
    message: String,
    time: String,
    backgroundColor: Color,
    textColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {

        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF90CAF9), CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1B5E20)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Surface(
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 4.dp,
                color = backgroundColor
            ) {
                Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)) {
                    Text(
                        text = message,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = textColor
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = time,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = textColor.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatScreen() {
    BasicComposeTheme {
        ChatScreen()
    }
}
