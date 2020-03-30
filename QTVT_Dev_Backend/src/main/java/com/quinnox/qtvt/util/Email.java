package com.quinnox.qtvt.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.quinnox.qtvt.model.Employee;

@Component("mailSender")
public class Email {


	@Autowired
	private JavaMailSender javaMailSender;

	@Async
public void sendRegistrationMail(String toEmail,String fromDate, String toDate,String employeeId,String employeeName, String skill,String submittedHours) {
		
		String startDate[]=fromDate.split("T");
		String endDate[]=toDate.split("T");
		MimeMessage message=javaMailSender.createMimeMessage();
		String content=EmailContent.emailContentSubmission();
        String cc[]= {"team_rmg@quinnox.com","geethak@quinnox.com"};
		content=content.replace("id", employeeId);
		content=content.replace("name", employeeName);
		content=content.replace("fromDate", startDate[0]);
		content=content.replace("toDate", endDate[0]);
		content=content.replace("techSkills", skill);
		content=content.replace("submittedHours", submittedHours);
		
		try {
			MimeMessageHelper mail= new MimeMessageHelper(message,true);
			mail.setFrom("qqtvt@quinnox.com");
			mail.setTo(toEmail);
			mail.setCc(cc);
			
			mail.setSubject("QTVT Form Details");
			mail.setText("Dear "+employeeName+",<br>" + 
					"On behalf of RMG team, thanks for clocking time in QTVT tool.<br>" + 
					"<br>" +
					"Your diligence, self-motivation to contribute additional working hours is a source of inspiration for the rest of the team. We are looking for possible project opportunities and update you shortly. Please find your voluntary record.<br>" + 
					"<br>"+"<br>"+content+ 
					"<br>" + 
					"<br>" + 
					"Best regards,<br>" + 
					"Team QTVT.",true);
			
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		javaMailSender.send(message);
		System.out.println("Done!!!");
		
	}

	@Async
public void sendAllocationMail(String toEmail,Date fromDate, Date toDate,Employee employee,String employeeName, String skill, String RMGComments, String assignedManager,String managerEmail) {
	
	Format formatter=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	String from=formatter.format(fromDate);
	String startDate[]=from.split("T");
	String to=formatter.format(toDate);
	String endDate[]=to.split("T");
	
	MimeMessage message=javaMailSender.createMimeMessage();
	String content=EmailContent.emailContent();
	content=content.replace("id",employee.getEmpId());
	content=content.replace("name", employeeName);
	content=content.replace("fromDate", startDate[0]);
	content=content.replace("toDate",endDate[0]);
	content=content.replace("techSkills", skill);
	content=content.replace("RMGComments", RMGComments);
	content=content.replace("assignedManager", assignedManager);
	
	try {
		MimeMessageHelper mail= new MimeMessageHelper(message,true);
		mail.setFrom("qqtvt@quinnox.com");
		mail.setTo(toEmail);
		mail.setCc(managerEmail);
		mail.setSubject("QTVT Allocation Details");
		mail.setText("Dear "+employeeName+",<br>" + 
				"On behalf of RMG team, thanks for clocking time in QTVT tool.<br>" + 
				"<br>" +
				"Your diligence, self-motivation to contribute additional working hours is a source of inspiration for the rest of the team. We are looking for possible project opportunities and update you shortly. Please find your voluntary record.<br>" + 
				"<br>"+"<br>"+
				content + "<br>"+"<br>"+
				"Best regards,<br>" + 
				"Team QTVT.",true);
		
		
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Sending mail");
	javaMailSender.send(message);
	System.out.println("Done!!!");
	
}
}
