package com.example.b2bmatchup.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b2bmatchup.B2BMatchUpApp
import com.example.b2bmatchup.B2BMatchUpScreen

import com.example.b2bmatchup.R
import com.example.b2bmatchup.model.AppBar
import com.example.b2bmatchup.ui.theme.B2BMatchUpTheme
import com.example.b2bmatchup.ui.theme.Shapes




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    onLogInNextButtonClicked: () -> Unit,
    onSignUpButtonClicked: () -> Unit,
    onButtonClicked: () -> Unit,
    modifier: Modifier =Modifier
) {
    var companyName by rememberSaveable {
        mutableStateOf("")
    }

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var companyDescription by rememberSaveable {
        mutableStateOf("")
    }

    var serviceType by rememberSaveable {
        mutableStateOf("")
    }

    var isButton1Enabled by remember { mutableStateOf(false) }
    var isButton2Enabled by remember { mutableStateOf(false) }
    var isButton3Enabled by remember { mutableStateOf(false) }
    var isButton4Enabled by remember { mutableStateOf(false) }
    var isButton5Enabled by remember { mutableStateOf(false) }


    Scaffold(topBar = { AppBar(title = B2BMatchUpScreen.SignUp.title,onButtonClicked)}) { InnerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(InnerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = modifier.height(30.dp))
            TextField(
                value = companyName,
                onValueChange = {
                    companyName = it
                    isButton1Enabled = companyName.isNotEmpty()
                },
                label = { Text(text = stringResource(id = R.string.company_name)) },
                placeholder = { Text(text = stringResource(id = R.string.company_name_label)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                shape = Shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(63.dp)
            )
            Spacer(modifier = modifier.height(8.dp))

            TextField(
                value = email,
                onValueChange = {
                    email = it
                    isButton2Enabled = email.isNotEmpty()
                },
                label = { Text(text = stringResource(id = R.string.email)) },
                placeholder = { Text(text = stringResource(id = R.string.email_label)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                shape = Shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(63.dp)
            )
            Spacer(modifier = modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = {
                    password = it
                    isButton3Enabled = password.isNotEmpty()
                },
                label = { Text(text = stringResource(id = R.string.password)) },
                placeholder = { Text(text = stringResource(id = R.string.password_label)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                shape = Shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(63.dp)
            )
            Spacer(modifier = modifier.height(8.dp))

            TextField(
                value = companyDescription,
                onValueChange = {
                    companyDescription = it
                    isButton4Enabled = companyDescription.isNotEmpty()
                },
                label = { Text(text = stringResource(id = R.string.company_description)) },
                placeholder = { Text(text = stringResource(id = R.string.company_description_label)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                shape = Shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(63.dp)
            )

            Spacer(modifier = modifier.height(8.dp))

            TextField(
                value = serviceType,
                onValueChange = {
                    serviceType = it
                    isButton5Enabled = serviceType.isNotEmpty()
                },
                label = { Text(text = stringResource(id = R.string.service_type)) },
                placeholder = { Text(text = stringResource(id = R.string.service_type_label)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                shape = Shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(63.dp)
            )
            Spacer(modifier = modifier.height(85.dp))
            Button(
                onClick = onSignUpButtonClicked,
                enabled = isButton1Enabled && isButton2Enabled && isButton3Enabled && isButton4Enabled && isButton5Enabled,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(65.dp)
                    .padding(start = 15.dp, end = 15.dp)


            ) {
                Text(text = stringResource(id = R.string.signup), fontSize = 30.sp)
            }

            TextButton(onClick = onLogInNextButtonClicked) {
                Text(text = stringResource(id = R.string.already_have_an_account))
            }
        }
    }
}













