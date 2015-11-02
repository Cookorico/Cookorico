package fil.iagl.cookorico.controller.util;

import org.json.JSONObject;

public class JsonRequestParser {
	
	private JSONObject requestObject;
	
	public JsonRequestParser() {
	}
	
	public JsonRequestParser(String request) {
		parse(request);
	}
	
	public void parse(String request) {
		requestObject = new JSONObject(request);
	}
	
	public Object getValue(String key) {
		return requestObject.get(key);
	}

}
