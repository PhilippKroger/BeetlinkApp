package com.example.beetlinkapp.view.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beetlinkapp.R
import com.example.beetlinkapp.ui.theme.mFontFamily

@Composable
fun AuthEntity(title: String, text: String, link: String) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Box(
        modifier = Modifier.background(Color(0xFFF3F3F3))
    ) {
        Box(modifier = Modifier) {
            Column(
                modifier = Modifier
                    .background(Color(0xFFFFFFFF))
                    .fillMaxSize()
                    .padding(top = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(modifier = Modifier.padding(start=45.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_icon),
                        contentDescription = "",
                        modifier = Modifier.padding(top = 8.dp).size(30.dp)
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 7.dp)
                            .padding(top = 8.dp),
                        text = stringResource(R.string.beetlink),
                        color = Color(0xFF000000),
                        fontSize = 20.sp,
                        fontFamily = mFontFamily
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 45.dp, bottom = 10.dp),
                    fontFamily= mFontFamily,
                    text = title,
                    color = Color(0xFF000000),
                    fontSize = 36.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 48.dp, vertical = 8.dp),
                    value = email,
                    onValueChange = { email = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    textStyle = TextStyle(fontFamily = mFontFamily, fontSize = 16.sp, color = Color.Black),
                    label = { Text(text="почта@mail.ru", fontFamily = mFontFamily) })

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 48.dp, vertical = 8.dp),
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text="пароль", fontFamily = mFontFamily) },
                    textStyle = TextStyle(fontFamily = mFontFamily, fontSize = 16.sp, color = Color.Black),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password))

                TextButton(
                    modifier = Modifier
                        .padding(start = 45.dp, top = 10.dp)
                        .width(320.dp)
                        .background(Color.Black, shape = RoundedCornerShape(16.dp)),
                    onClick = {  }, //loginUser(context, email, password)
                ) {
                    Text(
                        text = stringResource(R.string.dalee),
                        color = Color.White,
                        fontFamily= mFontFamily
                    )
                }

                Row(modifier = Modifier.padding(start=45.dp)) {
                    Text(
                        modifier = Modifier.padding(top = 15.dp),
                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                        text = text,
                        color = Color(0xFFBBBBBB),
                        fontSize = 16.sp
                    )

                    TextButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            modifier = Modifier,
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = link,
                            color = Color(0xFF000000),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}

/*
@Composable
fun AuthEmailTextField(
    email: String,
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 8.dp),
        value = email,
        onValueChange = { email = it },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
        textStyle = TextStyle(fontFamily = mFontFamily, fontSize = 16.sp, color = Color.Black),
        label = { Text(text="почта@mail.ru", fontFamily = mFontFamily) })
}


@Composable
fun AuthPasswordTextField(
    password: String,
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 8.dp),
        value = password,
        onValueChange = { password = it },
        label = { Text(text="пароль", fontFamily = mFontFamily) },
        textStyle = TextStyle(fontFamily = mFontFamily, fontSize = 16.sp, color = Color.Black),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password))
}

 */

fun onButtonClick() {
    // Отправка данных, например на сервер или в базу данных
    // Здесь можно использовать значения переменных emailValue и passwordValue
}