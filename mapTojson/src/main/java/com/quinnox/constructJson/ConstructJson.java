package com.quinnox.constructJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ConstructJson {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		JSONObject jsonObject=null;
		
		jsonObject=new JSONObject();
		jsonObject.put("dash_url", "http://mediaserver.superprofs.com:1935/vods3/_definst_/mp4:amazons3/superprofs-media"
				+ "/private/lectures/12/12_960x540_200k.mp4/manifest.mpd");
		jsonObject.put("video_bitrate", "200k");
		jsonObject.put("audio_bitrate", "32k");
		jsonObject.put("video_width", 960);
		jsonObject.put("video_height", 540);
		jsonObject.put("file_size", 125465600);
		
		System.out.println(jsonObject);
		
		JSONArray jsonArray=new JSONArray();
		jsonArray.add(jsonObject);
		System.out.println("==========================");
		System.out.println(jsonArray);
		jsonObject=new JSONObject();
		
		jsonObject.put("12", jsonArray);
		System.out.println("==========================");
		System.out.println(jsonObject);
	}

}
