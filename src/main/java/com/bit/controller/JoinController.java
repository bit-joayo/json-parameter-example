package com.bit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoinController {
	@ResponseBody
	@RequestMapping(value = "/requestObject", method = RequestMethod.POST)
	public void simpleWithObject(@RequestBody Jamong jamong) {
		System.out.println(jamong.toString());
		
		
        String strUrl = "http://127.0.0.1:5000/test";
        String strMethod = "post";
        String storyNo = jamong.storyNo;
        String title = jamong.title;
        String storyContent = jamong.storyContent;
        BufferedReader in = null;
        
        try {
            JsonParser jsonParser = new JsonParser();
//            JsonObject jsonObject = (JsonObject) jsonParser.parse("{'name':'kukaro','age':26}");
//            JsonObject jsonObject = (JsonObject) jsonParser.parse("{'storyNo':storyNo,'storyContent':storyContent,"
//            		+ "'count':count}");
        	JsonObject jsonObject = new JsonObject();
        	jsonObject.addProperty("storyNo", storyNo);
        	jsonObject.addProperty("storyContent", storyContent);
        	jsonObject.addProperty("title", title);
        	
        	JsonObject gsonObject = (JsonObject) jsonParser.parse(jsonObject.toString());
        	
            URL url = new URL(strUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestMethod(strMethod.toUpperCase());
            PrintStream ps = new PrintStream(con.getOutputStream());
            ps.print(jsonObject);
            ps.close();
            con.disconnect();
            
            
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            System.out.println("여기야12 여기");
            
//            jsonObject = (JsonObject) jsonParser.parse(in);
//            System.out.println(jsonObject);
            
            gsonObject = (JsonObject) jsonParser.parse(in);
            System.out.println(gsonObject);
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

}