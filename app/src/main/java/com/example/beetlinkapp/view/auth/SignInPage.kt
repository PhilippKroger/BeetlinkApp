package com.example.beetlinkapp.view.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.beetlinkapp.R


@Composable
fun SignInPage(navController: NavController) {
    AuthEntity(
        title = stringResource(R.string.enter),
        text = stringResource(R.string.no_account),
        link = stringResource(R.string.register)
    )
}
