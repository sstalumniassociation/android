package org.sstaa.SST_Alumni

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sstaa.SST_Alumni.ui.theme.SSTAlumniTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSTAlumniTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())) {
                        Column(modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(16.dp))) {
                            MembershipCard("Android")
                            Column (modifier = Modifier.padding(16.dp)) {
                                Text(text = "Coming Back?", fontWeight = FontWeight.Bold)
                                Text(text = "Tap on this card and present it to security at the front gate.")
                            }
                        }

//                        Column(modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)) {
//                            Text("Your Bookings/Events", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
//                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MembershipCard(name: String) {
    Card(modifier = Modifier
        .aspectRatio(1.7355769F)
        .shadow(16.dp), shape = RoundedCornerShape(16.dp)) {
        Column(modifier = Modifier
            .background(brush = Brush.linearGradient(colors = listOf(
                Color(0xFFFF3B30),
                Color(0xFFFF3B30),
            ), start = Offset.Zero, end = Offset.Infinite))
            .padding(24.dp)
        ) {
            Text(text = name, fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1F))
            Row {
                Column {
                    Text(text = "Class of 2020", color = Color.White)
                    Text(text = "Associate Member", color = Color.White)
                }
                Spacer(modifier = Modifier.weight(1F))
                Text("blah blah", modifier = Modifier.align(Alignment.Bottom), color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SSTAlumniTheme {
        MembershipCard("Android")
    }
}