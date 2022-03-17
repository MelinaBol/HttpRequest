import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJson {

    public static String parse(String responsebody) {
        JSONArray albums = new JSONArray(responsebody);
        for (int i = 0; i < albums.length(); i++) {
            JSONObject album = albums.getJSONObject(i);
            int id = album.getInt("id");
            String titel = album.getString("title");
            System.out.println(id + " " + titel + " ");
        }
        return null;
    }
}
