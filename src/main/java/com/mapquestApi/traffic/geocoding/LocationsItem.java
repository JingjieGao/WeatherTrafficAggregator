package com.mapquestApi.traffic.geocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationsItem{

	@JsonProperty("displayLatLng")
	private DisplayLatLng displayLatLng;

	@JsonProperty("unknownInput")
	private String unknownInput;

	@JsonProperty("postalCode")
	private String postalCode;

	@JsonProperty("street")
	private String street;

	@JsonProperty("latLng")
	private LatLng latLng;

	public DisplayLatLng getDisplayLatLng(){
		return displayLatLng;
	}

	public String getUnknownInput(){
		return unknownInput;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public String getStreet(){
		return street;
	}

	public LatLng getLatLng(){
		return latLng;
	}

	@Override
 	public String toString(){
		return
			"LocationsItem{" +
			",latLng = '" + latLng + '\'' +
			",unknownInput = '" + unknownInput + '\'' +
			",postalCode = '" + postalCode + '\'' +
			",street = '" + street + '\'' +
			",displayLatLng = '" + displayLatLng + '\'' +
			"}";
		}
}