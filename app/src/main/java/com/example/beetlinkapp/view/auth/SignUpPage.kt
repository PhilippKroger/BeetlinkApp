package com.example.beetlinkapp.view.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.beetlinkapp.R


@Composable
fun SignUpPage(navController: NavController) {
    AuthEntity(
        title = stringResource(R.string.register),
        text = stringResource(R.string.already_have_account),
        link = stringResource(R.string.voiti)
    )
}
