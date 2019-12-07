package library.parser;

import com.google.gson.Gson;

public class JsonParser {

	public static Object parseJson(String json, Class c) 
	{
		Object obj = new Gson().fromJson(json, c);
		return obj;
	}
}
