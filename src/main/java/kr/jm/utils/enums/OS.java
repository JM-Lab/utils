package kr.jm.utils.enums;

import java.io.File;

import kr.jm.utils.AutoStringBuilder;

public enum OS {

	WINDOWS, MAC, LINUX;

	private static final String fileSeparator = System
			.getProperty("file.separator");

	public static String getFileSeparator() {
		return fileSeparator;
	}

	public static String getLineSeparator() {
		return System.getProperty("line.separator");
	}

	public static String getOsName() {
		return System.getProperty("os.name");
	}

	public static String getOsVersion() {
		return System.getProperty("os.version");
	}

	public static String getUserWorkingDir() {
		return System.getProperty("user.dir");
	}

	public static String getUserHomeDir() {
		return System.getProperty("user.home");
	}

	public static String buildPath(String... strings) {
		AutoStringBuilder asb = new AutoStringBuilder(fileSeparator);
		for (String string : strings) {
			asb.append(string);
		}
		return asb.toString();
	}

	public static OS getOs() {
		String os = getOsName().toLowerCase();
		if (os.contains("windows")) {
			return WINDOWS;
		} else if (os.contains("mac")) {
			return MAC;
		} else {
			return LINUX;
		}
	}

	public boolean open(File file) {
		switch (this) {
		case WINDOWS:
			return open("cmd /c ", file);
		case MAC:
			return open("open ", file);
		default:
			return open("open ", file);
		}
	}

	private boolean open(String runCmd, File file) {
		try {
			String command = runCmd + file.getAbsolutePath();
			System.out.println("open command : " + command);
			Runtime.getRuntime().exec(command);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Can't Execute The Program For "
					+ file.getAbsolutePath());
			return false;
		}
		System.out.println(file.getAbsolutePath());
		return true;
	}

}
