package com.tnleading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TnleadingController {
	
	@Autowired
	private TnleadingDao dao;
	
	@RequestMapping("/")
	public HashMap<String, List> chennaiResult () {
		
		return getData();
	}
	
	public HashMap<String, List> getData() {
		
		List<String> profile = new ArrayList<>();
		profile.add("Yogesh Soundrapandian");
		
		List<TnleadingPojo> list = dao.getData();
		
		HashMap<String, List> map = new HashMap();
		map.put("Developed by", profile);
		map.put("Result", list);
		return map;
	}

}
