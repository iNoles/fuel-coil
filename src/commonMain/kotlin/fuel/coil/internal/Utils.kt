package fuel.coil.internal

import coil3.annotation.ExperimentalCoilApi
import coil3.network.NetworkClient
import coil3.network.NetworkHeaders
import coil3.network.NetworkRequest
import coil3.network.NetworkResponse
import coil3.network.NetworkResponseBody
import fuel.Fuel
import fuel.HttpResponse
import fuel.method
import okio.Buffer
import kotlin.jvm.JvmInline

@OptIn(ExperimentalCoilApi::class)
@JvmInline
internal value class FuelNetworkClient(
    private val fuel: Fuel,
) : NetworkClient {
    override suspend fun <T> executeRequest(
        request: NetworkRequest,
        block: suspend (response: NetworkResponse) -> T,
    ): T {
        val method = fuel.method(
            url = request.url,
            method = request.method,
            body = request.body.toString(),
            headers = request.headers.toHeaders()
        )
        return block(method.toNetworkResponse(request))
    }
}

@OptIn(ExperimentalCoilApi::class)
private fun HttpResponse.toNetworkResponse(request: NetworkRequest): NetworkResponse {
    return NetworkResponse(
        request = request,
        code = statusCode,
        //headers = headers.toNetworkHeaders(),
        body = NetworkResponseBody(Buffer().apply { writeUtf8(body) } ),
        delegate = this,
    )
}

@OptIn(ExperimentalCoilApi::class)
private fun NetworkHeaders.toHeaders(): Map<String, String> {
    val headers = mutableMapOf<String, String>()
    for ((key, values) in asMap()) {
        for (value in values) {
            headers[key] = value
        }
    }
    return headers
}

/*@OptIn(ExperimentalCoilApi::class)
private fun Map<String, String>.toNetworkHeaders(): NetworkHeaders {
    val headers = NetworkHeaders.Builder()
    for ((key, values) in this) {
        headers.add(key, values)
    }
    return headers.build()
}*/
