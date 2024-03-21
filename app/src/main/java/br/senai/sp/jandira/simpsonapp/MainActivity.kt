package br.senai.sp.jandira.simpsonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.simpsonapp.ui.theme.SimpsonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpsonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Image(
        painter = painterResource(id = R.drawable.simpsons),
        contentDescription = "Background do app",
        contentScale = ContentScale.Crop
    )
    Surface(
        color = Color(0xBB5096AC)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Buscar personagem...",
                        color = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    unfocusedContainerColor = Color(0xFF287E99)
                ),
                shape = RoundedCornerShape(16.dp),
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Botão buscar",
                            tint = Color(0xFFFFFFFF),
                            modifier = Modifier
                                .size(32.dp)
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Personagens",
                fontWeight = FontWeight.Bold,
                color = Color(0xffffffff),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn {
                items(20){
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(bottom = 8.dp),
                        colors = CardDefaults
                            .cardColors(
                                containerColor = Color(0xaa287E99)
                            ),
                        border = BorderStroke(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFFFF5722),
                                    Color(0xFFFFEB3B)
                                )
                            )
                        )
                    ){
                        Row (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Card (
                                modifier = Modifier
                                    .width(90.dp)
                                    .height(90.dp),
                                shape = CircleShape
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.bart),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Column (
                                modifier = Modifier
                                    .padding(horizontal = 12.dp)
                            ){
                                Text(
                                    text = "Bart Simpson",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFFEB3B),
                                    letterSpacing = 4.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "É o filho mais velho da família Simpson. O personagem é retratado como um menino rebelde e desobediente que tem más notas na escola.",
                                    fontSize = 16.sp,
                                    color = Color.Black,
                                    lineHeight = 16.sp
                                    )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    SimpsonAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting()
        }
    }
}