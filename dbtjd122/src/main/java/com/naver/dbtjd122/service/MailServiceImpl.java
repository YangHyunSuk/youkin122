package com.naver.dbtjd122.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dbtjd122.dao.MailDAO;
import com.naver.dbtjd122.domain.BoardVO;
import com.naver.dbtjd122.domain.MailVO;
@Service
public class MailServiceImpl implements MailService {
@Autowired
public MailDAO maiDAO;
	@Override
	public void sendMail(HttpServletRequest request, HttpServletResponse response) {

		SimpleEmail simpleEmail=new SimpleEmail();
		//Smtp ?λ²μ°κ²?
		simpleEmail.setHostName("smtp.naver.com");
		simpleEmail.setSmtpPort(465);
		simpleEmail.setAuthentication("dbtjd122","$Youkin122");
		try {
			simpleEmail.setSSLOnConnect(true);
			simpleEmail.setStartTLSEnabled(true);
			simpleEmail.setCharset("utf-8");
		//λ°λ?¬??€? 		
		simpleEmail.addTo("dbtjd122@naver.com","???","utf-8");
		//λ³΄λ΄??¬??€? 
		simpleEmail.setFrom("dbtjd122@naver.com","λ³΄λΈ?¬?","utf-8");
		//? λͺ©μ€? 
		simpleEmail.setSubject("λ©μΌλ³΄λ΄κΈ?");
		//?΄?©
		simpleEmail.setMsg("?κ²?");
		//λ³΄λ΄κ°?
		simpleEmail.send();
		request.getSession().setAttribute("message","λ³΄λ΄κΈ°μ±κ³?");
		}
		catch (Exception e) {
			request.setAttribute("message", "λ©μΌ λ³΄λ΄κΈ°μ ?€?¨??¨?΅??€.");
			e.printStackTrace();
		
		}
	}
@Override
public void download(HttpServletRequest request, HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		try {
		URL url = new URL(request.getParameter("addr"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				if (conn != null) {
				//?°κ²°μκ°μ ? 
					conn.setConnectTimeout(50);
					conn.setUseCaches(false);
					if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
						InputStreamReader isr = new InputStreamReader(conn.getInputStream());
						BufferedReader br = new BufferedReader(isr);
						while (true) {
							String line = br.readLine();
							//System.out.println(line);
						//line ?  addr κ°? ?£?΄μ£Όκ³   κ°μ΄ ??? break 	
							if (line == null) {
								break;
							}
							sb.append(line + "\n");
							System.out.println(line);
						}
						br.close();
						conn.disconnect();
					}
				}
			} catch (Exception e) {
				System.out.println("κ°?? Έ?€κΈ? ?€?¨:" + e.getMessage());
			}
			request.getSession().setAttribute("pasing", sb.toString());			
	 }
@Override
public void home2mail(HttpServletRequest request, HttpServletResponse response) {
	
	String from=request.getParameter("from");
	String tubject =request.getParameter("subject");
	String gmsg= request.getParameter("msg");
	
	
	
	SimpleEmail simpleEmail=new SimpleEmail();
	//Smtp ?λ²μ°κ²?
	simpleEmail.setHostName("smtp.naver.com");
	simpleEmail.setSmtpPort(465);
	simpleEmail.setAuthentication("dbtjd122","$Youkin122");
	
	try {
		simpleEmail.setSSLOnConnect(true);
		simpleEmail.setStartTLSEnabled(true);
		simpleEmail.setCharset("utf-8");
	//λ°λ?¬??€? 		
	simpleEmail.addTo("dbtjd122@naver.com","???","utf-8");
	//λ³΄λ΄??¬??€? 
	simpleEmail.setFrom(from);
	//? λͺ©μ€? 
	simpleEmail.setSubject(tubject);
	//?΄?©
	simpleEmail.setMsg(gmsg);
	//λ³΄λ΄κ°?
	simpleEmail.send();
	request.getSession().setAttribute("message","λ³΄λ΄κΈ°μ±κ³?");
	}
	catch (Exception e) {
		request.setAttribute("message", "λ©μΌ λ³΄λ΄κΈ°μ ?€?¨??¨?΅??€.");
		e.printStackTrace();
	
	}
}
	
}	
	





