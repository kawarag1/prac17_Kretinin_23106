package com.example.prac17api31

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prac17api31.ui.theme.Prac17API31Theme

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Prac17API31Theme {
                Greeting()

            }
        }
    }

    @Composable
    fun Greeting() {
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .paint(painterResource(R.drawable.whitetema), contentScale = ContentScale.FillBounds)
                .fillMaxSize()
        ){
            Column(
                modifier = Modifier.fillMaxSize().offset(0.dp, 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
            ) {
                OutlinedTextField(
                    value = username.value,
                    onValueChange = {username.value = it},
                    label = { Text("Login")}
                )
                OutlinedTextField(
                    value = password.value,
                    onValueChange = {password.value = it},
                    label = { Text("Password")},
                    visualTransformation = PwdTransformation()
                )
                Text(
                    text = "Forgot Password?",
                    fontSize = 16.sp,
                    color = colorResource(R.color.GRAY),
                    modifier = Modifier.clickable( onClick = {
                        Toast.makeText(applicationContext, "Check your mail for further instructions", Toast.LENGTH_LONG)
                            .show()
                    })
                )
                Button(
                    colors = ButtonDefaults.buttonColors(colorResource(R.color.btnColor)),
                    content = { Text("SIGN IN")},
                    modifier = Modifier.width(270.dp).height(45.dp),
                    onClick = {
                        if (username.value.isEmpty() || password.value.isEmpty()){
                            Toast.makeText(applicationContext, "All fields must be filled in!", Toast.LENGTH_LONG)
                                .show()
                        }
                        else{
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        }

                    }
                )
                Text(
                    text = "Create A New Account?",
                    fontSize = 16.sp,
                    color = colorResource(R.color.GRAY),
                    modifier = Modifier.clickable(onClick = {
                        val intent = Intent(applicationContext, RegScreen::class.java)
                        startActivity(intent)
                    }).offset(0.dp, 180.dp)
                )

            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Prac17API31Theme {
            Greeting()
        }
    }
}

