package com.conga.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.restassured.RestAssured;

public class ApiBase {

	public static Properties apiProp;

	public ApiBase() {
		// Code to set config.property file read
		try {
			apiProp = new Properties();
			FileInputStream ip1 = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\conga\\config\\api.properties");
			apiProp.load(ip1);
		} catch (IOException e) {
			System.out.println("Fail to work");
			e.printStackTrace();
		}

	}

	//Initializing BaseURI for API
	public static void apiIntialize() {
		RestAssured.baseURI = apiProp.getProperty("uri");
	}

	//Method for defining Post body data
	public static Map<String, Object> postBodyData(Object exn_id, Object stationname, Object latitudevalue,
			Object longitudevalue, Object altitudevalue) {

		Map<String, Object> bodyParam = new HashMap<>();
		bodyParam.put("external_id", exn_id);
		bodyParam.put("name", stationname);
		bodyParam.put("latitude", latitudevalue);
		bodyParam.put("longitude", longitudevalue);
		bodyParam.put("altitude", altitudevalue);
		return bodyParam;
	}

}
