package ca.piggott.ofx.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.SAXException;

import ca.piggott.ofx.model.IOFXRoot;
import ca.piggott.ofx.parser.impl.OFXObjectHandler;
import ca.piggott.ofx.parser.impl.Parser;

public class OFXParser {
	/* Open Financial Headers */
	private static final String DATA = "DATA";

	private static final String OFXSGML = "OFXSGML";

	private Map<String,String> properties = new HashMap<String,String>();

	public IOFXRoot parse(InputStream in) throws IOException, ParseException, SAXException {
		AnInputStream stream = new AnInputStream(in);
		parseProperties(stream);

		InputStreamReader reader = new InputStreamReader(stream, getEncoding());
		if (OFXSGML.equals(properties.get(DATA))) {
			OFXObjectHandler handler = new OFXObjectHandler();
			Parser.parse(reader, handler);
			return handler.getObject();
		} else 
			throw new UnsupportedOperationException("Format is unknown: " + properties.get(DATA));
	}

	private void parseProperties(AnInputStream stream) throws IOException, ParseException {
		byte[] buff = new byte[4];

		if (stream.read(buff) > 0) {
			stream.unread(buff);

			StringBuilder buffer = new StringBuilder();
			buffer.append(new String(buff));
			if (buffer.charAt(0) == '<')
				parseV2Headers(stream);
			else 
				parseV1Headers(stream);
		} else {
			throw new ParseException("The stream is empty", 0);
		}
	}

	private void parseV2Headers(AnInputStream reader) {
		throw new UnsupportedOperationException("V2 headers not yet supported");
	}

	private void parseV1Headers(AnInputStream reader) throws IOException {
		StringBuilder stringBuffer = new StringBuilder();
		byte[] buffer = new byte[512];
		int length;

		String property = null;

		while ((length = reader.read(buffer)) > 0 ) {
			if (length != buffer.length){
				byte[] temp = new byte[length];
				System.arraycopy(buffer, 0, temp, 0, length);
				buffer = temp;
			}
			stringBuffer.append(new String(buffer));

			if (property == null) {
				int div = stringBuffer.indexOf(":");
				int newLine = stringBuffer.indexOf(new String("\n"));
				if (newLine < div) {
					reader.unread(stringBuffer.substring(newLine+1).getBytes());
					break;
				} else if (div != -1) {
					property = stringBuffer.substring(0, div);
					stringBuffer.delete(0, div+1);
				}
			} else {
				int div = stringBuffer.indexOf(new String(new char[]{0x0A}));
				if (div != -1) {
					if (property != null) {
						properties.put(property, stringBuffer.substring(0, div));
						stringBuffer.delete(0, div+1);
						property = null;
					}
				}
			}
		}
	}

	private String getEncoding() {
		String encoding = properties.get("ENCODING");
		if ("USASCII".equals(encoding) || encoding == null)
			return "US-ASCII";
		else if ("UNICODE".equals(encoding)) 
			return "UTF-8";
		return encoding;
	}

	private static class AnInputStream extends InputStream {
		private byte[] buffer = new byte[0];
		private int index;
		private InputStream in;

		public AnInputStream(InputStream in) {
			this.in = in;
		}
		@Override
		public int read() throws IOException {
			if (buffer.length <= index)
				return in.read();
			else
				return buffer[index++];
		}

		void unread(byte[] buffer) {
			this.buffer = buffer;
			index = 0;
		}
	}
}