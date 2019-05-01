package com.techsophy.TestApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestMap {
	
	
	public static void main(String args[]) throws JSONException {
		
		String test = "{\"processDefinitionKey\":\"NPSProcess\",\"tenantId\":\"rhi\",\"topic\":\"ammenities_breakfast\",\"subject\":\"test\",\"description\":\"Clean and quiet room. Staff very attentive. When asked for personal cleaning items, staff was able to provide very soon. Breakfast was very diverse and very delicious. One of my best breakfast in hotel. The hotel is not in a very safe neighborhood, but it feels safe inside. Check Out Date:2017-07-15\",\"taskpriority\":\"5\",\"taskCreator\":\"nagaraju.s@techsophy.com\",\"homeUrl\":\"http://172.16.0.200:30/nps\",\"priority\":\"Low\",\"taskDirectUrl\":\"http://172.16.0.200:30/nps/#/my-tasks\",\"assignee\":\"bhargavi.c@techsophy.com\",\"brand\":\"hoteldemo\",\"read\":\"\",\"contentId\":\"80745\"}";
		JSONObject jobj = new JSONObject(test);
		
		Map<String, Object> retMap = new HashMap<String, Object>();

	    if(jobj != JSONObject.NULL) {
	        retMap = toMap(jobj);
	    }
		
	    for (Map.Entry<String,Object> entry : retMap.entrySet())  {
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
    } 
		
		
	}
	
	public static Map<String, Object> toMap(JSONObject object) throws JSONException {
	    Map<String, Object> map = new HashMap<String, Object>();

	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);

	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		/*private static void loadJson(JSONObject json) throws JSONException{
			
			
			HashMap<String,Object> myKeyValues = new HashMap<String,Object>();
		
			Stack<String> key_path = new Stack<String>();
			
		    Iterator<?> json_keys = json.keys();

		    while( json_keys.hasNext() ){
		        String json_key = (String)json_keys.next();

		        try{
		            key_path.push(json_key);
		            loadJson(json.getJSONObject(json_key));
		       }catch (JSONException e){
		           // Build the path to the key
		           String key = "";
		           for(String sub_key: key_path){
		               key += sub_key+".";
		           }
		           key = key.substring(0,key.length()-1);

		           System.out.println(key+": "+json.get(json_key).toString());
		           key_path.pop();
		           myKeyValues.put(key, json.getString(json_key));
		        }
		    }
		    if(key_path.size() > 0){
		        key_path.pop();
		    }
		}*/
	

}
