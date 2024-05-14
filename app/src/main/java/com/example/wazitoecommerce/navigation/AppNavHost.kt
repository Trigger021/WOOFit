package com.example.wazitoecommerce.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.ui.theme.screens.add.AddBirdsScreen
import com.example.wazitoecommerce.ui.theme.screens.add.AddCatsScreen
import com.example.wazitoecommerce.ui.theme.screens.add.AddDogsScreen
import com.example.wazitoecommerce.ui.theme.screens.add.AddFishsScreen
import com.example.wazitoecommerce.ui.theme.screens.add.AddPetsScreen
import com.example.wazitoecommerce.ui.theme.screens.home.HomeScreen
import com.example.wazitoecommerce.ui.theme.screens.login.LoginScreen
import com.example.wazitoecommerce.ui.theme.screens.output.AddScreen
import com.example.wazitoecommerce.ui.theme.screens.output.UpdateScreen
import com.example.wazitoecommerce.ui.theme.screens.products.AddProductsScreen
import com.example.wazitoecommerce.ui.theme.screens.products.ViewProductsScreen
import com.example.wazitoecommerce.ui.theme.screens.profile.ProfileScreen
import com.example.wazitoecommerce.ui.theme.screens.signup.SignupScreen
import com.example.wazitoecommerce.ui.theme.screens.splash.SplashScreen
import com.example.wazitoecommerce.ui.theme.screens.update.UpdateBirdsScreen
import com.example.wazitoecommerce.ui.theme.screens.update.UpdateCatsScreen
import com.example.wazitoecommerce.ui.theme.screens.update.UpdateDogsScreen
import com.example.wazitoecommerce.ui.theme.screens.update.UpdateFishsScreen
import com.example.wazitoecommerce.ui.theme.screens.update.UpdatePetsScreen
import com.example.wazitoecommerce.ui.theme.screens.view.ViewBirdsScreen
import com.example.wazitoecommerce.ui.theme.screens.view.ViewCatsScreen
import com.example.wazitoecommerce.ui.theme.screens.view.ViewDogsScreen
import com.example.wazitoecommerce.ui.theme.screens.view.ViewFishsScreen
import com.example.wazitoecommerce.ui.theme.screens.view.ViewPetsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(SPLASH_URL){
            SplashScreen(navController = navController)
        }
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navController = navController)
        }
        composable(ADD_PRODUCTS_URL){
            AddProductsScreen(navController = navController)
        }
        composable(ADD_BIRDS_URL){
            AddBirdsScreen(navController = navController)
        }
        composable(ADD_CATS_URL){
            AddCatsScreen(navController = navController)
        }
        composable(ADD_DOGS_URL){
            AddDogsScreen(navController = navController)
        }
        composable(ADD_FISHS_URL){
            AddFishsScreen(navController = navController)
        }
        composable(ADD_PETS_URL){
            AddPetsScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL){
            ViewProductsScreen(navController = navController)
        }
        composable(VIEW_PETS_URL){
            ViewPetsScreen(navController = navController)
        }
        composable(UPDATE_PETS_URL){
            UpdatePetsScreen(navController = navController)
        }
        composable(VIEW_BIRDS_URL){
            ViewBirdsScreen(navController = navController)
        }
        composable(UPDATE_BIRDS_URL){
            UpdateBirdsScreen(navController = navController)
        }
        composable(VIEW_CATS_URL){
            ViewCatsScreen(navController = navController)
        }
        composable(UPDATE_CATS_URL){
            UpdateCatsScreen(navController = navController)
        }
        composable(VIEW_DOGS_URL){
            ViewDogsScreen(navController = navController)
        }
        composable(UPDATE_DOGS_URL){
            UpdateDogsScreen(navController = navController)
        }
        composable(VIEW_FISHS_URL){
            ViewFishsScreen(navController = navController)
        }
        composable(UPDATE_FISHS_URL){
            UpdateFishsScreen(navController = navController)
        }
        composable(PROFILE_URL){
            ProfileScreen(navController = navController)
        }
        composable(ADD_URL){
            AddScreen(navController = navController)
        }
        composable(UPDATE_URL){
            UpdateScreen(navController = navController)
        }
    }
}