package fuel.coil

import coil3.annotation.ExperimentalCoilApi
import coil3.network.CacheStrategy
import coil3.network.NetworkClient
import coil3.network.NetworkFetcher
import fuel.Fuel
import fuel.coil.internal.FuelNetworkClient

@OptIn(ExperimentalCoilApi::class)
fun FuelNetworkFetcherFactory() = NetworkFetcher.Factory(
    networkClient = { Fuel.asNetworkClient() },
    cacheStrategy = { CacheStrategy() },
)

@OptIn(ExperimentalCoilApi::class)
fun FuelNetworkFetcherFactory(fuel: Fuel) = NetworkFetcher.Factory(
    networkClient = { fuel.asNetworkClient() },
    cacheStrategy = { CacheStrategy() },
)

@OptIn(ExperimentalCoilApi::class)
fun Fuel.asNetworkClient(): NetworkClient {
    return FuelNetworkClient(this)
}