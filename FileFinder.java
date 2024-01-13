import java.util.*;
import java.io.*;
import java.nio.file.*;

public class FileFinder {

	private static final String CONFIG_FILE = "config.txt";
	private static final String PARAM_VERBOSE = "verboseMode";
	private static final String PARAM_LOG_FILE = "logFile";

	public static void main(String[] args) {

		boolean verboseMode = false; // default if unable to read config
	}

	private static Map<String, String> getConfigParameters(String configFile) throws IOException {
		Map<String, String> params = new HashMap<>();

		Scanner input = new Scanner(Paths.get(configFile));
		
		while(input.hasNext()) {
			params.put(input.next(), input.next());
		}
		
		return params;
	}

	private static Map<Path, Long> getFilesUnderDirectory(
		Path directory, String file, boolean verboseMode, PrintWriter writer) {

	}
}
