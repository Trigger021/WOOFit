package com.example.wazitoecommerce.ui.theme.screens.view


import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.wazitoecommerce.data.FishViewModel
import com.example.wazitoecommerce.models.Fish
import com.example.wazitoecommerce.navigation.HOME_URL
import com.example.wazitoecommerce.navigation.PROFILE_URL
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewFishsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var fishRepository = FishViewModel(navController, context)


        val emptyFishState = remember { mutableStateOf(Fish("","","","","","","","","","","")) }
        var emptyFishListState = remember { mutableStateListOf<Fish>() }

        var fishs = fishRepository.allFishs(emptyFishState, emptyFishListState)


        Column(
            modifier = Modifier
                .fillMaxSize().background(Orange),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //TopAppBar
            TopAppBar(
                title = {
                    /*Text(text = "All Birds",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        color = Orange)*/
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Transparent),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(HOME_URL)
                    })
                    {
                        Icon(imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
            )
            // End of TopAppBar


            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(fishs){
                    FishItem(
                        fishname = it.fishname,
                        fishgender = it.fishgender,
                        fishage = it.fishage,
                        fishlocation = it.fishlocation,
                        fishcolor = it.fishcolor,
                        fishweight = it.fishweight,
                        fishdescription = it.fishdescription,
                        fishowner = it.fishowner,
                        fishcontact = it.fishcontact,
                        id = it.id,
                        navController = navController,
                        fishRepository = fishRepository,
                        fishImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun FishItem(fishname: String,
            fishgender: String,
            fishage: String,
            fishlocation: String,
            fishcolor: String,
            fishweight: String,
            fishdescription: String,
            fishowner: String,
            fishcontact: String,
            id: String,
            navController:NavHostController,
            fishRepository:FishViewModel, fishImage:String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        // Image Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(fishImage),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Name and Gender
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = fishname,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 35.sp,
                modifier = Modifier.weight(1f)
            )
            OutlinedButton(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = if (fishgender == "Male") Color.Blue else Color.Red
                ),
                border = BorderStroke(1.dp, if (fishgender == "Male") Color.Blue else Color.Red),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = fishgender)
            }
        }

        // Location
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = Color.Red
            )
            Text(text = fishlocation)
        }

        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Column{
                // About Me
                Text(
                    text = "About Me",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = fishdescription,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Age, Color, Weight
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                InfoCard(title = "$fishage yrs", subtitle = "Age")
                Spacer(modifier = Modifier.width(20.dp))
                InfoCard(title = fishcolor, subtitle = "Color")
                Spacer(modifier = Modifier.width(20.dp))
                InfoCard(title = "$fishweight Kg", subtitle = "Weight")
            }

        }
        // Owner and Contact
        Button(onClick = {
            val callIntent= Intent(Intent.ACTION_DIAL)
            callIntent.data="tel:$fishcontact".toUri()

        },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
        ) {
            Text(text = "Contact : $fishowner", color = Color.Black)
        }
/*
        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { fishRepository.deleteFish(id) },
                modifier = Modifier.padding(vertical = 8.dp)
                ,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
                border = BorderStroke(1.dp, Color.Red)
            )
            {
                Text(text = "Delete", color = Color.Red,fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { /* Handle update action */ },
                modifier = Modifier.padding(vertical = 8.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green),
                border = BorderStroke(1.dp, Color.Green),
            ) {
                Text(text = "Update", color = Color.Green,fontWeight = FontWeight.Bold)
            }
        }*/
    }
}

@Composable
@Preview(showBackground = true)
fun ViewFishsScreenPreview(){
    WazitoECommerceTheme {
        ViewFishsScreen(navController = rememberNavController())
    }
}