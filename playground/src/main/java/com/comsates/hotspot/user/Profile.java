/**
 * 
 */
package com.comsates.hotspot.user;

/**
 * @author Ibrahima Diarra
 *
 */
public enum Profile {

	BODJEL("bodjel", "bodjel-user"), WELTARE("weltare", "weltare-user"), KAIRA("kaira", "kaira-user");
	
	private String description;
	private String username;
	
	private Profile(String description, String username){
		this.description = description;
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public String getUsername() {
		return username;
	}

}
