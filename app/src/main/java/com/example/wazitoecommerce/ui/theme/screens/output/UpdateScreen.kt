package com.example.wazitoecommerce.ui.theme.screens.output






import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.data.PetViewModel
import com.example.wazitoecommerce.models.Pet
import com.example.wazitoecommerce.navigation.PROFILE_URL
import com.example.wazitoecommerce.navigation.UPDATE_BIRDS_URL
import com.example.wazitoecommerce.navigation.UPDATE_CATS_URL
import com.example.wazitoecommerce.navigation.UPDATE_DOGS_URL
import com.example.wazitoecommerce.navigation.UPDATE_FISHS_URL
import com.example.wazitoecommerce.navigation.UPDATE_PETS_URL
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(navController:NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Orange),
        horizontalAlignment = Alignment.CenterHorizontally) {

        //TopAppBar
        TopAppBar(
            title = {
                Text(text = "Update A Pet", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
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

            Text(
                text = "WOOFit",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 50.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(10.dp))
            //Start of row
            Row {
                //start of card
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp),
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp).clickable { navController.navigate(UPDATE_DOGS_URL)},
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.orange_dog),
                                contentDescription = "new",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Dogs",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 30.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                color = Orange
                            )
                        }
                    }

                }
                //End of card
                Spacer(modifier = Modifier.width(10.dp))
                //start of card
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp),
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp).clickable { navController.navigate(UPDATE_CATS_URL) },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.catpic),
                                contentDescription = "new",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Cats",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 30.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                color = Orange
                            )
                        }
                    }

                }
                //End of card
            }
            //End of row
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                //start of card
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp),
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp).clickable { navController.navigate(UPDATE_BIRDS_URL) },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.birdpic),
                                contentDescription = "new",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Birds",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 30.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                color = Orange
                            )
                        }
                    }

                }
                //End of card
                Spacer(modifier = Modifier.width(10.dp))
                //start of card
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp),
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp).clickable { navController.navigate(UPDATE_FISHS_URL) },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.fishpic),
                                contentDescription = "new",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Fish",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 30.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                color = Orange
                            )
                        }

                    }

                }
                //End of card
            }
            //End of row
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                //start of card
                Card(
                    modifier = Modifier
                        .height(175.dp)
                        .width(400.dp),
                ) {
                    //Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(175.dp).clickable { navController.navigate(UPDATE_PETS_URL) },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.otherpets),
                            contentDescription = "new",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Other Pets",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 30.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Orange
                        )
                    }

                    // }

                }
                //End of card
                Spacer(modifier = Modifier.width(10.dp))
            }
            //End of row
        }

    }



@Composable
@Preview(showBackground = true)
fun UpdateScreenPreview(){
    WazitoECommerceTheme {
        UpdateScreen(navController = rememberNavController())
    }
}