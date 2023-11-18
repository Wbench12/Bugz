package com.example.b2bmatchup

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.b2bmatchup.ui.screens.ChooseServiceScreen
import com.example.b2bmatchup.ui.screens.FirstScreen
import com.example.b2bmatchup.ui.screens.GetStartedScreen
import com.example.b2bmatchup.ui.screens.ListOfCompaniesScreen
import com.example.b2bmatchup.ui.screens.LogInScreen
import com.example.b2bmatchup.ui.screens.ServiceDetailesScreen
import com.example.b2bmatchup.ui.screens.ServiceViewModel
import com.example.b2bmatchup.ui.screens.SignUpScreen


enum class B2BMatchUpScreen(@StringRes val title: Int){
    GetStarted(R.string.get_started),
    FirstScreen(R.string.first_screen),
    SignUp(R.string.signup),
    LogIn(R.string.login),
    UpdateCompanyScreen(R.string.company_profile),
    ChooseService(R.string.choose_service),
    ListOfCompanies(R.string.choose_a_company),
    ServiseDetailesScreen(R.string.company_profile)
}
@Composable
fun B2BMatchUpApp (){
    val viewModel: ServiceViewModel = viewModel()
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = B2BMatchUpScreen.valueOf(
        backStackEntry?.destination?.route ?: B2BMatchUpScreen.GetStarted.name
    )
    NavHost(
        navController = navController,
        startDestination = B2BMatchUpScreen.GetStarted.name
    ){
        composable(route = B2BMatchUpScreen.GetStarted.name){
            GetStartedScreen(onNextClicked = {
                navController.navigate(B2BMatchUpScreen.FirstScreen.name)
            })
        }
        composable(route = B2BMatchUpScreen.FirstScreen.name){
            FirstScreen(
                onSearchButtonClicked = {
                    navController.navigate(B2BMatchUpScreen.ChooseService.name)
                },
                onLogInNextButtonClicked = {
                    navController.navigate(B2BMatchUpScreen.LogIn.name)
                },
                onSignUpButtonClicked = {
                    navController.navigate(B2BMatchUpScreen.SignUp.name)
                })
        }
        composable(route = B2BMatchUpScreen.LogIn.name){
            LogInScreen(
                onLogInClicked = {
                    navController.navigate(B2BMatchUpScreen.UpdateCompanyScreen.name)
                },
                onButtonClicked = {
                    navController.navigateUp()
                }
            )
        }
        composable(route = B2BMatchUpScreen.SignUp.name){
            SignUpScreen(
                onLogInNextButtonClicked = { /*TODO*/ },
                onSignUpButtonClicked = { /*TODO*/ },
                onButtonClicked = {
                    navController.navigateUp()
                })
        }
        composable(route = B2BMatchUpScreen.ChooseService.name){
            ChooseServiceScreen(
                onIconClicked = {
                    navController.navigate(B2BMatchUpScreen.ListOfCompanies.name)
                },
                onButtonClicked = {
                    navController.navigateUp()
                }
            )
        }
        composable(route = B2BMatchUpScreen.ListOfCompanies.name){
            ListOfCompaniesScreen()
        }

    }
}


