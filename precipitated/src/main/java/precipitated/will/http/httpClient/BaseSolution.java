package precipitated.will.http.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by will.wang on 2017/1/10.
 */
public class BaseSolution {

    public static void doInterceptors() throws IOException {
        CloseableHttpClient httpclient = HttpClients.custom()
                .addInterceptorLast(new HttpRequestInterceptor() {

                    public void process(
                            final HttpRequest request,
                            final HttpContext context) throws HttpException, IOException {
                        AtomicInteger count = (AtomicInteger) context.getAttribute("count");
                        request.addHeader("Count", Integer.toString(count.getAndIncrement()));
                    }

                })
                .build();

        AtomicInteger count = new AtomicInteger(1);
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAttribute("count", count);

        HttpGet httpget = new HttpGet("https://www.baidu.com");
        for (int i = 0; i < 10; i++) {
            CloseableHttpResponse response = httpclient.execute(httpget, localContext);
            try {
                HttpEntity entity = response.getEntity();
            } finally {
                response.close();
            }
        }
    }
}
