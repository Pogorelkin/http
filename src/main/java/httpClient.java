import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;


public class httpClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://ya.ru/");
        HttpPost httpPost = new HttpPost("http://httpbin.org/post");



        try {
            CloseableHttpResponse responseGet = httpclient.execute(httpGet);
            //CloseableHttpResponse responsePost = httpclient.execute(httpPost);
            System.out.println("Executing GET method");
            System.out.println("status:" + responseGet.getStatusLine());
            System.out.println("Request's headers and body");

            for (Header header : responseGet.getAllHeaders()) {
                System.out.println(header.toString());
            }

            System.out.println("_____________________________________________");
            CloseableHttpResponse responsePost = httpclient.execute(httpPost);
            System.out.println("Executing POST method");
            System.out.println("status:" + responsePost.getStatusLine());
            System.out.println("Request's headers and body");

            for (Header header : responsePost.getAllHeaders()) {
                System.out.println(header.toString());
            }

        }
        finally {
            httpclient.close();
        }

    }
}
