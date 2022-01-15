import java.io.IOException;
import java.util.Scanner;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClentTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello from HttpClentTest!");
        //Creating a HttpClient object
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //Creating a HttpGet object
        // https://api.openweathermap.org/data/2.5/weather?q=London&appid=3ea4abe0212f835881380b8afaa025d4
        // https://api.minfin.com.ua/mb/18b8c97cd7d66e052c2c9e34b801069c8409fb87/2021-04-14?currency=usd
        HttpGet httpget = new HttpGet("https://3d074280-9832-4ebf-8b88-235341d1267c.mock.pstmn.io/mytest");
        // HttpGet httpget = new HttpGet("https://api.openweathermap.org/data/2.5/weather?q=London&appid=3ea4abe0212f835881380b8afaa025d4");
        //Printing the method used
        System.out.println("Request Type: "+httpget.getMethod());
        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());
        //Printing the status line
        System.out.println(httpresponse.getStatusLine());
        String result = "";
        while(sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(line);
            result+=line;
        }
        //
    }
}
