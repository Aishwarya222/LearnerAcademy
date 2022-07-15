package learnersacademy;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class LAServlet
 */
@WebServlet("/LAServlet")
public class LAServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cname1=null;
		LAClasses laclasses = new LAClasses();
		laclasses.setCid(Integer.parseInt(request.getParameter("classes1")));
		if(laclasses.getCid()==1)
		{
			cname1="Java";
		}
		else if(laclasses.getCid()==2)
		{
			cname1="Machine Learning";
		}
		else if(laclasses.getCid()==3)
		{
			cname1="Data Science";
		}
		else if(laclasses.getCid()==4)
		{
			cname1="Fundamentals of Programming";
		}
		else if(laclasses.getCid()==5)
		{
			cname1="GATE Computer science";
		}
		else if(laclasses.getCid()==6)
		{
			cname1="Cloud";
		}
		else if(laclasses.getCid()==7)
		{
			cname1="Databases";
		}
		else if(laclasses.getCid()==8)
		{
			cname1="Interview Preparation";
		}
		laclasses.setCname(cname1);
		

		LATeachers lateachers = new LATeachers();
		
		String tname=null;
		int tid=0;
		lateachers.setTid(Integer.parseInt(request.getParameter("teacher")));

		if(lateachers.getTid()==1)
		{
			tname="Aishwarya";
		}
		else if(lateachers.getTid()==2)
		{
		tname="Reena";
		}
		else if(lateachers.getTid()==3)
		{
		tname="Siddhant";
		}
		else if(lateachers.getTid()==4)
		{
		tname="Lata";
		}
		else if(lateachers.getTid()==5)
		{
		tname="Umesh";
		}
		lateachers.setTname(tname);	
		
		LASubjects lasubjects1 = new LASubjects();
		LASubjects lasubjects2 = new LASubjects();
		LASubjects lasubjects3 = new LASubjects();
		LASubjects lasubjects4 = new LASubjects();
		LASubjects lasubjects5 = new LASubjects();
		LASubjects lasubjects6 = new LASubjects();
		LASubjects lasubjects7 = new LASubjects();
		LASubjects lasubjects8 = new LASubjects();
		
		lateachers.getLac().add(laclasses);
		laclasses.setLat(lateachers);
		String[] checkbox;
		checkbox = request.getParameterValues("subject");
		

		
		Configuration con = new Configuration().configure("/hibernate/hibernate.cfg.xml").addAnnotatedClass(LAClasses.class).addAnnotatedClass(LASubjects.class).addAnnotatedClass(LATeachers.class);
		
		SessionFactory sf = con.buildSessionFactory();
				
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		for(int i = 0;i<checkbox.length;i++)
		{
			PrintWriter out = response.getWriter();
			out.println("top"+checkbox[i]);
			if(checkbox[i].equals("1"))
			{
				out.println(checkbox[i]);
				lasubjects1.setSid(1);
				lasubjects1.setSname("Core Java");
				laclasses.getLas().add(lasubjects1);
				lasubjects1.setLacc(laclasses);
			    session.save(lasubjects1);
			
			}
			else if(checkbox[i].equals("2"))
			{
				out.println(checkbox[i]);
				lasubjects2.setSid(2);
				lasubjects2.setSname("Advanced Java");
				laclasses.getLas().add(lasubjects2);
				lasubjects2.setLacc(laclasses);
			    session.save(lasubjects2);
				
			}
			else if(checkbox[i].equals("3"))
			{
			
				out.println(checkbox[i]);
				lasubjects3.setSid(3);
				lasubjects3.setSname("Enterprise Java");
				laclasses.getLas().add(lasubjects3);
				lasubjects3.setLacc(laclasses);
			    session.save(lasubjects3);
				
			}
			else if(checkbox[i].equals("4"))
			{
		
				lasubjects4.setSid(4);
				lasubjects4.setSname("AWS");
				laclasses.getLas().add(lasubjects4);
				lasubjects4.setLacc(laclasses);
			    session.save(lasubjects4);
			
			}
			else if(checkbox[i].equals("5"))
			{
		
				lasubjects5.setSid(5);
				lasubjects5.setSname("Azure");
				laclasses.getLas().add(lasubjects5);
				lasubjects5.setLacc(laclasses);
			    session.save(lasubjects5);
			
			}
			else if(checkbox[i].equals("6"))
			{
			
				lasubjects6.setSid(6);
				lasubjects6.setSname("Python");
				laclasses.getLas().add(lasubjects6);
				lasubjects6.setLacc(laclasses);
			    session.save(lasubjects6);
			
			}
			else if(checkbox[i].equals("7"))
			{
		
				lasubjects7.setSid(7);
				lasubjects7.setSname("MySQL");
				laclasses.getLas().add(lasubjects7);
				lasubjects7.setLacc(laclasses);
			    session.save(lasubjects7);
			}
			else if(checkbox[i].equals("8"))
			{
				lasubjects8.setSid(8);
				lasubjects8.setSname("Algo and DS");
				laclasses.getLas().add(lasubjects8);
				lasubjects8.setLacc(laclasses);
			    session.save(lasubjects8);
			}
		}
		

		session.save(laclasses);
		session.save(lateachers);
	
//	    session.save(lasubjects2);
//	    session.save(lasubjects3);
//	    session.save(lasubjects4);
//	    session.save(lasubjects5);
//	    session.save(lasubjects6);
//	    session.save(lasubjects7);
//	    session.save(lasubjects8);


		tx.commit();
	}



}
