package handlers;

import keys.NativeKeyboard;

public class ManageService {
	
	private NativeKeyboard keyboard;
	
	public ManageService() {
	// TODO Auto-generated constructor stub
		keyboard = new NativeKeyboard();
	}
	
	public NativeKeyboard getKeyboard() {
		return keyboard;
	}
}
