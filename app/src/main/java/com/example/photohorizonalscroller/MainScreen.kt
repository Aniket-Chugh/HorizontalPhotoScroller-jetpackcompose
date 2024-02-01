package com.example.photohorizonalscroller

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(){
    val photos = listOf(
        R.drawable.download,
        R.drawable.downloads,
        R.drawable.images
    )


    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()


    Box(modifier = Modifier.fillMaxSize() ){

        HorizontalPager( state = pagerState,

            pageCount =

            photos.size,

            key = {
                photos[it]

            } ,



        ) { index ->

            Image(painter = painterResource(id = photos[index]), contentDescription = null ,
contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()


                )





        }

        Box(modifier = Modifier
            .offset(y = -(16.dp))
            .fillMaxWidth(0.5f)
            .background(Color.Green)
            .padding(2.dp)
            .align(
                Alignment.BottomCenter
            )){

            IconButton(onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(
                        pagerState.currentPage  - 1
                    )
                }}) {                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null ,
                modifier = Modifier
                    .align(Alignment.CenterStart)

            )

            }


            IconButton(onClick = {  scope.launch {
    pagerState.animateScrollToPage(
        pagerState.currentPage + 1
    )
}
},
    modifier = Modifier
        .align(Alignment.CenterEnd)
    ) {
    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null
    )
}

    }


}}