import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class jsonObject {
    JSONObject jsonObject = new JSONObject();
    JSONArray jsonArray = new JSONArray();
    jsonArray.add("laranja");
    jsonArray.add("banana");
    jsonArray.add("maçã");

    jsonObject.put("nome", "Maria");
    jsonObject.put("idade", 30);
    jsonObject.put("frutas", jsonArray);
    String jsonString = jsonObject.toJSONString();
    System.out.println(jsonString);
}
