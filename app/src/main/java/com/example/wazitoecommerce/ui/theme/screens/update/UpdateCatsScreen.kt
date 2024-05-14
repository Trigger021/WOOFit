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
import com.example.wazitoecommerce.data.CatViewModel
import com.example.wazitoecommerce.models.Cat
import com.example.wazitoecommerce.navigation.PROFILE_URL
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateCatsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var catRepository = CatViewModel(navController, context)


        val emptyCatState = remember { mutableStateOf(Cat("","","","","","","","","","","")) }
        var emptyCatListState = remember { mutableStateListOf<Cat>() }

        var cats = catRepository.allCats(emptyCatState, emptyCatListState)


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
                items(cats){
                    CatItem(
                        catname = it.catname,
                        catgender = it.catgender,
                        catage = it.catage,
                        catlocation = it.catlocation,
                        catcolor = it.catcolor,
                        catweight = it.catweight,
                        catdescription = it.catdescription,
                        catowner = it.catowner,
                        catcontact = it.catcontact,
                        id = it.id,
                        navController = navController,
                        catRepository = catRepository,
                        catImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun CatItem(catname: String,
            catgender: String,
            catage: String,
            catlocation: String,
            catcolor: String,
            catweight: String,
            catdescription: String,
            catowner: String,
            catcontact: String,
            id: String,
            navController:NavHostController,
            catRepository:CatViewModel, catImage:String) {

    Column(modifier = Modifier.fillMaxWidth()) {Column(modifier = Modifier.fillMaxWidth()) {
        // Image Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(catImage),
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
                text = catname,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 35.sp,
                modifier = Modifier.weight(1f)
            )
            OutlinedButton(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = if (catgender == "Male") Color.Blue else Color.Red
                ),
                border = BorderStroke(1.dp, if (catgender == "Male") Color.Blue else Color.Red),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = catgender)
            }
        }

        // Location
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = Color.Red
            )
            Text(text = catlocation)
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
                    text = catdescription,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Age, Color, Weight
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                com.example.wazitoecommerce.ui.theme.screens.view.InfoCard(
                    title = "$catage yrs",
                    subtitle = "Age"
                )
                Spacer(modifier = Modifier.width(20.dp))
                com.example.wazitoecommerce.ui.theme.screens.view.InfoCard(
                    title = catcolor,
                    subtitle = "Color"
                )
                Spacer(modifier = Modifier.width(20.dp))
                com.example.wazitoecommerce.ui.theme.screens.view.InfoCard(
                    title = "$catweight Kg",
                    subtitle = "Weight"
                )
            }

        }
        // Owner and Contact
        Button(onClick = {
            val callIntent= Intent(Intent.ACTION_DIAL)
            callIntent.data="tel:$catcontact".toUri()
        },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
        ) {
            Text(text = "Contact : $catowner  ", color = Color.Black)
        }

        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { catRepository.deleteCat(id) },
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
        }}
    }
}

@Composable
@Preview(showBackground = true)
fun UpdateCatsScreenPreview(){
    WazitoECommerceTheme {
        UpdateCatsScreen(navController = rememberNavController())
    }
}