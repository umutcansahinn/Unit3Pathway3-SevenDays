@file:OptIn(ExperimentalAnimationApi::class)

package com.umutcansahin.unit3pathway3sevendaysapp

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umutcansahin.unit3pathway3sevendaysapp.model.Day
import com.umutcansahin.unit3pathway3sevendaysapp.model.DaysRepository
import com.umutcansahin.unit3pathway3sevendaysapp.ui.theme.Cyan700
import com.umutcansahin.unit3pathway3sevendaysapp.ui.theme.Purple200
import com.umutcansahin.unit3pathway3sevendaysapp.ui.theme.Teal200

@Composable
fun DaysApp() {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
        ),
        exit = fadeOut()
    ) {
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .animateEnterExit(
                    enter = slideInVertically(
                        animationSpec = spring(
                            stiffness = StiffnessVeryLow,
                            dampingRatio = DampingRatioLowBouncy
                        )
                    )
                )
        ){
            items(DaysRepository.days) {
                DayListItem(day = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DayListItem(day: Day){

    var expanded by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (expanded) Purple200 else MaterialTheme.colors.surface
    )

    Card (
        modifier = Modifier
            .padding(16.dp),
        elevation = 4.dp,
        onClick = {
            expanded = !expanded
        }
    ){
        Column(
            modifier = Modifier
                .background(color)
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )

        ) {
            Text(
                text = stringResource(id = day.dayNumber),
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Text(
                text = stringResource(id = day.dayTitle),
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(bottom = 4.dp)
            )
            Image(
                painter = painterResource(id = day.dayImage),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop
            )
            if (expanded){
                Text(
                    text = stringResource(id = day.dayDescription),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
            }
        }
    }
}

@Preview("One Day")
@Composable
fun OneDayPreview() {

    val day = Day(R.string.day1,R.string.day1Title,R.drawable.day1,R.string.day1Description)
    DayListItem(day = day)
}

@Preview("Day List")
@Composable
fun DayListPreview() {
    DaysApp()
}
