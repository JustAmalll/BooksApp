package dev.amal.booksapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.flowlayout.FlowRow
import dev.amal.booksapp.ui.theme.primary
import dev.amal.booksapp.ui.theme.text
import dev.amal.booksapp.ui.theme.typography

@ExperimentalCoilApi
@Composable
fun BookItemList(
    title: String,
    author: String,
    thumbnailUrl: String,
    categories: List<String>,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clickable(onClick = onItemClick)
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(20.dp))
            .padding(start = 25.dp, end = 25.dp, top = 12.dp, bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.onSurface),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(data = thumbnailUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 98.dp, height = 145.dp)
                    .padding(all = 16.dp),
                contentScale = ContentScale.Inside
            )

            Spacer(modifier = Modifier.width(5.dp))

            Column {
                Text(
                    text = author.removePrefix("[").removeSuffix("]"),
                    style = typography.caption,
                    color = text.copy(0.7F)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = title, style = typography.subtitle1, color = text)
                Spacer(modifier = Modifier.height(12.dp))
                FlowRow {
                    categories.forEach {
                        ChipView(category = listOf(it))
                    }
                }
            }
        }
    }
}

@Composable
fun ChipView(category: List<String>) {
    LazyRow {
        items(category.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(primary.copy(.10F))
                    .padding(vertical = 5.dp, horizontal = 12.dp)
            ) {
                Text(text = category[it], style = typography.caption, color = primary)
            }
        }
    }
}


//    Box(
//        modifier = Modifier
//            .clip(RoundedCornerShape(12.dp))
//            .background(primary.copy(.10F))
//            .padding(vertical = 5.dp, horizontal = 12.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = category, style = typography.caption, color = primary)
//    }

