package com.example.beetlinkapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable

import com.example.beetlinkapp.ui.theme.BeetlinkAppTheme

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.beetlinkapp.view.HomePage
import com.example.beetlinkapp.view.LauncherPage
import com.example.beetlinkapp.view.auth.SignUpPage


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EncryptedPreferenceHelper.init(this)

        val accessToken = EncryptedPreferenceHelper.getString("access_token", null)

        setContent {
            BeetlinkAppTheme {
                BeetlinkApp(accessToken)
            }
        }
    }

    @Composable
    fun BeetlinkApp(accessToken: String?) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "launcherPage") {

            if (accessToken != null && accessToken.isNotEmpty()) {
                composable("homePage") { HomePage(navController) }
            } else {
                //composable("SignInPage") { SignInPage(navController) }
                composable("launcherPage") { LauncherPage(navController) }
                //composable("SignUpPage") { SignUpPage(navController) }

            }
        }
    }
}


