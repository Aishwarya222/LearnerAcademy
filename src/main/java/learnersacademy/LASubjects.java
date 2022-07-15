package learnersacademy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class LASubjects {

	@Id
	@GeneratedValue
	private int sid;
	private String sname;
	@ManyToOne
	private LAClasses lacc;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public LAClasses getLacc() {
		return lacc;
	}
	public void setLacc(LAClasses lacc) {
		this.lacc = lacc;
	}
	
	
 	
}
