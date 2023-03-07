package com.chemasmas.fakestoreapi.presentation.features.signUp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chemasmas.fakestoreapi.core.designSystem.previewsConfig.PhonePreview
import com.chemasmas.fakestoreapi.ui.theme.FakeStoreAPiTheme
import kotlinx.coroutines.launch

@Composable
fun SignUpScreenContainer(
) {
    Form()
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Form() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val pagerState = rememberPagerState(0)
        val scope = rememberCoroutineScope()

        HorizontalPager(
            modifier = Modifier.fillMaxHeight(0.6f)
                .fillMaxWidth()
                .padding(32.dp),
            pageCount = 3,
            state = pagerState,
            pageSize = PageSize.Fill
        ) {step ->
            when(step){
                0 -> {
                    StepOne(
                        nextPage = {
                            scope.launch {
                                pagerState.animateScrollToPage(1)
                            }
                        }
                    )
                }
                1 -> {
                    StepTwo(
                        nextPage = {
                            scope.launch {
                                pagerState.animateScrollToPage(2)
                            }
                        }
                    )
                }
                else -> {
                    StepThree()
                }
            }
        }
    }
}

@Composable
@PhonePreview
fun StepOne(
    modifier: Modifier = Modifier,
    nextPage: () -> Unit = {},
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.email ?: "",
            onValueChange = {
                viewModel.setEmail(it)
            },
            label = { Text(text = "Email") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.username ?: "",
            onValueChange = {
                viewModel.setUserName(it)
            },
            label = { Text(text = "Username") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.password ?: "",
            onValueChange = {
                viewModel.setPassword(it)
            },
            label = { Text(text = "Password") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.confirmPassword ?: "",
            onValueChange = {
                viewModel.setConfirmPassword(it)
            },
            label = { Text(text = "Confirm Password") })
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                nextPage()
            }) {
            Text(text = "Next")
        }
    }
}

@Composable
@PhonePreview
fun StepTwo(
    modifier: Modifier = Modifier,
    nextPage: () -> Unit = {},
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.fullName?.firstName ?: "",
            onValueChange = {
                viewModel.setFirstName(it)
            },
            label = { Text(text = "First Name") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.fullName?.lastName  ?: "",
            onValueChange = {
                viewModel.setLastName(it)
            },
            label = { Text(text = "Last Name") }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                nextPage()
            }) {
            Text(text = "Next")
        }
    }
}

@Composable
@PhonePreview
fun StepThree(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.address?.city ?: "",
            onValueChange = {
                viewModel.setCity(it)
            },
            label = { Text(text = "City") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.address?.street ?: "",
            onValueChange = {
                viewModel.setStreet(it)
            },
            label = { Text(text = "Street") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.address?.number.toString(),
            onValueChange = {
                viewModel.setNumber(it.toInt())
            },
            label = { Text(text = "Number") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.formData?.address?.zipCode ?: "",
            onValueChange = {
                viewModel.setZipCode(it)
            },
            label = { Text(text = "Zip Code") }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.sendForm()
            }) {
            Text(text = "Finish")
        }
    }
}


@PhonePreview
@Composable
fun LoadingScreenPreview() {
    FakeStoreAPiTheme {
        Form()
    }
}