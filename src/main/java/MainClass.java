import java.io.File;
import java.util.Date;
import java.util.List;

public class MainClass {

	public static void main(String[] args) throws Exception {
		Date timestamp = new Date();
		String msg = "Error: something went wrong";
		Util.log(new File("output.log"), new JsonLog(timestamp, msg));

		String version1 = "3.1.1";
		String version2 = "3.2";
		int versionCompare = Util.compareVersions(version1, version2);
		System.out.println("Result version compare: " + versionCompare);
	}

}