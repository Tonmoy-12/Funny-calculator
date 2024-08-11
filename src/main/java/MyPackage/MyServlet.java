package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String[] jokes = {
	        "Why do Java developers wear glasses? Because they don't C#!",
	        "I told my computer I needed a break, and now it won't stop sending me Kit Kat bars.",
	        "Why don't programmers like nature? It has too many bugs.",
	        "How many programmers does it take to change a light bulb? None, it's a hardware problem."
	    };
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public MyServlet() {
	        super();
	    }

	    /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String str1 = request.getParameter("num1");
	        String str2 = request.getParameter("num2");
	        String operation = request.getParameter("bt1");
	        
	        int a = Integer.parseInt(str1);
	        int b = Integer.parseInt(str2);
	        
	        int result;
	        
	        switch (operation) {
	            case "1":
	                result = a + b;
	                break;
	            case "2":
	                result = a - b;
	                break;
	            case "3":
	                result = a * b;
	                break;
	            default:
	                result = a / b;
	                break;
	        }
	        
	        int randomIndex = (int) (Math.random() * jokes.length);
	        String randomJoke = jokes[randomIndex];
	        
	        response.sendRedirect("NewFile.jsp?ans=" + result + "&joke=" + randomJoke);
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	}