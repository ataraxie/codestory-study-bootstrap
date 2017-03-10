import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;

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
			logs = gson.fromJson(br, ArrayList<JsonLog>.class);
			// logs.add(log);
			// serialize "logs" again
		}
	}

	public static int compareVersions(String version1, String version2) {
		//  View code story: http://nicholascbradley.com:4321/codestory/012cd5e8d
		DefaultArtifactVersion mvnVersion1 = new DefaultArtifactVersion(version1);
		DefaultArtifactVersion mvnVersion2 = new DefaultArtifactVersion(version2);

		DefaultArtifactVersion version = new DefaultArtifactVersion("1.11");

		return mvnVersion1.compareTo(mvnVersion2);
	}

}