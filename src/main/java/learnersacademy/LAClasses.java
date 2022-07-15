package learnersacademy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LAClasses {

	@Id
	private int cid;
	private String cname;
	@ManyToOne
	private LATeachers lat;
	@OneToMany(mappedBy = "lacc")
	private List<LASubjects> las = new ArrayList<LASubjects>();
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
	public LATeachers getLat() {
		return lat;
	}
	public void setLat(LATeachers lat) {
		this.lat = lat;
	}
	public List<LASubjects> getLas() {
		return las;
	}
	public void setLas(List<LASubjects> las) {
		this.las = las;
	}
	
	
	
}
