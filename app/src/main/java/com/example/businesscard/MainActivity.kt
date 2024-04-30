package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(R.drawable.icon)
        Image(painter = image, contentDescription = null, modifier = Modifier.size(150.dp))
        Text(
            text = stringResource(R.string.full_name),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ){
            Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 50.dp)
            ){
                val phone = painterResource(R.drawable.baseline_phone_24)
                Image(painter = phone, contentDescription = null, modifier = Modifier.padding(8.dp))
                Text(text = stringResource(R.string.phone_number), modifier = Modifier.padding(8.dp))
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 50.dp)
            ){
                val emailIcon = painterResource(R.drawable.baseline_alternate_email_24)
                Image(painter = emailIcon, contentDescription = null, modifier = Modifier.padding(8.dp))
                Text(text = stringResource(R.string.email), modifier = Modifier.padding(8.dp))
            }
        }
        Text(
            text = "SKILLS:",
            modifier = Modifier.padding(16.dp).align(Alignment.Start),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.skills),
            modifier = Modifier.padding(16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}