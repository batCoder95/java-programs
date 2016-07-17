public class Employee implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Eid;
	private String name;
	private String post;
	private int Did;
	private int salary;
	
	Employee(int Eid, String name, String post, int Did, int salary){
		this.Eid = Eid;
		this.name = name;
		this.post = post;
		this.Did = Did;
		this.salary = salary;
	}
	
	public int getEid(){
		return this.Eid;
	}
	public String getName(){
		return this.name;
	}
	public String getPost(){
		return this.post;
	}
	public int getDid(){
		return this.Did;
	}
	public int getSalary(){
		return this.salary;
	}
}
