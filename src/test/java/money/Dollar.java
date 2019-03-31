package money;

public class Dollar {

	public int mount;
	
	public Dollar(int mount) {
		this.mount = mount;
	}

	public void times(int multiplier) {
		this.mount *= multiplier;
	}

}
