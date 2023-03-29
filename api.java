import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class api {
    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // String url
        // ="https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbmostpopularmovies.json";
        URI uri = URI.create(url);
        var request = HttpRequest.newBuilder(uri).GET().build();
        var client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parser = new jsonParser(); // puxar de outra classe
        List<Map<String, String>> moviesList = parser.parse(body);

        // AULA1
        // for (Map<String, String> filme : moviesList) {
        // System.out.println(filme.get("title"));
        // System.out.println(filme.get("image"));
        // System.out.println(filme.get("imDbRating"));
        // System.out.println();
        // }
        // System.out.println(url);

        // AULA 2
        try {
            var stickerGenerate = new StickersGenerate();
            for (Map<String, String> filme : moviesList) {
                String urlImage = filme.get("image");
                String title = filme.get("title");
                InputStream inputStream = new URL(urlImage).openStream();

                String fileName = title + ".png";

                // EXECUTION
                stickerGenerate.generate(inputStream, fileName);
                System.out.println(title);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}// FINAL
