package handlers;

public class KeyStorage {
	
	private int keyCode;
	private boolean isPressed;
	private long systemsTimePressedMillis;
	public KeyStorage(int keyCode, boolean isPressed, 
			long systemsTimePressedMillis) {
		this.keyCode = keyCode;
		this.isPressed = isPressed;
		this.systemsTimePressedMillis = systemsTimePressedMillis;
	}
	public int getKeyCode() {
		return keyCode;
	}
	public boolean isPressed() {
		return isPressed;
	}
	public long getSystemsTimePressedMillis() {
		return systemsTimePressedMillis;
	}
	@Override
	public String toString() {
		return "KeyStorage [keyCode=" + keyCode + ", isPressed=" + isPressed + ", systemsTimePressedMillis="
				+ systemsTimePressedMillis + "]";
	}
	
	
	
}
