package com.example.testingapi.api.compose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.example.testingapi.api.compose.model.Pie
import com.google.accompanist.coil.rememberCoilPainter
import okio.utf8Size

@Composable
fun PieList(pies: List<Pie>){
    LazyColumn{
        items(pies.size){ index ->
            Spacer(modifier = Modifier.height(8.dp))
            Tweet(pies[index])
            Spacer(modifier = Modifier.height(2.dp))
            Divider(
                color = Color.LightGray,
                thickness = 0.4.dp
            )
        }
    }
}
@ExperimentalCoilApi
@Composable
fun DogCard(pie: Pie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 10.dp
    ) {
        Image(
            painter = rememberCoilPainter(pie.imageUrl),
            contentDescription = null
        )
    }
}

@Composable
fun Tweet(pie: Pie)
{
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Column() {

            Image(
                painter = rememberCoilPainter(
                    request = pie.user.profilePic),
                contentDescription = "Profile Pic",
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row{
                Text(
                    text = pie.user.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )

                Text(
                    text = pie.user.username,
                    style = TextStyle(
                        color = Color.Gray,
                    )
                )

                Text(
                    text = pie.date,
                    style = TextStyle(
                        color = Color.Gray,
                    )
                )
            }
            Spacer(modifier = Modifier.height(5.dp) )
            Text(
                text = pie.text
            )

            if(pie.hasImage){
                pie.imageUrl?.let{
                    Spacer(modifier = Modifier.height(5.dp))
                    Image(
                        painter = rememberCoilPainter(request = it),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                    )

                }
            }


            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Comment,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint= Color.LightGray
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Refresh,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint= Color.LightGray
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint= Color.LightGray
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint= Color.LightGray
                    )
                }
            }
        }
    }
}
