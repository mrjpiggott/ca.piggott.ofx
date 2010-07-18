package ca.piggott.ofx.parser.impl;

public interface OFXObject {
	public void addProperty(String tag, String item);

	public void addObject(OFXObject obj);
}