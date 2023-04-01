package classes;

public class SetURL {
    public String getApi() {
        String api_key = "aYSd9MXjruDscSdjndXWv8GNEtfuewLTbddyTeLk";
        String count = "2";
        String url = "https://api.nasa.gov/planetary/apod?api_key=" + api_key + "&count=" + count;
        return url;
    }
}
