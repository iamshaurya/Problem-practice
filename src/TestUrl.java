import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class TestUrl {
	public static void main(String[] args) throws Exception {

        URL aURL = new URL("http://example.com:80/docs/books/tutorial"
                           + "/index.html?name=networking#DOWNLOADING");

        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
        System.out.println("filename = " + aURL.getFile());
        System.out.println("ref = " + aURL.getRef());
        System.out.println(aURL.toURI().getRawPath());
        
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        String a = sdf.format(new Date("05-02-2018"));
//        String b = sdf.format(new Date("01-02-2018"));
//        System.out.println(a);
//        System.out.println(a.equals(b));
//        
        Integer i = 5;
        i = (i = null) != null? i: null;
        System.out.println(i);
    }
}
