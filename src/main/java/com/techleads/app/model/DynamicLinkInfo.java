package com.techleads.app.model;

public class DynamicLinkInfo {
	private String domainUriPrefix;
	private String link;
	private AndroidInfo androidInfo;
	private IosInfo iosInfo;
	public String getDomainUriPrefix() {
		return domainUriPrefix;
	}
	public void setDomainUriPrefix(String domainUriPrefix) {
		this.domainUriPrefix = domainUriPrefix;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public AndroidInfo getAndroidInfo() {
		return androidInfo;
	}
	public void setAndroidInfo(AndroidInfo androidInfo) {
		this.androidInfo = androidInfo;
	}
	public IosInfo getIosInfo() {
		return iosInfo;
	}
	public void setIosInfo(IosInfo iosInfo) {
		this.iosInfo = iosInfo;
	}
	@Override
	public String toString() {
		return "DynamicLinkInfo [domainUriPrefix=" + domainUriPrefix + ", link=" + link + ", androidInfo=" + androidInfo
				+ ", iosInfo=" + iosInfo + "]";
	}
	

}
