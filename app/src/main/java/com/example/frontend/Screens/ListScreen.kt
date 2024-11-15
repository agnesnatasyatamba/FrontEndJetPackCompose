package com.example.frontend.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.frontend.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavHostController) {
    Column {
        CenterAlignedTopAppBar(title = {
            Text("LIST SCREEN", fontWeight = FontWeight.Bold)
        })

        val lazyrowResources = listOf(
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
            R.drawable.img_10,
            R.drawable.img_11,
            R.drawable.img_12,
            R.drawable.img_13,
        )

        val lazycolumnResources = listOf(
            R.drawable.img_14,
            R.drawable.img_15,
            R.drawable.img_16,
            R.drawable.img_17,
            R.drawable.img_18,
            R.drawable.img_19,
            R.drawable.img_20,
            R.drawable.img_21,
            R.drawable.img_22,
            R.drawable.img_23,
        )

        Text(
            text = "Lazy Row",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

        // Lazy Row
        LazyRow {
            items(10) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = lazyrowResources[index]),
                        contentDescription = "Image $index",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                    Button(onClick = { navController.navigate("detail/$index/${lazyrowResources[index]}") }) {
                        Text("Post $index")
                    }
                }
            }
        }

        Text(
            text = "Lazy Column",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

        // Lazy Column
        LazyColumn {
            items(lazycolumnResources.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Load the square image from the drawable resources
                    Image(
                        painter = painterResource(id = lazycolumnResources[index]),
                        contentDescription = "Image $index",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(250.dp) // Square size
                            .clip(RoundedCornerShape(0.dp)) // Square shape
                            .padding(end = 6.dp)
                    )
                    Button(onClick = { navController.navigate("detail/$index/${lazycolumnResources[index]}") }) {
                        Text("Photo $index")
                    }
                }
            }
        }
    }
}