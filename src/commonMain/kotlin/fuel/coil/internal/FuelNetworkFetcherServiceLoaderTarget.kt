package fuel.coil.internal

import coil3.Uri
import coil3.annotation.InternalCoilApi
import coil3.util.FetcherServiceLoaderTarget
import fuel.coil.FuelNetworkFetcherFactory

@OptIn(InternalCoilApi::class)
internal class FuelNetworkFetcherServiceLoaderTarget : FetcherServiceLoaderTarget<Uri> {
    override fun factory() = FuelNetworkFetcherFactory()
    override fun type() = Uri::class
    override fun priority() = 1 // FuelHttpNetworkFetcher takes precedence over KtorNetworkFetcher.
}