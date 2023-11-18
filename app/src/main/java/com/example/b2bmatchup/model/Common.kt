package com.example.b2bmatchup.model

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.b2bmatchup.R
import com.example.b2bmatchup.ui.theme.Shapes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RequiredSection(
    requiredField: Int,
    icon: ImageVector,
    label: Int,
    modifier: Modifier = Modifier
){
    var value by rememberSaveable {
        mutableStateOf("")
    }
    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text(text = stringResource(id = requiredField)) },
        placeholder = { Text(text = stringResource(id = label)) },
        leadingIcon = { Icon(imageVector = icon , contentDescription = null) },
        shape = Shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(63.dp)
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordSection(
    requiredField: Int,
    icon: ImageVector,
    label: Int,
    modifier: Modifier = Modifier
){
    var password by rememberSaveable {
        mutableStateOf("")
    }
    TextField(
        value = password,
        onValueChange = { password = it},
        label = { Text(text = stringResource(id = requiredField)) },
        placeholder = { Text(text = stringResource(id = label)) },
        leadingIcon = { Icon(imageVector = icon , contentDescription = null) },
        visualTransformation =  PasswordVisualTransformation(),
        shape = Shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(63.dp)
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar (
    @StringRes title: Int,
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val appBarColor = MaterialTheme.colorScheme.surfaceVariant
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 5.dp, end = 5.dp, bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onButtonClicked,
                    modifier = modifier
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
                Text(
                    text = stringResource(id = title),
                    textAlign = TextAlign.Start,
                    modifier = modifier.padding(top = 5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.group_removebg_preview),
                    contentDescription = null,
                    modifier = modifier
                        .size(45.dp, 45.dp)
                        .padding(end = 10.dp)
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = appBarColor)
    )

}