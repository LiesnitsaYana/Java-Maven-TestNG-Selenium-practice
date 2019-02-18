package task1;

public class Photocamera {

	private int id;
	private String model;
	private String type;

	public Photocamera(int id, String model, String type) {
		super();
		this.id = id;
		this.model = model;
		this.type = type;

	}

	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return("Photocamera [id=" + id + ", model=" + model + ", type=" + type + "]");
	}

}
