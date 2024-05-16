package fuel.coil.internal

import coil3.annotation.InternalCoilApi
import coil3.network.NetworkFetcher
import coil3.util.ServiceLoaderComponentRegistry
import kotlin.test.Test
import kotlin.test.assertTrue

class FuelNetworkFetcherServiceLoaderTest {

    @OptIn(InternalCoilApi::class)
    @Test
    fun serviceLoaderFindsFetcher() {
        val fetchers = ServiceLoaderComponentRegistry.fetchers
        assertTrue(fetchers.any { it.factory() is NetworkFetcher.Factory })
    }
}