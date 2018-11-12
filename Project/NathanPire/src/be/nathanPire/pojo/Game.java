package be.nathanPire.pojo;

public class Game {
	private int ID;
	private String name;
	private String developers;
	private String editors;
	private float unit;
	//GET && SET
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID=ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDevelopers() {
		return developers;
	}
	public void setDevelopers(String developers) {
		this.developers=developers;
	}
	public String getEditors() {
		return editors;
	}
	public void setEditors(String editors) {
		this.editors=editors;
	}
	public float getUnit() {
		return unit;
	}
	//Constructor
	public Game(int ID,String name,String developers,String editors,float unit) {
		this.ID=ID;
		this.name=name;
		this.developers=developers;
		this.editors=editors;
		this.unit=unit;
	}
}
