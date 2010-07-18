package ca.piggott.ofx.parser.impl;

import java.io.IOException;
import java.io.InputStreamReader;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser {
	private static enum Mode {
		TAG,
		CONTENT,
		CLOSE_TAG
	}

	public static void parse(InputStreamReader stream, DefaultHandler handler) throws IOException, SAXException {
		char[] buffer = new char[4096];
		int length;
		Mode m = Mode.CONTENT;
		StringBuilder string = new StringBuilder();
		while ((length = stream.read(buffer)) > 0) {
			for (int i=0; i<length; i++) {
				switch(m) {
				case CLOSE_TAG:
					if (buffer[i] == '>') {
						handler.endElement(null, null, string.toString());
						string.setLength(0);
						m = Mode.CONTENT;
					} else {
						string.append(buffer[i]);
					}
					break;
				case CONTENT:
					if (buffer[i] == '<') {
						m = Mode.TAG;
						if (string.length() > 0) {
							char[] characters = string.toString().trim().toCharArray();
							handler.characters(characters, 0, characters.length);
							string.setLength(0);
						}
					} else 
						string.append(buffer[i]);
					break;
				case TAG:
					if (buffer[i] == '>') {
						handler.startElement(null, null, string.toString(), null);
						string.setLength(0);
						m = Mode.CONTENT;
					} else if (buffer[i] == '/') {
						m = Mode.CLOSE_TAG;
					} else {
						string.append(buffer[i]);
					}
					break;
				}
			}
		}
	}
}
