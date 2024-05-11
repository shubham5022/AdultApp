package com.adultApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/naughty")
    public String HomeView() {
        return "index.jsp";
    }

    @RequestMapping("hitme")
    public String hitme(@RequestParam("type") String type, Model m) throws URISyntaxException  {
        RestTemplate restTemplate = new RestTemplate();

        String URL = "https://girls-nude-image.p.rapidapi.com/?type=" + type;
        
        System.out.println(URL);

        final String XRapidAPIKey = "8c773de218msh535bd52c7692a7dp1978c4jsnc19ebc6b4e79";
        final String XRapidAPIHost = "girls-nude-image.p.rapidapi.com";

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", XRapidAPIKey);
        headers.add("X-RapidAPI-Host", XRapidAPIHost);

       
            RequestEntity<Object> req = new RequestEntity<>(headers, HttpMethod.GET, new URI(URL));

            ResponseEntity<Map> res = restTemplate.exchange(req, Map.class);

            Map<String, Object> responseMap = res.getBody();
            String imageUrl = (String) responseMap.get("url");
            System.out.println("My URL: " + imageUrl);
            m.addAttribute("imageUrl", imageUrl);
            return "openMe.jsp";

       
		

        
    }
}
