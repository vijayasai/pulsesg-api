package com.pulsesg.platform.core.task.util;

import com.google.gson.*;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Gson Utilities for Task
 * @author Vijayasai Kesanupalli
 *
 */
public class GsonUtil {

	public static final Gson gson = new GsonBuilder().disableHtmlEscaping()

			.registerTypeAdapter(HashMap.class, new JsonDeserializer<HashMap>() {
				public HashMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
						throws JsonParseException{
					HashMap<String,Object> resultMap=new HashMap<>();
					JsonObject jsonObject = json.getAsJsonObject();
					Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
					for (Map.Entry<String, JsonElement> entry : entrySet) {
						resultMap.put(entry.getKey(),entry.getValue());
					}
					return resultMap;
				}
			})
			.create();

	private GsonUtil(){

	}

	public static <T> T getObjectFromJson(String json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

	public static <T> T getObjectFromJson(JsonObject json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

	public static <T> T getObjectFromJson(Reader json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

	public static String getJsonFromObject(Object obj) {
		return gson.toJson(obj);
	}

	public static <T> T[] getObjectFromJsonArray(JsonArray jsonArray, Class<T[]> classOfT) {
		return gson.fromJson(jsonArray, classOfT);
	}

}
