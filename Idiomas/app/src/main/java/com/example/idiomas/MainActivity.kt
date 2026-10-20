package com.example.idiomas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idiomas.ui.theme.IdiomasTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdiomasTheme {
                ViewContainer()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Español", showBackground = true, locale = "es-rMX")
@Preview(showBackground = true, device = "spec:width=411dp,height=891dp,orientation=landscape")
@Composable
fun ViewContainer() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val snackbarMsg = stringResource(R.string.snackbar_msg)
    val snackbarAction = stringResource(R.string.snackbar_action)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.home_screen)) },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_btn_desc),
                            tint = Color.White
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.bottom_app_bar),
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = snackbarMsg,
                        actionLabel = snackbarAction,
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = stringResource(R.string.home_fab_text)
                )
            }
        }
    ) { innerPadding ->
        ContentView(Modifier.padding(innerPadding))
    }
}

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableStateOf(0) }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.logoandroid),
                contentDescription = "Ilustración de Android",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
            Row(modifier = Modifier.padding(top = 2.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.round_cookie_24),
                    contentDescription = "Like",
                    modifier = Modifier
                        .clickable { counter++ }
                        .padding(start = 12.dp)
                )
                Text(
                    text = counter.toString(),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Text(
                text = stringResource(R.string.materia),
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.nombre),
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.apellido),
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                item {
                    Row(modifier = Modifier.padding(bottom = 24.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.img1),
                            contentDescription = "Imagen 1",
                            modifier = Modifier.size(200.dp).padding(5.dp),
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            painter = painterResource(id = R.drawable.img2),
                            contentDescription = "Imagen 2",
                            modifier = Modifier.size(200.dp).padding(5.dp),
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            painter = painterResource(id = R.drawable.img3),
                            contentDescription = "Imagen 3",
                            modifier = Modifier.size(200.dp).padding(5.dp),
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            painter = painterResource(id = R.drawable.img4),
                            contentDescription = "Imagen 4",
                            modifier = Modifier.size(200.dp).padding(5.dp),
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            painter = painterResource(id = R.drawable.img5),
                            contentDescription = "Imagen 5",
                            modifier = Modifier.size(200.dp).padding(5.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}