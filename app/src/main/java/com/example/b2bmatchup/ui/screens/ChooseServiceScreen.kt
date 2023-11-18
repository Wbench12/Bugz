package com.example.b2bmatchup.ui.screens

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.b2bmatchup.B2BMatchUpApp
import com.example.b2bmatchup.B2BMatchUpScreen
import com.example.b2bmatchup.R
import com.example.b2bmatchup.model.AppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseServiceScreen(
    onIconClicked: () -> Unit,
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Scaffold (
        topBar = {
            AppBar(title = B2BMatchUpScreen.ChooseService.title,onButtonClicked)
        }
    ) {innerPadding ->
        Column (
            modifier = modifier.padding(innerPadding)
        ){
            ChooseServiceCard(
                serviceIcon = Icons.Default.Refresh,
                service = R.string.transportation,
                onIconClicked
            )
            ChooseServiceCard(
                serviceIcon = Icons.Default.Refresh,
                service = R.string.transportation,
                onIconClicked
            )
            ChooseServiceCard(
                serviceIcon = Icons.Default.Refresh,
                service = R.string.transportation,
                onIconClicked
            )

        }

    }
}

@Composable
fun ChooseServiceCard(
    serviceIcon: ImageVector,
    service: Int,
    onIconClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Spacer(modifier = modifier.height(30.dp))
    Card (
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(15.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(top = 10.dp)

        ){
            Box (
                modifier = modifier
                    .padding(start = 13.dp, end = 10.dp)
                    .size(60.dp, 60.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = serviceIcon,
                    contentDescription = null,
                    modifier = modifier
                        .size(30.dp, 30.dp)
                )
            }
            Text(
                text = stringResource(id = service),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = modifier.padding(15.dp)

            )
            Spacer(modifier = modifier.width(30.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward ,
                contentDescription = null ,
                modifier = modifier
                    .size(30.dp,30.dp)
                    .clickable(onClick = onIconClicked)
            )


        }
    }
}
