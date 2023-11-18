package com.example.b2bmatchup.ui.screens

import android.accounts.AuthenticatorDescription
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b2bmatchup.R
import com.example.b2bmatchup.ui.theme.B2BMatchUpTheme
import org.w3c.dom.Text


@Composable
fun CompanyCard(
    companyName: Int,
    @DrawableRes companyImage: Int,
    companyDescription: Int,
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ){
            Text(
                text = stringResource(id = companyName),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.Black,
                modifier = modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .height(70.dp)
                    .fillMaxWidth()
                    .padding(15.dp)
            )
            Image(
                painter = painterResource(id = companyImage),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(190.dp)
            )
            Text(
                text = stringResource(id = companyDescription),
                textAlign = TextAlign.Justify,
                modifier = modifier.padding(15.dp)
            )
        }
    }
}


@Composable
fun ListOfCompaniesScreen(
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ){
        CompanyCard(
            companyName = R.string.yalidine,
            companyImage = R.drawable.yalidine,
            companyDescription = R.string.yalidine_description
        )
        CompanyCard(
            companyName = R.string.fedex,
            companyImage = R.drawable.fedex,
            companyDescription = R.string.fedex_description
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListOfCompaniesScreenPreview(){
    B2BMatchUpTheme {
        CompanyCard(
            companyName = R.string.yalidine,
            companyImage = R.drawable.yalidine,
            companyDescription = R.string.yalidine_description
        )
    }
}