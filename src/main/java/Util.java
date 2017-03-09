import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Util {

	public static void log(File destination, JsonLog log) throws FileNotFoundException {
		Collection<JsonLog> logs = null;
		if (destination.exists()) {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(destination));
			logs = gson.fromJson(br, new TypeToken<List<JsonLog>>(){}.getType());
			// logs.add(log);
			// serialize "logs" again
		}
	}

	public static int compareVersions(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");

		int length = Math.max(levels1.length, levels2.length);
		for (int i = 0; i < length; i++){
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if (compare != 0){
				return compare;
			}
		}

		return 0;
	}

}