import java.util.List;

public class MainClass {

	public static void main(String[] args) throws Exception {
		String json = "[{name: 'Nick'}, {name: 'Felix'}]";
		List<Person> entities = Util.getEntities(json);
		System.out.println("Result entities: " + entities.toString());

		String version1 = "3.1.1";
		String version2 = "3.2";
		int versionCompare = Util.compareVersions(version1, version2);
		System.out.println("Result version compare: " + versionCompare);
	}

}