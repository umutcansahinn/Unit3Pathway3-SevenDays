package com.umutcansahin.unit3pathway3sevendaysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umutcansahin.unit3pathway3sevendaysapp.ui.theme.Unit3Pathway3SevenDaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit3Pathway3SevenDaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SevenDaysApp()
                }
            }
        }
    }
}

@Composable
fun SevenDaysApp() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar()
        }
    ) {
        DaysApp()
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary)
            .size(56.dp),
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = stringResource(id = R.string.top_bar),
            style = MaterialTheme.typography.h1
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Unit3Pathway3SevenDaysAppTheme {
        SevenDaysApp()
    }
}