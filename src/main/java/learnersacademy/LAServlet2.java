package learnersacademy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Servlet implementation class LAServlet2
 */
@WebServlet("/LAServlet2")
public class LAServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname2=null;
		LAStudents stud= new LAStudents();
		stud.setRollno(Integer.parseInt(request.getParameter("rollno")));
		stud.setSname(request.getParameter("name"));
		int cid= (Integer.parseInt(request.getParameter("classes2")));
		if(cid==1)
		{
			cname2="Java";
		}
		else if(cid==2)
		{
			cname2="Machine Learning";
		}
		else if(cid==3)
		{
			cname2="Data Science";
		}
		else if(cid==4)
		{
			cname2="Fundamentals of Programming";
		}
		else if(cid==5)
		{
			cname2="GATE Computer science";
		}
		else if(cid==6)
		{
			cname2="Cloud";
		}
		else if(cid==7)
		{
			cname2="Databases";
		}
		else if(cid==8)
		{
			cname2="Interview Preparation";
		}
		LAClasses cc = new LAClasses();
		cc.setCid(cid);
		cc.setCname(cname2);
		cc.setLas(null);
		cc.setLat(null);
		stud.setLa(cc);
	Configuration con = new Configuration().configure("/hibernate/hibernate.cfg.xml").addAnnotatedClass(LAStudents.class).addAnnotatedClass(LAClasses.class).addAnnotatedClass(LATeachers.class).addAnnotatedClass(LASubjects.class);
		
		SessionFactory sf = con.buildSessionFactory();
				
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
				
		session.save(cc);
		session.save(stud);


		tx.commit();

	}



}
