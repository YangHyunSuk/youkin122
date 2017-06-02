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
		//Smtp 서버연결
		simpleEmail.setHostName("smtp.naver.com");
		simpleEmail.setSmtpPort(465);
		simpleEmail.setAuthentication("dbtjd122","$Youkin122");
		try {
			simpleEmail.setSSLOnConnect(true);
			simpleEmail.setStartTLSEnabled(true);
			simpleEmail.setCharset("utf-8");
		//받는사람설정		
		simpleEmail.addTo("dbtjd122@naver.com","양현석","utf-8");
		//보내는사람설정
		simpleEmail.setFrom("dbtjd122@naver.com","보낸사람","utf-8");
		//제목설정
		simpleEmail.setSubject("메일보내기");
		//내용
		simpleEmail.setMsg("의견");
		//보내가
		simpleEmail.send();
		request.getSession().setAttribute("message","보내기성공");
		}
		catch (Exception e) {
			request.setAttribute("message", "메일 보내기에 실패하셨습니다.");
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
				//연결시간제한 
					conn.setConnectTimeout(50);
					conn.setUseCaches(false);
					if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
						InputStreamReader isr = new InputStreamReader(conn.getInputStream());
						BufferedReader br = new BufferedReader(isr);
						while (true) {
							String line = br.readLine();
							//System.out.println(line);
						//line 에  addr 값 넣어주고  값이 없을시 break 	
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
				System.out.println("가져오기 실패:" + e.getMessage());
			}
			request.getSession().setAttribute("pasing", sb.toString());			
	 }
@Override
public void home2mail(HttpServletRequest request, HttpServletResponse response) {
	
	String from=request.getParameter("from");
	String tubject =request.getParameter("subject");
	String gmsg= request.getParameter("msg");
	
	
	
	SimpleEmail simpleEmail=new SimpleEmail();
	//Smtp 서버연결
	simpleEmail.setHostName("smtp.naver.com");
	simpleEmail.setSmtpPort(465);
	simpleEmail.setAuthentication("dbtjd122","$Youkin122");
	
	try {
		simpleEmail.setSSLOnConnect(true);
		simpleEmail.setStartTLSEnabled(true);
		simpleEmail.setCharset("utf-8");
	//받는사람설정		
	simpleEmail.addTo("dbtjd122@naver.com","양현석","utf-8");
	//보내는사람설정
	simpleEmail.setFrom(from);
	//제목설정
	simpleEmail.setSubject(tubject);
	//내용
	simpleEmail.setMsg(gmsg);
	//보내가
	simpleEmail.send();
	request.getSession().setAttribute("message","보내기성공");
	}
	catch (Exception e) {
		request.setAttribute("message", "메일 보내기에 실패하셨습니다.");
		e.printStackTrace();
	
	}
}
	
}	
	





