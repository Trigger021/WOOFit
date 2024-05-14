package com.example.wazitoecommerce.ui.theme.screens.update


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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.wazitoecommerce.data.BirdViewModel
import com.example.wazitoecommerce.models.Bird
import com.example.wazitoecommerce.navigation.PROFILE_URL
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateBirdsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var birdRepository = BirdViewModel(navController, context)


        val emptyBirdState = remember { mutableStateOf(Bird("","","","","","","","","","","")) }
        var emptyBirdsListState = remember { mutableStateListOf<Bird>() }

        var birds = birdRepository.allBirds(emptyBirdState, emptyBirdsListState)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Orange),
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
                        navController.navigate(PROFILE_URL)
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
                items(birds){
                    BirdItem(
                        birdname = it.birdname,
                        birdgender = it.birdgender,
                        birdage = it.birdage,
                        birdlocation = it.birdlocation,
                        birdcolor = it.birdcolor,
                        birdweight = it.birdweight,
                        birddescription = it.birddescription,
                        birdowner = it.birdowner,
                        birdcontact = it.birdcontact,
                        id = it.id,
                        navController = navController,
                        birdRepository = birdRepository,
                        birdImage = it.imageUrl
                    )
                }
            }
        }
    }
}

@Composable
fun BirdItem(
    birdname: String,
    birdgender: String,
    birdage: String,
    birdlocation: String,
    birdcolor: String,
    birdweight: String,
    birddescription: String,
    birdowner: String,
    birdcontact: String,
    id: String,
    navController: NavHostController,
    birdRepository: BirdViewModel,
    birdImage: String
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Image Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(birdImage),
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
                text = birdname,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 35.sp,
                modifier = Modifier.weight(1f)
            )
            OutlinedButton(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = if (birdgender == "Male") Color.Blue else Color.Red
                ),
                border = BorderStroke(1.dp, if (birdgender == "Male") Color.Blue else Color.Red),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = birdgender)
            }
        }

        // Location
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = Color.Red
            )
            Text(text = birdlocation)
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
                    text = birddescription,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Age, Color, Weight
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                InfoCard(title = "$birdage yrs", subtitle = "Age")
                Spacer(modifier = Modifier.width(20.dp))
                InfoCard(title = birdcolor, subtitle = "Color")
                Spacer(modifier = Modifier.width(20.dp))
                InfoCard(title = "$birdweight Kg", subtitle = "Weight")
            }

        }
        // Owner and Contact
        Button(onClick = {
            val callIntent=Intent(Intent.ACTION_DIAL)
            callIntent.data="tel:$birdcontact".toUri()

        },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
        ) {
            Text(text = "Contact : $birdowner", color = Color.Black)
        }

        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { birdRepository.deleteBird(id) },
                modifier = Modifier.padding(vertical = 8.dp)
                ,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
                border = BorderStroke(1.dp, Color.Red))
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
        }
    }
}

@Composable
fun InfoCard(title: String, subtitle: String) {
    Card(
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp
            )
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun UpdateBirdsScreenPreview(){
    WazitoECommerceTheme {
        UpdateBirdsScreen(navController = rememberNavController())
    }
}