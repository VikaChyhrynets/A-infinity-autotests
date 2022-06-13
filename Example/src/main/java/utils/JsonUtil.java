package utils;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.google.gson.JsonParser.parseString;

@Slf4j
public class JsonUtil {
    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

    @SneakyThrows
    public static <T> T readJsonObjectFromFile(String pathToFile, Class<T> classType) {
        try (JsonReader reader = new JsonReader(new FileReader(pathToFile))) {
            return GSON.fromJson(reader, classType);
        } catch (FileNotFoundException fileNotFoundException) {
            throw new FileNotFoundException("File with path \"" + pathToFile + "\" not found: " +
                    fileNotFoundException.getLocalizedMessage());
        }
    }

    public static <T> String convertJsonObjectToString(T obj) {
        return GSON.newBuilder().setPrettyPrinting().create().toJson(obj);
    }

    public static JsonElement toJsonTree(Object src) {
        return GSON.toJsonTree(src);
    }

    public static String toJson(Object src) {
        return GSON.toJson(src);
    }

    public static String beautifyString(String jsonString) {
        return GSON.toJson(parseString(jsonString).getAsJsonObject());
    }
}