package com.spring.JDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CandidateSampleApp {
		   public static void main(String[] args) {
		      ApplicationContext context = new ClassPathXmlApplicationContext("spring_jdbc.xml");

		      CandidateJDBCTemplate candidateJDBCTemplate = (CandidateJDBCTemplate)context.getBean("candidateJDBCTemplate");
		      
		      /*System.out.println("creating record" );
		      candidateJDBCTemplate.create("Venki", "test@gmail.com");
		      candidateJDBCTemplate.create("Raja", "test1@gmail.com");
		      candidateJDBCTemplate.create("Srinu", "tes2@gmail.com");*/

		      System.out.println("listing records" );
		      List<Candidate> candidates = candidateJDBCTemplate.listCandidates();
		      
		      for (Candidate record : candidates) {
		         System.out.print("Name : " + record.getName() );
		         System.out.println("Email : " + record.getEmail());
		      } 
		      
		      //ResultSetExtractor 
		      List<Candidate> candidatesinfo= candidateJDBCTemplate.listCandidatesInfo();
		      for (Candidate candidate : candidatesinfo) {
		    	  System.out.print("Candidate Name : " + candidate.getName() );
			      System.out.println(" Candidate Email : " + candidate.getEmail());
			}
		      
		      /*candidateJDBCTemplate.update("Venki updated", "test@gmail.com");
		      candidateJDBCTemplate.delete("test@gmail.com");*/
		      
		      candidateJDBCTemplate.insertCandidateInfoByPreparedStatement(new Candidate(1, "Venki", "venki@gmail.com"));
		      
		   }
}
