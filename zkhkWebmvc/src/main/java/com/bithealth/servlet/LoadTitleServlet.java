package com.bithealth.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadTitleServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		 Properties prop = new Properties();
		 try {
			 InputStream in = getClass().getResourceAsStream("/title.properties"); 
			prop.load(in);
			for (Iterator iterator = prop.keySet().iterator(); iterator.hasNext();) {
				Object key = iterator.next();
				this.getServletContext().setAttribute(String.valueOf(key), prop.get(key));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
