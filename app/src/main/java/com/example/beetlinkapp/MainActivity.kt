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
                                text = stringResource(R.string.beetlink),
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
                                    text = stringResource(R.string.enter),
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
                                    text = stringResource(R.string.register),
                                    color = Color.White,
                                    fontFamily= mFontFamily
                                )
                            }
                        }

                        Text(
                            modifier = Modifier.padding(top = 120.dp),
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = stringResource(R.string.t1),
                            color = Color(0xFF000000),
                            fontSize = 16.sp,
                        )

                        Row {
                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                fontFamily= mFontFamily,
                                text = stringResource(R.string.l1),
                                color = Color(0xFF000000),
                                fontSize = 36.sp,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )

                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                fontFamily= mFontFamily,
                                text = stringResource(R.string.l2),
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
                                text = stringResource(R.string.short_links),
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
                                text = stringResource(R.string.targ_links),
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
                                text = stringResource(R.string.full_stat),
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
                        blockTitle(text = stringResource(R.string.f_serv))

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
                                        text = stringResource(R.string.short_links),
                                        color = Color(0xFF000000),
                                        fontSize = 16.sp,
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 70.dp),
                                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                        text = stringResource(R.string.t2),
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
                                        text = stringResource(R.string.targ_links),
                                        color = Color(0xFF000000),
                                        fontSize = 16.sp,
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 70.dp),
                                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                        text = stringResource(R.string.t3),
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
                                        text = stringResource(R.string.dinam_changes),
                                        color = Color(0xFF000000),
                                        fontSize = 16.sp,
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 70.dp),
                                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                        text = stringResource(R.string.t4),
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
                                        text = stringResource(R.string.full_stat),
                                        color = Color(0xFF000000),
                                        fontSize = 16.sp,
                                    )

                                    Text(
                                        modifier = Modifier.padding(top = 70.dp),
                                        fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                        text = stringResource(R.string.t5),
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
                        blockTitle(text = stringResource(R.string.our_clients))

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
                                            text = stringResource(R.string.blogers),
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                        )

                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                            text = stringResource(R.string.t6),
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
                                                text = stringResource(R.string.statistics),
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
                                                text = stringResource(R.string.dinam_changes),
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
                                            text = stringResource(R.string.marketers),
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                        )

                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                            text = stringResource(R.string.t7),
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
                                                text = stringResource(R.string.statistics),
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
                                                text = stringResource(R.string.short_links),
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
                                            text = stringResource(R.string.devs),
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                        )

                                        Text(
                                            modifier = Modifier.padding(top = 16.dp),
                                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                                            text = stringResource(R.string.t8),
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
                                                text = stringResource(R.string.statistics),
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
                                                text = stringResource(R.string.targ_links),
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

                        blockTitle(text = stringResource(R.string.plans))


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
                                            text = stringResource(R.string.basic),
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                            style = TextStyle(fontWeight = FontWeight.Bold)
                                        )

                                        Text(
                                            modifier = Modifier
                                                .padding(top=10.dp, start = 0.dp, end=0.dp),
                                            fontFamily= mFontFamily,
                                            text = stringResource(R.string.free),
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


                                        connectBtn()
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
                                            text = stringResource(R.string.prem),
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                            style = TextStyle(fontWeight = FontWeight.Bold)
                                        )

                                        Text(
                                            modifier = Modifier
                                                .padding(top=10.dp, start = 0.dp, end=0.dp),
                                            fontFamily= mFontFamily,
                                            text = stringResource(R.string.pr1),
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

                                        connectBtn()
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
                                            text = stringResource(R.string.pr2),
                                            color = Color(0xFF000000),
                                            fontSize = 16.sp,
                                            style = TextStyle(fontWeight = FontWeight.Bold)
                                        )

                                        Text(
                                            modifier = Modifier
                                                .padding(top=10.dp, start = 0.dp, end=0.dp),
                                            fontFamily= mFontFamily,
                                            text = stringResource(R.string.pr3),
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

                                        connectBtn()
                                    }
                                }
                            }
                        }

                        Text(
                            modifier = Modifier
                                .padding(top = 40.dp)
                                .clickable { /* действие при нажатии на ссылку */ },
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = stringResource(R.string.ps),
                            color = Color(0xFFBBBBBB),
                            fontSize = 16.sp
                        )

                        Text(
                            modifier = Modifier
                                .clickable { /* действие при нажатии на ссылку */ },
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = stringResource(R.string.cs),
                            color = Color(0xFFBBBBBB),
                            fontSize = 16.sp
                        )

                        Text(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .clickable { /* действие при нажатии на ссылку */ },
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = stringResource(R.string.mail1),
                            color = Color(0xFFBBBBBB),
                            fontSize = 16.sp
                        )

                        Text(
                            modifier = Modifier
                                .padding(bottom = 40.dp)
                                .clickable { /* действие при нажатии на ссылку */ },
                            fontFamily= FontFamily(Font(R.font.montesserat_regular)),
                            text = stringResource(R.string.mail2),
                            color = Color(0xFFBBBBBB),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun connectBtn() {
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
                text = stringResource(R.string.connect),
                color = Color.White,
                fontFamily= mFontFamily
            )
        }
    }
}

@Composable
fun blockTitle(text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .padding(top=30.dp, start = 0.dp, end=0.dp),
            fontFamily= mFontFamily,
            text = text,
            color = Color(0xFF000000),
            fontSize = 30.sp,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}