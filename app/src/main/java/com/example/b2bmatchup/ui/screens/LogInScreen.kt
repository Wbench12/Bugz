package com.example.b2bmatchup.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b2bmatchup.B2BMatchUpScreen
import com.example.b2bmatchup.R
import com.example.b2bmatchup.model.AppBar
import com.example.b2bmatchup.model.PasswordSection
import com.example.b2bmatchup.model.RequiredSection
import com.example.b2bmatchup.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInScreen(
    onLogInClicked: () -> Unit,
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val primaryColor = MaterialTheme.colorScheme.primary
    var value by rememberSaveable {
        mutableStateOf("")
    }
    var isButton1Enabled by remember { mutableStateOf(false) }
    var isButton2Enabled by remember { mutableStateOf(false) }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    Scaffold (
        topBar = {
            AppBar(title = B2BMatchUpScreen.LogIn.title,onButtonClicked)
        }
    ){ innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(innerPadding)
        ) {
            Spacer(modifier = modifier.height(170.dp))
            Text(
                text = stringResource(id = R.string.enter_information),
                fontSize = 32.sp,
                color = primaryColor
            )
            Spacer(modifier = modifier.height(50.dp))
            TextField(
                value = value,
                onValueChange = {
                    value = it
                    isButton1Enabled = value.isNotEmpty()
                                },
                label = { Text(text = stringResource(id = R.string.email)) },
                placeholder = { Text(text = stringResource(id = R.string.email_label)) },
                leadingIcon = { Icon(imageVector = Icons.Default.Email , contentDescription = null) },
                shape = Shapes.small,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(63.dp)
            )
            Spacer(modifier = modifier.height(35.dp))
            TextField(
                value = password,
                onValueChange = {
                    password = it
                    isButton2Enabled = password.isNotEmpty()
                                },
                label = { Text(text = stringResource(id = R.string.password)) },
                placeholder = { Text(text = stringResource(id = R.string.password_label)) },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock , contentDescription = null) },
                visualTransformation =  PasswordVisualTransformation(),
                shape = Shapes.small,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(63.dp)
            )
            Spacer(modifier = modifier.height(180.dp))
            Button(
                onClick = onLogInClicked,
                enabled = isButton1Enabled && isButton2Enabled,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(65.dp)
                    .padding(start = 15.dp, end = 15.dp)


            ) {
                Text(text = stringResource(id = R.string.login), fontSize = 30.sp)
            }
        }
    }

}
