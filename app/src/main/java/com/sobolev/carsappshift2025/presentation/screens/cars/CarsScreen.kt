package com.sobolev.carsappshift2025.presentation.screens.cars

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sobolev.carsappshift2025.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarsScreen(
    modifier: Modifier = Modifier,
    onCarClick: () -> Unit,
    onButtonClick: () -> Unit,
    onQueryChange: (String) -> Unit,
    onCalendarClick: () -> Unit
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.cars_title),
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.primary,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->

        LazyColumn(
            contentPadding = innerPadding
        ) {

            item {
               Spacer(modifier = modifier.height(14.dp))
            }

            item {
                SearchFilters(
                    onButtonClick = onButtonClick,
                    onQueryChange = onQueryChange,
                    onCalendarClick = onCalendarClick
                )
            }
            item {
                Spacer(modifier = modifier.height(14.dp))
            }

            item {
                CarCard(
                    onCarClick = onCarClick
                )
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}


@Composable
private fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(10.dp)
            ),
        placeholder = {
            Text(
                text = stringResource(R.string.search),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 14.sp
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp)

    )
}

@Composable
private fun LeasingBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    onCalendarClick: () -> Unit
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCalendarClick() }
            .background(MaterialTheme.colorScheme.background)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(10.dp)
            ),
        placeholder = {
            Text(
                text = stringResource(R.string.leasing_data),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 14.sp
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.calendar_svg),
                contentDescription = "Select Date",
                modifier = Modifier.clickable { onCalendarClick() },
                tint = MaterialTheme.colorScheme.secondary
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        readOnly = true
    )
}

@Composable
private fun SearchFilters(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    onQueryChange: (String) -> Unit,
    onCalendarClick: () -> Unit
) {
    Column {
        Text(
            text = stringResource(R.string.search),
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            modifier = modifier.padding(horizontal = 20.dp),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = modifier.height(4.dp))

        SearchBar(
            modifier = modifier.padding(horizontal = 16.dp),
            query = "",
            onQueryChange = onQueryChange
        )

        Spacer(modifier = modifier.height(24.dp))

        Text(
            text = stringResource(R.string.date),
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            modifier = modifier.padding(horizontal = 20.dp),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = modifier.height(4.dp))

        LeasingBar(
            modifier = modifier.padding(horizontal = 16.dp),
            query = "",
            onQueryChange = {},
            onCalendarClick = onCalendarClick
        )

        Spacer(modifier = modifier.height(24.dp))

        Button(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .height(56.dp)
                .fillMaxWidth(),
            onClick = onButtonClick,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ) {
            Row {
                Icon(
                    painter = painterResource(R.drawable.filter_svg),
                    contentDescription = "Select Filter",
                    modifier = Modifier.clickable { onCalendarClick() },
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = modifier.width(12.dp))
                Text(
                    text = stringResource(R.string.filters_button),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

    }
}

@Composable
fun CarCard(
    modifier: Modifier = Modifier,
    carName: String = "Chery Arrizo 8",
    transmission: String = "Автомат",
    engine: String = "2.5л",
    pricePerDay: String = "5 000 ₽",
    pricePer14Days: String = "70 000 ₽ за 14 дней",
    onCarClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clickable { onCarClick },
        shape = RoundedCornerShape(12.dp),
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.background,
            disabledContentColor = MaterialTheme.colorScheme.primary,
        )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = carName,
                    fontWeight = FontWeight(500),
                )
                Text(
                    text = "$transmission, $engine",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = pricePerDay,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = pricePer14Days,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
