import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbmostpopularmovies.json";
        System.out.println(url);
    }
}