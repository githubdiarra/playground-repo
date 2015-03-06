/**
 * 
 */
package com.comsates.hotspot.user;

/**
 * @author Ibrahima Diarra
 *
 */
public class UserToken {

	public String token;
	public String formattedToken;
	
	public UserToken(String token, String formattedToken) {
		this.token = token;
		this.formattedToken = formattedToken;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserToken)) {
			return false;
		}
		UserToken other = (UserToken) obj;
		if (token == null) {
			if (other.token != null) {
				return false;
			}
		} else if (!token.equals(other.token)) {
			return false;
		}
		return true;
	}
	
	
}
