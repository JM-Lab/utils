package kr.jm.utils.helper;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class JMFileIO {

	public static boolean writeString(String inputString, File targetfile) {
		if (!targetfile.exists()) {
			try {
				FileUtils.writeStringToFile(targetfile, inputString);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public static String readString(final File targetfile) {
		return (String) read(targetfile, new Reader<String>() {
			public String read() throws IOException {
				return FileUtils.readFileToString(targetfile);
			}
		});
	}

	public static String readString(final File targetfile, final String encoding) {
		return (String) read(targetfile, new Reader<String>() {
			public String read() throws IOException {
				return FileUtils.readFileToString(targetfile, encoding);
			}
		});
	}

	public static List<String> readLines(final File targetfile) {
		return (List<String>) read(targetfile, new Reader<List<String>>() {
			public List<String> read() throws IOException {
				return FileUtils.readLines(targetfile);
			}
		});
	}

	public static List<String> readLines(final File targetfile,
			final String encoding) {
		return (List<String>) read(targetfile, new Reader<List<String>>() {
			public List<String> read() throws IOException {
				return FileUtils.readLines(targetfile, encoding);
			}
		});
	}

	private static <R> R read(File targetfile, Reader<R> reader) {
		if (!targetfile.exists())
			return null;
		try {
			return reader.read();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private interface Reader<R> {
		R read() throws IOException;
	}
}
