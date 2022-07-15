package learnersacademy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity

public class LATeachers {

	@Id
	@GeneratedValue
	private int rid;
	private int tid;
	private String tname;
	@OneToMany(mappedBy = "lat")
	private List<LAClasses> lac = new ArrayList<LAClasses>();
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public List<LAClasses> getLac() {
		return lac;
	}
	public void setLac(List<LAClasses> lac) {
		this.lac = lac;
	}
}
