package learnersacademy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LAStudents {

	@Id
	private int rollno;
	private String sname;
	@OneToOne
	private LAClasses la;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public LAClasses getLa() {
		return la;
	}
	public void setLa(LAClasses la) {
		this.la = la;
	}
}
