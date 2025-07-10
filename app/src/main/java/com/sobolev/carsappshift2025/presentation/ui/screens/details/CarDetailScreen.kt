package com.sobolev.carsappshift2025.presentation.ui.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.sobolev.carsappshift2025.R
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.presentation.presentation.CarDetailCommand
import com.sobolev.carsappshift2025.presentation.presentation.CarDetailScreen
import com.sobolev.carsappshift2025.presentation.presentation.CarDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarDetailsScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onBookClick: () -> Unit = {},
    carId: String,
    viewModel: CarDetailViewModel = hiltViewModel(
        creationCallback = { factory: CarDetailViewModel.Factory ->
            factory.create(carId)
        }
    )
) {

    val state = viewModel.state.collectAsState()
    val currentState = state.value

    when (currentState) {
        is CarDetailScreen.Booking -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Автомобили",
                                fontSize = 24.sp,
                                fontWeight = FontWeight(700),
                                color = MaterialTheme.colorScheme.primary
                            )
                        },
                        navigationIcon = {
                            Spacer(modifier = modifier.width(64.dp))
                            IconButton(onClick = {
                                viewModel.processCommand(CarDetailCommand.Back)
                            }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Назад",
                                    tint = MaterialTheme.colorScheme.secondary
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.background
                        )
                    )
                }
            ) { innerPadding ->

                Column(
                    modifier = modifier
                        .padding(innerPadding)
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    AsyncImage(
                        model = "https://shift-intensive.ru/api" +
                                currentState.car.media.first { it.isCover }.url,
                        contentDescription = "Car Image",
                        modifier = Modifier
                            .width(328.dp)
                            .height(220.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = currentState.car.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = stringResource(R.string.char_for_car),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CharacteristicsTable(currentState.car)


                    Text(
                        text = stringResource(R.string.cost),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Итого: ${currentState.car.price} ₽",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Аренда: 10 – 24 апреля 2025 (14 дней)",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        modifier = modifier
                            .padding(horizontal = 16.dp)
                            .height(56.dp)
                            .fillMaxWidth(),
                        onClick = {
                            viewModel.processCommand(CarDetailCommand.Back)
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.primary,
                            disabledContainerColor = MaterialTheme.colorScheme.background,
                            disabledContentColor = MaterialTheme.colorScheme.primary
                        ),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary)
                    ) {
                        Row {
                            Text(
                                text = stringResource(R.string.back_button),
                                fontSize = 16.sp,
                                fontWeight = FontWeight(600),
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        modifier = modifier
                            .padding(horizontal = 16.dp)
                            .height(56.dp)
                            .fillMaxWidth(),
                        onClick = onBookClick,
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            disabledContainerColor = MaterialTheme.colorScheme.tertiary,
                            disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Row {
                            Text(
                                text = stringResource(R.string.book_button),
                                fontSize = 16.sp,
                                fontWeight = FontWeight(600),
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

        is CarDetailScreen.Error -> {}
        CarDetailScreen.Finished -> {
            LaunchedEffect(key1 = Unit) {
                onBackClick()
            }
        }
        CarDetailScreen.Initial -> {}
    }

}

@Composable
private fun CharacteristicsTable(car: Car) {
    val items = listOf(
        "Коробка передач" to car.transmission,
        "Сторона руля" to car.steering,
        "Тип кузова" to car.bodyType,
        "Цвет" to car.color
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        items.forEachIndexed { index, (title, value) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = title, color = MaterialTheme.colorScheme.secondary)
                Text(text = value)
            }

            if (index < items.lastIndex) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                )
            }
        }
    }
}

