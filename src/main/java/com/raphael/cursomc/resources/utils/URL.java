package com.raphael.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

	
	public static List<Integer> decodeIntList(String url){
		List<Integer> list = new ArrayList<>();
		String[] vet = url.split(",");
		
		for(int i =0; i<vet.length; i++) {
			list.add(Integer.parseInt(vet[i]));
		}
		
		return list;
	}
	
	public static String decodeParam(String url) {
		try {
			return URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
