package javaManageTest;

public class InfoSave {
	private static String publicid = null;
	
	private static String publicyears =null;
	
	public static String getPublicyears() {
		return publicyears;
	}
	public static void setPublicyears(String publicyears) {
		InfoSave.publicyears = publicyears;
	}
	public static String getPublicid() {
		return publicid;
	}
	public void setPublicid(String publicid) {
		this.publicid = publicid;
	}
}
