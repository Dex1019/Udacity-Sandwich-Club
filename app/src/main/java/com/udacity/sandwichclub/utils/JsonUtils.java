package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            JSONObject sandwichJsonObject = new JSONObject(json);

            JSONObject name = sandwichJsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");

            JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = jsonArrayToString(alsoKnownAsArray);

            String placeOfOrigin = sandwichJsonObject.getString("placeOfOrigin");
            String description = sandwichJsonObject.getString("description");
            String image = sandwichJsonObject.getString("image");

            JSONArray ingredientsJsonArray = sandwichJsonObject.getJSONArray("ingredients");
            List<String> ingredients = jsonArrayToString(ingredientsJsonArray);

            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }

    private static List<String> jsonArrayToString(JSONArray jsonArray) throws JSONException {
        int arrayLength = jsonArray.length();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            result.add(jsonArray.getString(i));
        }
        return result;
    }
}
