package com.mapquestApi.traffic.geocoding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Locations item.
 */
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

	/**
	 * Get display lat lng display lat lng.
	 *
	 * @return the display lat lng
	 */
	public DisplayLatLng getDisplayLatLng(){
		return displayLatLng;
	}

	/**
	 * Get unknown input string.
	 *
	 * @return the string
	 */
	public String getUnknownInput(){
		return unknownInput;
	}

	/**
	 * Get postal code string.
	 *
	 * @return the string
	 */
	public String getPostalCode(){
		return postalCode;
	}

	/**
	 * Get street string.
	 *
	 * @return the string
	 */
	public String getStreet(){
		return street;
	}

	/**
	 * Get lat lng lat lng.
	 *
	 * @return the lat lng
	 */
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