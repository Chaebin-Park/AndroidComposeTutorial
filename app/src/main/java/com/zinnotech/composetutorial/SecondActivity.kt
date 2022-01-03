package com.zinnotech.composetutorial

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zinnotech.composetutorial.ui.theme.LayoutsCodelabTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsCodelabTheme {
                Column() {
                    TopTitle()
                    PhotographerCard()
                }
            }
        }
    }
}

@Composable
fun TopTitle(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    TopAppBar(
        title = {
            Text(text = "Photographer", maxLines = 2)
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_apple),
                contentDescription = "Icon"
            )
        },
        actions = {
            IconButton(onClick = {
                val intent = Intent(context, ThirdActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_blue_berry), contentDescription = "NextActivity")
            }
        },
        backgroundColor = MaterialTheme.colors.secondary
    )
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Column() {
        Row(
            modifier = modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .clickable(onClick = { /* Ignoring onClick */ })
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {

            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Alfred Sisley",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.secondaryVariant,
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = "3 minutes ago",
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkMode",
)
@Composable
fun PhotographerCardPreview() {
    LayoutsCodelabTheme {
        Column() {
            TopTitle()
            PhotographerCard()
        }
    }
}