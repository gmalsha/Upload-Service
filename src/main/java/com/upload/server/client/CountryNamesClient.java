package com.upload.server.client;

import reactor.core.publisher.Mono;



public interface CountryNamesClient {

	public Mono<String> getCountryNames(String countryCode);

}
