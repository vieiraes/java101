import classes.*;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import utils.jsonParser;

public class App {
    public static void main(String[] args) throws Exception {
        var connection = new SetConnection();
        var api = new SetURL().getApi();
        var body = connection.connect(api);

        // var parser = new jsonParser();
        // List<Map<String, String>> moviesList = parser.parse(body);

        // // AULA1
        // for (Map<String, String> filme : moviesList) {
        // System.out.println(filme.get("title"));
        // System.out.println(filme.get("image"));
        // System.out.println(filme.get("imDbRating"));
        // System.out.println();
        // }
        // System.out.println(url);

        // AULA 2

        try {
            String folderPath = "static/images/";
            var folder = new File(folderPath);
            folder.mkdir();

            for (Map<String, String> filme : moviesList) {
                var stickerGenerate = new StickersGenerate();
                String urlImage = filme.get("image");
                String title = filme.get("title");
                String fileName = folder + title + ".png";
                InputStream inputStream = new URL(urlImage).openStream();

                // EXECUTION
                stickerGenerate.generate(inputStream, fileName);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}// FINAL