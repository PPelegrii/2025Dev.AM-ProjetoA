package com.example.pinlikest

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pinlikest.ui.theme.PinlikestTheme
import com.example.pinlikest.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PinlikestTheme {
                //TelaLogo()
                HomeScreen()
                //PinDetails()
                }
            }
        }
    }
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun TelaLogo() {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        content = { paddingValues ->
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "",
                        modifier = Modifier.size(120.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Pinlikest",
                        style = Typography.displayLarge,
                        fontFamily = FontFamily.Serif
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Button(
                        modifier = Modifier.padding(10.dp),
                        onClick = { Log.d("botaoEntrar", "usuario-entrou") }
                    ) {
                        Text("Explorar suas próximas ideias")
                    }
                }
            }

        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Para Você") }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,

                ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    IconButton(onClick = {
                        Log.d("botaoHome", "usuario-clicouHome_route")
                    }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    IconButton(onClick = {
                        Log.d("botaoSearch", "usuario-clicouSearch_route")
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    IconButton(onClick = {
                        Log.d("botaoCreate/Upload", "usuario-clicouCreate/Upload_route")
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    IconButton(onClick = {
                        Log.d("botaoMessages", "usuario-clicouMessages_route")
                    }) {
                        Icon(
                            imageVector = Icons.Default.MailOutline,
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    IconButton(onClick = {
                        Log.d("botaoUserProfile", "usuario-clicouUserProfile_route")
                    }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }
        },
        content = { paddingValues ->
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    Modifier
                        .padding(8.dp)
                        .weight(1f)
                ) {
                    PinHomeTemplate(image = R.drawable.temp1, descricao  = "eu")
                    PinHomeTemplate(image = R.drawable.temp4, descricao  = "não")
                    PinHomeTemplate(image = R.drawable.temp3, descricao  = "acredito")
                    PinHomeTemplate(image = R.drawable.temp4, descricao  = "nisso")
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                ) {
                    PinHomeTemplate(image = R.drawable.temp5, descricao  = "q")
                    PinHomeTemplate(image = R.drawable.temp2, descricao  = "isso")
                    PinHomeTemplate(image = R.drawable.temp1, descricao  = "aqui")
                    PinHomeTemplate(image = R.drawable.temp4, descricao  = "funcionou")
                }
            }
        }
    )
}
@Composable
fun PinHomeTemplate(image: Int, descricao: String) {
    Image(
        painter = painterResource(image),
        contentDescription = "ImagePin",
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    )
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth(),
        ) {
            Text(descricao)
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun PinDetails() { // tudo isso vai passar como argumento dps
    val image = R.drawable.temp1
    val tituloPin = "alguem me tira desse sofrimento"
    val criadorPin = "alguem"
    val topComentarioPin = "outro alguem"

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        content = { paddingValues ->
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    modifier = Modifier
                        .size(width = 60.dp, height = 80.dp)
                        .padding(top = 40.dp),
                    onClick = {
                        Log.d("botaoBackToHome", "usuario-clicouVoltarParaHome")
                    }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        alignment = Alignment.Center,
                        painter = painterResource(image),
                        contentDescription = "ImagePin",
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(25.dp)
                ) {
                    Text(
                        text = tituloPin,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = 12.dp)

                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.End
                        ) {

                            IconButton(onClick = {
                                Log.d("botaoHome", "usuario-clicouCurtirPin")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            IconButton(onClick = {
                                Log.d("botaoSearch", "usuario-clicouComentariosPin")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.MailOutline,
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            IconButton(onClick = {
                                Log.d("botaoShare", "usuario-clicouCompartilharPin")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Share,
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            IconButton(onClick = {
                                Log.d("botao3Dots", "usuario-clicou3Pontinhos")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = criadorPin,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = 12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = topComentarioPin,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = 36.dp)
                    )
                }
            }
        }
    )
}