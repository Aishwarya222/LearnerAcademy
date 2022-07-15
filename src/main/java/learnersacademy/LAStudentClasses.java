package learnersacademy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LAStudentClasses {

	@Id
	private int cid;
	private String cname;
	
	@OneToMany(mappedBy = "la")
	private List<LAStudents> st = new ArrayList<LAStudents>();


	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<LAStudents> getSt() {
		return st;
	}
	public void setSt(List<LAStudents> st) {
		this.st = st;
	}

	
	
	
}
