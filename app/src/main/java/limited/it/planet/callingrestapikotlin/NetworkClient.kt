package limited.it.planet.callingrestapikotlin

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.InputStream

/**
 * Created by Tarikul on 4/22/2018.
 */
class NetworkClient {

    fun get(url: String): InputStream {
        val request = Request.Builder().url(url).build()
        val response = OkHttpClient().newCall(request).execute()
        val body = response.body()
        // body.toString() returns a string representing the object and not the body itself, probably
        // kotlins fault when using third party libraries. Use byteStream() and convert it to a String
        return body!!.byteStream()
    }
}