/**
 * 
 */
package com.comsates.hotspot.user;

import java.util.Date;

/**
 * @author Ibrahima Diarra
 *
 */
public class Batch {

	private Date date;
	private String prefix;
	private Profile profile;
	private Integer tokenCount;
	
	public Batch(String prefix){
		this(prefix, null);
	}
	
	public Batch(String prefix, Profile profile){
		this(prefix, profile, new Date(), null);
	}
	
	public Batch(String prefix, Profile profile, Date date, Integer tokenCount){
		this.prefix = prefix;
		this.profile = profile;
		this.date = date;
		this.tokenCount = tokenCount;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Integer getTokenCount() {
		return tokenCount;
	}

	public void setTokenCount(Integer tokenCount) {
		this.tokenCount = tokenCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
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
		if (!(obj instanceof Batch)) {
			return false;
		}
		Batch other = (Batch) obj;
		if (prefix == null) {
			if (other.prefix != null) {
				return false;
			}
		} else if (!prefix.equals(other.prefix)) {
			return false;
		}
		return true;
	}

	public String toCsv() {
		return new StringBuilder().append(profile).append(",").append(prefix)
				.append(",").append(date.getTime()).append(",")
				.append(tokenCount).append(",").append(date).toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Batch [");
		if (profile != null)
			builder.append("profile=").append(profile).append(", ");
		if (prefix != null)
			builder.append("prefix=").append(prefix).append(", ");
		builder.append("tokenCount=").append(tokenCount).append(", ");
		if (date != null)
			builder.append("date=").append(date);
		builder.append("]");
		return builder.toString();
	}
}
