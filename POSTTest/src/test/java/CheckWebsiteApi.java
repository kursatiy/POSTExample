import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckWebsiteApi {


    @Test
    public void checkPostMethod() throws IOException {
        WebsiteApi site = new WebsiteApi();
        String responseMessage = site.postRequest();
        Assert.assertEquals(responseMessage, "The password and email you entered don't match. If you forgot your password, use \"Forgot Password\"");



    }
}
