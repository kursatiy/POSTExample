import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckWebsiteApi {


    @Test
    public void checkPostMethod(){
        WebsiteApi site = new WebsiteApi();
        String responseMessage = site.postRequest();
        Assert.assertEquals(responseMessage, "The password and email you entered don't match. If you forgot your password, use \"Forgot Password\"");



    }
}
