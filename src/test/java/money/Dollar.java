package money;

public class Dollar {

	public int mount;
	
	public Dollar(int mount) {
		this.mount = mount;
	}

	public Dollar times(int multiplier) {
		return new Dollar(this.mount * multiplier);
	}

}
