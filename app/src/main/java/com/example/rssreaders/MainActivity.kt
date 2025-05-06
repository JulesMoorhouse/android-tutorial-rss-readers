package com.example.rssreaders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rssreaders.ui.theme.RSSReadersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        val people = listOf(
//            Person("DJ", "Malone", 25),
//            Person("DJ", "Smith", 30),
//            Person("DJ", "Smith", 10),
//            Person("DJ", "Malone", 21),
//            Person("DJ", "Malone", 20),
//        )

//         val peopleFiltered = people.filter { it.age >= 21 && it.lastName == "Smith"}

        val rssItems = listOf(
            RSSItem("Welcome to me blog!", "sdas dsfas das dasd", RSSType.TEXT),
            RSSItem("Welcome to me blog!", "sdas dsfas das dasd", RSSType.VIDEO),
            RSSItem("Welcome to me blog!", "sdas dsfas das dasd", RSSType.TEXT),
            RSSItem("Welcome to me blog!", "sdas dsfas das dasd", RSSType.TEXT),
            RSSItem("Welcome to me blog!", "sdas dsfas das dasd", RSSType.TEXT),
            RSSItem("Welcome to me blog!", "sdas dsfas das dasd", RSSType.IMAGE),
            RSSItem("Welcome to me blog!", "sdas dsfas das dasd", RSSType.TEXT),
        )

        setContent {
            RSSReadersTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                    LazyColumn {
                        items(rssItems) {
                            if (it.type == RSSType.TEXT) {
                                RSSItemText(it)
                            } else if (it.type == RSSType.VIDEO) {
                                RSSItemVideo(it)
                            } else if (it.type == RSSType.IMAGE) {
                                RSSItemImage(it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RSSReadersTheme {
        Greeting("Android")
    }
}

@Composable
fun CardView(person: Person) {
    Card(
        modifier = Modifier.fillMaxSize()
            .padding(12.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = "Photo of person",
                modifier = Modifier.width(100.dp)
                    .height(100.dp)
            )
            Column {
                Text(
                    text = person.firstName,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = person.lastName,
                    modifier = Modifier.padding(0.dp)
                )
                Text(
                    text = "Age: " + person.age,
                    modifier = Modifier.padding(0.dp)
                )
            }
        }
    }
}

@Composable
fun RSSItemText(rssItem: RSSItem) {
    Card(
        modifier = Modifier.fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = rssItem.title,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun RSSItemVideo(rssItem: RSSItem) {
    Card(
        modifier = Modifier.fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Click below to play video",
            modifier = Modifier.padding(12.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "Photo of person",
            modifier = Modifier.width(300.dp)
                .height(300.dp)
        )
    }
}

@Composable
fun RSSItemImage(rssItem: RSSItem) {
    Card(
        modifier = Modifier.fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Photo below:",
            modifier = Modifier.padding(12.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "Photo of person",
            modifier = Modifier.width(300.dp)
                .height(300.dp)
        )
    }
}