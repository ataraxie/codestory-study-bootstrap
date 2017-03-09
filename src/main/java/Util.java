import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static List<Person> getEntities(String json) throws IllegalStateException {
		// The list we want to return
		List<Person> entities = new ArrayList<Person>();
		Gson gson = new Gson();
		JsonElement object = new JsonParser().parse(json);
		JsonArray array = object.getAsJsonArray();
		// JsonArray implements Iterable and can be used a lot like a List
		for (JsonElement element : array) {
			JsonElement entityObject = element.getAsJsonObject();
			// for each object in the json, create our custom object
			if (entityObject.isJsonObject()) {
				entities.add(gson.fromJson(entityObject, Person.class));
			}
		}
		return entities;
	}

	public static int compareVersions(String str1, String str2) {
		String[] vals1 = str1.split("\\.");
		String[] vals2 = str2.split("\\.");
		int i = 0;
		// set index to first non-equal ordinal or length of shortest version string
		while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])) {
			i++;
		}
		// compare first non-equal ordinal number
		if (i < vals1.length && i < vals2.length) {
			int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
			return Integer.signum(diff);
		}
		// the strings are equal or one string is a substring of the other
		// e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
		return Integer.signum(vals1.length - vals2.length);
	}

}