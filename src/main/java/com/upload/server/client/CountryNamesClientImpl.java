package com.upload.server.client;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.upload.server.utils.Constants;

import reactor.core.publisher.Mono;

@Service
public class CountryNamesClientImpl implements CountryNamesClient {

	private WebClient client = WebClient.create();
	
	
	@Override
	public Mono<String> getCountryNames(String countryCode) {
		String api = Constants.CountryNames_URL+countryCode;
		
		System.out.println(countryCode);
		System.out.println(api);
		return client.get()
				.uri(api)
				.retrieve()
				.bodyToMono(MapType.class).map(
                        mapType -> {
                        	System.out.println(mapType.get("name").toString());
                            return mapType.get("name").toString();
                        }
                        
                );
		        
	
	}
	 public static class MapType extends HashMap<String, Object> {
	    }

}
