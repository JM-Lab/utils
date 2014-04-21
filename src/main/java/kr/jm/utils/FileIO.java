package kr.jm.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileIO {

	public static boolean writeString(String inputString, File targetfile) {
		if (targetfile.exists()) {
			return false;
		}

		try {
			FileUtils.writeStringToFile(targetfile, inputString);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static String readString(final File targetfile) {
		return (String) read(targetfile, new String(), new Reader<String>() {
			public String read() throws IOException {
				return FileUtils.readFileToString(targetfile);
			}
		});
	}

	public static String readString(final File targetfile, final String encoding) {
		return (String) read(targetfile, new String(), new Reader<String>() {
			public String read() throws IOException {
				return FileUtils.readFileToString(targetfile, encoding);
			}
		});
	}

	@SuppressWarnings("unchecked")
	public static List<String> readLines(final File targetfile) {
		return (List<String>) read(targetfile, new ArrayList<String>(),
				new Reader<List<String>>() {
					public List<String> read() throws IOException {
						return FileUtils.readLines(targetfile);
					}
				});
	}

	@SuppressWarnings("unchecked")
	public static List<String> readLines(final File targetfile,
			final String encoding) {
		return (List<String>) read(targetfile, new ArrayList<String>(),
				new Reader<List<String>>() {
					public List<String> read() throws IOException {
						return FileUtils.readLines(targetfile, encoding);
					}
				});
	}

	private static Object read(File targetfile, Object returnFailure,
			Reader<?> reader) {
		if (!targetfile.exists()) {
			return returnFailure;
		}

		try {
			return reader.read();
		} catch (IOException e) {
			e.printStackTrace();
			return returnFailure;
		}
	}

	private interface Reader<R> {
		R read() throws IOException;
	}
}
