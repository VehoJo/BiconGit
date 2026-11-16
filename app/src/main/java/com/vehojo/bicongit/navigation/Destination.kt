package com.vehojo.bicongit.navigation

sealed class Destination(val route: String) {
    data object SearchScreen: Destination(ROUTE_SEARCH)
    data object ProfileScreen: Destination(ROUTE_PROFILE)
    data object FavoritesScreen: Destination(ROUTE_FAVORITES)

    companion object {
        private const val ROUTE_SEARCH = "route_search"
        private const val ROUTE_PROFILE = "route_profile"
        private const val ROUTE_FAVORITES = "route_favorites"

    }
}