package fuel.coil.internal

import coil3.network.NetworkRequest
import coil3.network.NetworkResponse
import coil3.network.NetworkResponseBody
import fuel.HttpResponse
import okio.Buffer

actual fun HttpResponse.toNetworkResponse(request: NetworkRequest): NetworkResponse {
    return NetworkResponse(
        request = request,
        code = statusCode,
        headers = headers.toNetworkHeaders(),
        body = NetworkResponseBody(Buffer().apply { writeUtf8(body.toString()) } ),
        delegate = this,
    )
}