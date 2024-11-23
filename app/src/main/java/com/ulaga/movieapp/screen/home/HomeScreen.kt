package com.ulaga.movieapp.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ulaga.movieapp.model.Movie
import com.ulaga.movieapp.model.getMovies
import com.ulaga.movieapp.navigation.MovieScreens
import com.ulaga.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
        TopAppBar(
            modifier = Modifier,
            colors = TopAppBarDefaults.topAppBarColors().copy(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            title = {
                Text(text = "Movie")
            },

            )
    }) {
        Column(modifier = Modifier.padding(it)) {
            MainContent(navController)
        }

    }
}


@Composable
fun MainContent(
    navController: NavController, movieList: List<Movie> = getMovies()
) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn {
                items(items = movieList) { movieItem ->
                    MovieRow(movieItem) { movie ->
                        navController.navigate(MovieScreens.DetailsScreen.name + "/$movie")
                    }
                }
            }
        }
    }
}


