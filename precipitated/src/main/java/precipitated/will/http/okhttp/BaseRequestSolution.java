package precipitated.will.http.okhttp;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by will.wang on 2017/1/10.
 */
public class BaseRequestSolution {

    public static void doGetSolution() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://www.baidu.com").build();
        Response response = client.newCall(request).execute();
        System.out.println("response =====》" + JSON.toJSONString(response));
        System.out.println("response.body() =====》" + JSON.toJSONString(response.body()));
        System.out.println("response.toString() =====》" + JSON.toJSONString(response.toString()));
    }
}
