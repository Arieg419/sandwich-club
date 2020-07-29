package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject nameData  = new JSONObject(String.valueOf(jsonObject.get("name")));
        String mainName = String.valueOf(nameData.get("mainName"));
        String alsoKnownAsStr = String.valueOf(nameData.get("alsoKnownAs"));
        String placeOfOrigin = String.valueOf(jsonObject.get("placeOfOrigin"));
        String description = String.valueOf(jsonObject.get("description"));
        String img = String.valueOf(jsonObject.get("image"));
        String ingredientsAsStr = String.valueOf(jsonObject.get("ingredients"));
        List<String> ingredients = Arrays.asList(ingredientsAsStr.split(","));
        List<String> aka = Arrays.asList(alsoKnownAsStr.split(","));
        return new Sandwich(mainName, aka, placeOfOrigin, description, img, ingredients);
        } catch (JSONException e) {
            return null;
        }
    }
}
