// again no package name
package com.melina.http;

import org.json.JSONArray;
import org.json.JSONObject;

// JsonReader would suggest reading from a given json
// You are actually parsing a string to a json, so JsonParser is a better name.
public class JsonParser {

    private JsonParser() {
        // Since you gave this class only static function(s) it is considered as a utility class.
        // To avoid instantiation of that, give it a private constructor.
    }

    public static String parse(String responseBody) { // Java always camel case
        var albums = new JSONArray(responseBody);
        // There are many ways to iterate. This for each loop is cleaner for your use case
        albums.forEach(album -> {
            var json = (JSONObject) album;
            System.out.println(json.getInt("id") + " " + json.getString("title"));
        });
        return albums.toString(); // Null can lead to Nullpointer Exceptions - don't return null, always try to avoid it
    }
}
