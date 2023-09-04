package com.example.tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Forward10
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.Replay10
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Forward10
import androidx.compose.material.icons.outlined.Pause
import androidx.compose.material.icons.outlined.Replay10
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasks.ui.theme.TasksTheme

@Composable
fun MusicPlayerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
    ) {

        // Music Information
        Column(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.album),
                contentDescription = null,
                modifier = Modifier
                    .padding(2.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )

            Column(modifier = Modifier.padding(top = 16.dp)) {
                Text(
                    text = "Episode #",
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                )
                Text(
                    text = "Long content title gets cut off after two lines LOrem ipsum cut off",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 6.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Slider(
                value = 0.5f,
                onValueChange = {},
                modifier = Modifier.padding(top = 40.dp),
                colors = SliderDefaults.colors(
                    thumbColor = Color.White,
                    activeTrackColor = Color.White,
                    inactiveTrackColor = Color.White.copy(alpha = 0.5f)
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "0:24",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(0.6f)
                )
                Text(
                    text = "1:35",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(0.6f)
                )
            }
        }

        // Player controls
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
                .background(colorResource(id = R.color.deep_blue))
                .align(Alignment.CenterHorizontally),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "1x",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )

                IconButton(
                    onClick = { }, modifier = Modifier.size(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Replay10,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                IconButton(onClick = { }, modifier = Modifier.size(35.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.Pause,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                IconButton(
                    onClick = { }, modifier = Modifier.size(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Forward10,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                IconButton(onClick = { }, modifier = Modifier.size(25.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.Download,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPlayerScreen() {
    TasksTheme {
        MusicPlayerScreen()
    }
}