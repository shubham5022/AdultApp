package com.adultApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdultService {
	
	  @Autowired
	    private RestTemplate restTemplate;
	    
	    public static final String XRapidAPIKey = "8c773de218msh535bd52c7692a7dp1978c4jsnc19ebc6b4e79";
	    public static final String XRapidAPIHost = "girls-nude-image.p.rapidapi.com";
	    public static final String URL = "https://girls-nude-image.p.rapidapi.com/?type=clitoris";


}
