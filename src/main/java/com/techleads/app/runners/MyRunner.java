package com.techleads.app.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.techleads.app.model.AndroidInfo;
import com.techleads.app.model.DynamicLinkInfo;
import com.techleads.app.model.IosInfo;
import com.techleads.app.model.MyRequest;
import com.techleads.app.model.Suffix;

@Component
public class MyRunner implements CommandLineRunner {

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=AIzaSyBfMh3zdCSjvfOjXAlMsNeTZEda0_QrE_0";

	@Override
	public void run(String... args) throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		MyRequest myReq = setRequestData();

		HttpEntity<MyRequest> requestEntity = new HttpEntity<>(myReq, headers);
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
		HttpStatus statusCode = exchange.getStatusCode();
		if (statusCode != null) {
			String body = exchange.getBody();
			System.out.println(body);

			ObjectNode node = new ObjectMapper().readValue(body, ObjectNode.class);

			if (node.has("shortLink")) {
				JsonNode jsonNode = node.get("shortLink");
				System.out.println(jsonNode.asText());
			}
			if (node.has("previewLink")) {
				JsonNode jsonNode = node.get("previewLink");
				System.out.println(jsonNode.asText());
			}

		}

	}

	private MyRequest setRequestData() {
		MyRequest myReq = new MyRequest();

		DynamicLinkInfo dynamicLinkInfo = new DynamicLinkInfo();
		Suffix suffix = new Suffix();
		IosInfo iosInfo = new IosInfo();

		AndroidInfo adInfo = new AndroidInfo();
		adInfo.setAndroidPackageName("com.test.app");
		dynamicLinkInfo.setAndroidInfo(adInfo);
		dynamicLinkInfo.setLink("https://play.google.com/store/apps/details?id=com.accurate.live.weather.forecast.pro");
		dynamicLinkInfo.setDomainUriPrefix("https://mycustom.page.link");

		iosInfo.setIosBundleId("com.test.app");

		suffix.setOption("SHORT");

		myReq.setDynamicLinkInfo(dynamicLinkInfo);
		myReq.setSuffix(suffix);
		return myReq;
	}

}
