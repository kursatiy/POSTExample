import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

public class WebsiteApi {

    protected static HttpClient createHTTPClient(){
        BasicCookieStore cookieStore = new BasicCookieStore();
        List<BasicHeader> ct = Collections.singletonList(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));
        return HttpClientBuilder.create().setDefaultHeaders(ct).setDefaultCookieStore(cookieStore).build();
    }

    public String  postRequest() {
        HttpClient client =  createHTTPClient();
        HttpPost postMethod = new HttpPost("http://instatestvx.me/api/auth/login");
        String message = "";
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("login", "hello@world.com");
            jsonObject.put("password", "12345678");
            postMethod.setEntity(new StringEntity(jsonObject.toString(), Charset.forName("UTF-8")));
            HttpResponse response = client.execute(postMethod);
            message = new JSONObject(EntityUtils.toString(response.getEntity())).get("message").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return message;
    }
}