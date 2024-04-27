package com.example.beetlinkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.beetlinkapp.ui.theme.BeetlinkAppTheme
import com.example.beetlinkapp.ui.theme.mFontFamily


class MainActivity : ComponentActivity() {

    private lateinit var sharedPreferences: EncryptedSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        sharedPreferences = EncryptedSharedPreferences.create(
            "secret_shared_prefs",
            masterKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        ) as EncryptedSharedPreferences

        setContent {
            BeetlinkAppTheme {
                Box(
                    modifier = Modifier
                    .verticalScroll(rememberScrollState())
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row{
                            Image(
                                painter = painterResource(id = R.drawable.logo_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 8.dp)
                                    .size(30.dp)
                            )

                            Text(
                                modifier = Modifier
                                    .padding(start = 7.dp)
                                    .padding(top = 8.dp),
                                text = "beetlink",
                                color = Color(0xFF000000),
                                fontSize = 20.sp,
                                fontFamily = mFontFamily
                            )
                        }

                        Row(
                            modifier = Modifier.padding(top=20.dp)
                        ) {
                            TextButton(
                                onClick = { /*TODO*/ }
                            ) {
                                Text(
                                    modifier = Modifier.padding(start = 7.dp),
                                    text = "вход",
                                    color = Color(0xFFBBBBBB),
                                    fontSize = 16.sp,
                                    fontFamily= mFontFamily
                                )
                            }

                            TextButton(
                                modifier = Modifier
                                    .padding(start = 20.dp)
                                    .background(Color.Black, shape = RoundedCornerShape(16.dp)),
                                onClick = { /*TODO*/ },
                            ) {
                                Text(
                                    text = "регистрация",
                                    color = Color.White,
                                    fontFamily= mFontFamily
                                )
                            }
                        }

                        Text(
                            modifier = Modifier.padding(top = 120.dp),
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = "аналитика и таргет трафика",
                            color = Color(0xFF000000),
                            fontSize = 16.sp,
                        )

                        Row {
                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                fontFamily= mFontFamily,
                                text = "beetlink.ru/",
                                color = Color(0xFF000000),
                                fontSize = 36.sp,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )

                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                fontFamily= mFontFamily,
                                text = "код",
                                color = Color(0xFFBBBBBB),
                                fontSize = 36.sp,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }

                        OutlinedButton(
                            modifier = Modifier.padding(top=30.dp),
                            onClick = { /*TODO*/ },
                            border = BorderStroke(1.5.dp, Color.Black),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.tabler_link),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 0.dp)
                                    .size(20.dp)
                            )
                            Text(
                                modifier = Modifier.padding(start=10.dp),
                                text = "короткие ссылки",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontFamily= FontFamily(Font(R.font.montesserat_regular))
                            )
                        }

                        OutlinedButton(
                            modifier = Modifier.padding(top=10.dp),
                            onClick = { /*TODO*/ },
                            border = BorderStroke(1.5.dp, Color.Black),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.tabler_arrow_fork),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 0.dp)
                                    .size(20.dp)
                            )
                            Text(
                                modifier = Modifier.padding(start=10.dp),
                                text = "таргетированные ссылки",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontFamily= FontFamily(Font(R.font.montesserat_regular))
                            )
                        }

                        OutlinedButton(
                            modifier = Modifier.padding(top=10.dp),
                            onClick = { /*TODO*/ },
                            border = BorderStroke(1.5.dp, Color.Black),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.tabler_chart_pie),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 0.dp)
                                    .size(20.dp)
                            )
                            Text(
                                modifier = Modifier.padding(start=10.dp),
                                text = "подробная статистика",
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontFamily= FontFamily(Font(R.font.montesserat_regular))
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.next_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 230.dp)
                                    .size(60.dp)
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(top=50.dp, start = 0.dp, end=0.dp),
                                fontFamily= mFontFamily,
                                text = "функционал сервиса",
                                color = Color(0xFF000000),
                                fontSize = 30.sp,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }

                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier.padding(24.dp)
                                ){
                                    Box(
                                        modifier = Modifier
                                            .size(32.dp)
                                            .border(
                                                width = 1.5.dp,
                                                color = Color(0xFF000000),
                                                shape = RoundedCornerShape(16)
                                            )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.tabler_link),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .padding(top = 5.dp, start = 5.dp)
                                                .size(20.dp)
                                        )
                                    }

                                    Text(
                                        modifier = Modifier.padding(top = 40.dp),
                                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                        text = "короткие ссылки",
                                        color = Color(0xFF000000),
                                        fontSize = 16.sp,
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 70.dp),
                                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                        text = "укороченные ссылки с уникальным кодом в конце, обеспечивающим легкость использования",
                                        color = Color(0xFFBBBBBB),
                                        fontSize = 16.sp,
                                    )
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier.padding(24.dp)
                                ){
                                    Box(
                                        modifier = Modifier
                                            .size(32.dp)
                                            .border(
                                                width = 1.5.dp,
                                                color = Color(0xFF000000),
                                                shape = RoundedCornerShape(16)
                                            )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.tabler_arrow_fork),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .padding(top = 5.dp, start = 5.dp)
                                                .size(20.dp)
                                        )
                                    }

                                    Text(
                                        modifier = Modifier.padding(top = 40.dp),
                                        fontFamily= mFontFamily,
                                        text = "таргетированные ссылки",
                                        color = Color(0xFF000000),
                                        fontSize = 16.sp,
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 70.dp),
                                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                        text = "возможность изменять параметры перенаправления без изменения кода короткой ссылки",
                                        color = Color(0xFFBBBBBB),
                                        fontSize = 16.sp,
                                    )
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )

                            ) {
                                Box(
                                    modifier = Modifier.padding(24.dp)
                                ){
                                    Box(
                                        modifier = Modifier
                                            .size(32.dp)
                                            .border(
                                                width = 1.5.dp,
                                                color = Color(0xFF000000),
                                                shape = RoundedCornerShape(16)
                                            )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.dinam_icon),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .padding(top = 5.dp, start = 5.dp)
                                                .size(20.dp)
                                        )
                                    }

                                    Text(
                                        modifier = Modifier.padding(top = 40.dp),
                                        fontFamily= mFontFamily,
                                        text = "динамические изменения",
                                        color = Color(0xFF000000),
                                        fontSize = 16.sp,
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 70.dp),
                                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                        text = "возможность изменять параметры перенаправления без изменения кода короткой ссылки",
                                        color = Color(0xFFBBBBBB),
                                        fontSize = 16.sp,
                                    )
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier.padding(24.dp)
                                ){
                                    Box(
                                        modifier = Modifier
                                            .size(32.dp)
                                            .border(
                                                width = 1.5.dp,
                                                color = Color(0xFF000000),
                                                shape = RoundedCornerShape(16)
                                            )
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.tabler_chart_pie),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .padding(top = 5.dp, start = 5.dp)
                                                .size(20.dp)
                                        )
                                    }

                                    Text(
                                        modifier = Modifier.padding(top = 40.dp),
                                        fontFamily= mFontFamily,
                                        text = "подробная статистика",
                                        color = Color(0xFF000000),
                                        fontSize = 16.sp,
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 70.dp),
                                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                        text = "возможность отслеживать количество переходов, их источники и другую аналитическую информацию",
                                        color = Color(0xFFBBBBBB),
                                        fontSize = 16.sp,
                                    )
                                }
                            }
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.next2_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 40.dp)
                                    .size(60.dp)
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(top=30.dp, start = 0.dp, end=0.dp),
                                fontFamily= mFontFamily,
                                text = "наши клиенты",
                                color = Color(0xFF000000),
                                fontSize = 30.sp,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }
                        // ========================================================================

                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier.padding(start=24.dp, end=24.dp, bottom = 24.dp)
                                ){
                                    Column {
                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= mFontFamily,
                                            text = "блогеры",
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                        )

                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                            text = "динамичные короткие ссылки позволяют взаимодействовать с аудиторией и получать подробную статистику переходов",
                                            color = Color(0xFFBBBBBB),
                                            fontSize = 16.sp,
                                        )

                                        OutlinedButton(
                                            modifier = Modifier
                                                .padding(top = 20.dp)
                                                .height(36.dp),
                                            onClick = { /*TODO*/ },
                                            border = BorderStroke(1.5.dp, Color.Black),
                                            shape = RoundedCornerShape(16.dp)
                                        ) {
                                            Text(
                                                modifier = Modifier,
                                                text = "статистика",
                                                color = Color.Black,
                                                fontSize = 12.sp,
                                                fontFamily= FontFamily(Font(R.font.montesserat_regular))
                                            )
                                        }

                                        OutlinedButton(
                                            modifier = Modifier
                                                .padding(top = 10.dp)
                                                .height(36.dp),
                                            onClick = { /*TODO*/ },
                                            border = BorderStroke(1.5.dp, Color.Black),
                                            shape = RoundedCornerShape(16.dp)
                                        ) {
                                            Text(
                                                modifier = Modifier,
                                                text = "динамические изменения",
                                                color = Color.Black,
                                                fontSize = 12.sp,
                                                fontFamily= FontFamily(Font(R.font.montesserat_regular))
                                            )
                                        }
                                    }
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier.padding(start=24.dp, end=24.dp, bottom = 24.dp)
                                ){
                                    Column {
                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= mFontFamily,
                                            text = "маркетологи",
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                        )

                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                            text = "удобные и эффективные короткие ссылки предоставляют возможность точного мониторинга статистики переходов по ссылке",
                                            color = Color(0xFFBBBBBB),
                                            fontSize = 16.sp,
                                        )

                                        OutlinedButton(
                                            modifier = Modifier
                                                .padding(top = 20.dp)
                                                .height(36.dp),
                                            onClick = { /*TODO*/ },
                                            border = BorderStroke(1.5.dp, Color.Black),
                                            shape = RoundedCornerShape(16.dp)
                                        ) {
                                            Text(
                                                modifier = Modifier,
                                                text = "статистика",
                                                color = Color.Black,
                                                fontSize = 12.sp,
                                                fontFamily= FontFamily(Font(R.font.montesserat_regular))
                                            )
                                        }

                                        OutlinedButton(
                                            modifier = Modifier
                                                .padding(top = 10.dp)
                                                .height(36.dp),
                                            onClick = { /*TODO*/ },
                                            border = BorderStroke(1.5.dp, Color.Black),
                                            shape = RoundedCornerShape(16.dp)
                                        ) {
                                            Text(
                                                modifier = Modifier,
                                                text = "короткие ссылки",
                                                color = Color.Black,
                                                fontSize = 12.sp,
                                                fontFamily= FontFamily(Font(R.font.montesserat_regular))
                                            )
                                        }
                                    }
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 10.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier.padding(start=24.dp, end=24.dp, bottom = 24.dp, top=0.dp)
                                ){
                                    Column {
                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= mFontFamily,
                                            text = "разработчики",
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                        )

                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                            text = "короткие ссылки обеспечивают таргетирование и статистику переходов для эффективного управления трафиком",
                                            color = Color(0xFFBBBBBB),
                                            fontSize = 16.sp,
                                        )

                                        OutlinedButton(
                                            modifier = Modifier
                                                .padding(top = 20.dp)
                                                .height(36.dp),
                                            onClick = { /*TODO*/ },
                                            border = BorderStroke(1.5.dp, Color.Black),
                                            shape = RoundedCornerShape(16.dp)
                                        ) {
                                            Text(
                                                modifier = Modifier,
                                                text = "статистика",
                                                color = Color.Black,
                                                fontSize = 12.sp,
                                                fontFamily= FontFamily(Font(R.font.montesserat_regular))
                                            )
                                        }

                                        OutlinedButton(
                                            modifier = Modifier
                                                .padding(top = 10.dp)
                                                .height(36.dp),
                                            onClick = { /*TODO*/ },
                                            border = BorderStroke(1.5.dp, Color.Black),
                                            shape = RoundedCornerShape(16.dp)
                                        ) {
                                            Text(
                                                modifier = Modifier,
                                                text = "таргетированные ссылки",
                                                color = Color.Black,
                                                fontSize = 12.sp,
                                                fontFamily= FontFamily(Font(R.font.montesserat_regular))
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.next2_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(top = 40.dp)
                                    .size(60.dp)
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(top=30.dp, start = 0.dp, end=0.dp),
                                fontFamily= mFontFamily,
                                text = "тарифы",
                                color = Color(0xFF000000),
                                fontSize = 30.sp,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }



                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier.padding(start=24.dp, end=24.dp, bottom = 24.dp)
                                ){
                                    Column {
                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= mFontFamily,
                                            text = "базовый                                                          ",
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                            style = TextStyle(fontWeight = FontWeight.Bold)
                                        )

                                        Text(
                                            modifier = Modifier
                                                .padding(top=10.dp, start = 0.dp, end=0.dp),
                                            fontFamily= mFontFamily,
                                            text = "бесплатно",
                                            color = Color(0xFF000000),
                                            fontSize = 30.sp,
                                            style = TextStyle(fontWeight = FontWeight.Bold)
                                        )

                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                            text = "— до 10 коротких ссылок\n" +
                                                    "— динамические изменения\n" +
                                                    "— ограниченная статистика",
                                            color = Color(0xFFBBBBBB),
                                            fontSize = 16.sp,
                                        )


                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                        ) {
                                            TextButton(
                                                modifier = Modifier
                                                    .padding(top = 30.dp)
                                                    .background(
                                                        Color.Black,
                                                        shape = RoundedCornerShape(16.dp)
                                                    ),
                                                onClick = { /*TODO*/ },
                                            ) {
                                                Text(
                                                    modifier = Modifier.padding(start=80.dp, end=80.dp),
                                                    text = "подключить",
                                                    color = Color.White,
                                                    fontFamily= mFontFamily
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier.padding(start=24.dp, end=24.dp, bottom = 24.dp)
                                ){
                                    Column {
                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= mFontFamily,
                                            text = "премиум                                                          ",
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                            style = TextStyle(fontWeight = FontWeight.Bold)
                                        )

                                        Text(
                                            modifier = Modifier
                                                .padding(top=10.dp, start = 0.dp, end=0.dp),
                                            fontFamily= mFontFamily,
                                            text = "100 ₽ / мес",
                                            color = Color(0xFF000000),
                                            fontSize = 30.sp,
                                            style = TextStyle(fontWeight = FontWeight.Bold)
                                        )

                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                            text = "— неограниченное количество коротких ссылок\n" +
                                                    "— таргетированные ссылки\n" +
                                                    "— динамические изменения\n" +
                                                    "— подробная статистика",
                                            color = Color(0xFFBBBBBB),
                                            fontSize = 16.sp,
                                        )

                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                        ) {
                                            TextButton(
                                                modifier = Modifier
                                                    .padding(top = 30.dp)
                                                    .background(
                                                        Color.Black,
                                                        shape = RoundedCornerShape(16.dp)
                                                    ),
                                                onClick = { /*TODO*/ },
                                            ) {
                                                Text(
                                                    modifier = Modifier.padding(start=80.dp, end=80.dp),
                                                    text = "подключить",
                                                    color = Color.White,
                                                    fontFamily= mFontFamily
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .padding(start = 24.dp, end = 24.dp, top = 10.dp)
                                    .border(
                                        width = 1.5.dp,
                                        color = Color(0xFFF3F3F3),
                                        shape = RoundedCornerShape(8)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier.padding(start=24.dp, end=24.dp, bottom = 24.dp, top=0.dp)
                                ){
                                    Column {
                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= mFontFamily,
                                            text = "премиум (-20%)                                                   ",
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                            style = TextStyle(fontWeight = FontWeight.Bold)
                                        )

                                        Text(
                                            modifier = Modifier
                                                .padding(top=10.dp, start = 0.dp, end=0.dp),
                                            fontFamily= mFontFamily,
                                            text = "960 ₽ / год",
                                            color = Color(0xFF000000),
                                            fontSize = 30.sp,
                                            style = TextStyle(fontWeight = FontWeight.Bold)
                                        )

                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                            text = "— неограниченное количество коротких ссылок\n" +
                                                    "— таргетированные ссылки\n" +
                                                    "— динамические изменения\n" +
                                                    "— подробная статистика",
                                            color = Color(0xFFBBBBBB),
                                            fontSize = 16.sp
                                        )

                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                        ) {
                                            TextButton(
                                                modifier = Modifier
                                                    .padding(top = 30.dp)
                                                    .background(
                                                        Color.Black,
                                                        shape = RoundedCornerShape(16.dp)
                                                    ),
                                                onClick = { /*TODO*/ },
                                            ) {
                                                Text(
                                                    modifier = Modifier.padding(start=80.dp, end=80.dp),
                                                    text = "подключить",
                                                    color = Color.White,
                                                    fontFamily= mFontFamily
                                                )
                                            }
                                        }


                                    }
                                }
                            }
                        }


                        Text(
                            modifier = Modifier.padding(top=40.dp)
                                .clickable { /* действие при нажатии на ссылку */ },
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = "пользовательское соглашение",
                            color = Color(0xFFBBBBBB),
                            fontSize = 16.sp
                        )

                        Text(
                            modifier = Modifier
                                .clickable { /* действие при нажатии на ссылку */ },
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = "политика конфиденциальности",
                            color = Color(0xFFBBBBBB),
                            fontSize = 16.sp
                        )

                        Text(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .clickable { /* действие при нажатии на ссылку */ },
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = "support@beetlink.ru",
                            color = Color(0xFFBBBBBB),
                            fontSize = 16.sp
                        )

                        Text(
                            modifier = Modifier
                                .padding(bottom=40.dp)
                                .clickable { /* действие при нажатии на ссылку */ },
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = "offer@beetlink.ru",
                            color = Color(0xFFBBBBBB),
                            fontSize = 16.sp
                        )
                        
                        
                        
                    }
                }
            }
        }
    }
}
