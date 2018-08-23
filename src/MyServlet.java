
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:12000/logtest";
	static final String USER = "root";
	static final String PASS = "1234";
	    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		//mysql set up 
		Connection conn = null;
	    Statement stmt = null;
	     
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("****************************************************");
		System.out.print("Request received. Type = ");
		System.out.println(request.getMethod());
		System.out.println("****************************************************");
		if(request.getMethod() == "POST"){
			String title = "Account Info";
			String pas_wrd = new String(request.getParameter("password"));
			String cfm_pas_wrd = new String (request.getParameter("confirmpassword"));
			String usnme = new String(request.getParameter("username"));
			boolean flag_checkname = true;
			
		        try{
		            Class.forName(JDBC_DRIVER);
		            conn = DriverManager.getConnection(DB_URL,USER,PASS);
		        
		            stmt = conn.createStatement();
		            String sql;
		            PreparedStatement psql;
		            psql = conn.prepareStatement("insert into users(name, password)" + "values(?,?)");
		            psql.setString(1, usnme);
		            psql.setString(2, pas_wrd);
		            
		            
		            sql = "SELECT name, password FROM users";
		            ResultSet rs = stmt.executeQuery(sql);
		        
		            
		            while(rs.next()){
		                String name = rs.getString("name");
		                String password = rs.getString("password");
		                
		                if(usnme.equals(name)){
		                	flag_checkname = false;
		                	out.println("<!DOCTYPE html> \n" + "<html>" + "<head><title>" + title + "</title></head>\n" +
		        		            "<body bgcolor=\"#f0f0f0\">\n" +
		        		            "<h1 align=\"center\">" + "Username exist!" + "</h1>\n" +
		        		            "<center><a href='login.jsp' class='button'>Click here to Signup</a></center>" +
		        		            " <center><img src= https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1532326532189&di=ab5215351baeb0da26e59b30c723655a&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F2934349b033b5bb5bbd1cc903dd3d539b600bc5e.jpg></center>"+
		        		            "</body></html>");
		                }
		            }
		            if(flag_checkname){
		            	psql.executeUpdate();
		    			out.println("<!DOCTYPE html> \n" + "<html>" + "<head><title>" + title + "</title></head>\n" +
		    		            "<body bgcolor=\"#f0f0f0\">\n" +
		    		            "<h1 align=\"center\">" + title + "</h1>\n" +
		    		            "<ul>\n" +
		    		            "  <h4 align=\"center\">Username: "
		    		            + usnme +  "<br>" + 
		    		            "  <h4 align=\"center\">Password: "
		    		            + pas_wrd +  "<br>" + 
		    		            "</ul>\n" +
		    		            "<center><a href='The_real_login.jsp' class='button'>Click here to login</a></center>"
		    		            +
		    		            "</body></html>");
		            }
		            rs.close();
		            stmt.close();
		            conn.close();
		        }catch(SQLException se){
		            se.printStackTrace();
		        }catch(Exception e){
		            e.printStackTrace();
		        }finally{
		            try{
		                if(stmt!=null) stmt.close();
		            }catch(SQLException se2){
		            }
		            try{
		                if(conn!=null) conn.close();
		            }catch(SQLException se){
		                se.printStackTrace();
		            }
		        }
		       
		}
		else if(request.getMethod() == "GET"){
			String pas_wrd_login = new String(request.getParameter("password_login"));
			String usnme_login = new String(request.getParameter("username_login"));
			boolean flag = false;
		        try{
		            Class.forName(JDBC_DRIVER);
		            conn = DriverManager.getConnection(DB_URL,USER,PASS);
		        
		            stmt = conn.createStatement();
		            String sql; 
		            sql = "SELECT name, password FROM users";
		            ResultSet rs = stmt.executeQuery(sql);
		            
		            while(rs.next()){
		            	 String name = rs.getString("name");
			             String password = rs.getString("password");
			             
			             System.out.println(name + "  " + usnme_login +"  " +  (usnme_login.equals(name)));
			             System.out.println(password+ "  " + pas_wrd_login +  "  " + (pas_wrd_login.equals(password)));
		                if(usnme_login.equals(name)){
		                	if(pas_wrd_login.equals(password))
		                		flag = true;
		                }
		            }
		            rs.close();
		            stmt.close();
		            conn.close();
		        }catch(SQLException se){
		            // 处理 JDBC 错误
		            se.printStackTrace();
		        }catch(Exception e){
		            // 处理 Class.forName 错误
		            e.printStackTrace();
		        }finally{
		            // 关闭资源
		            try{
		                if(stmt!=null) stmt.close();
		            }catch(SQLException se2){
		            }// 什么都不做
		            try{
		                if(conn!=null) conn.close();
		            }catch(SQLException se){
		                se.printStackTrace();
		            }
		        }
		        if(flag){
		        	String title = "Log In Success";
		        	out.println("<!DOCTYPE html> \n" + "<html>" + "<head><title>" + title + "</title></head>\n" +
		            "<body bgcolor=\"#f0f0f0\">\n" +
		            "<h1 align=\"center\">" + title + "</h1>\n" + "</body></html>");
		        }
		        else{
		        	String title = "Log In Failed";
		        	out.println("<!DOCTYPE html> \n" + "<html>" + "<head><title>" + title + "</title></head>\n" +
		            "<body bgcolor=\"#f0f0f0\">\n" +
		            "<h1 align=\"center\">" + title + "</h1>\n" +
		            "<center><a href='The_real_login.jsp' class='button'>Click here to login</a></center>"+
		            "<center><a href='login.jsp' class='button'>Click here to signup</a></center>"+
		            " <center><img src= https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1160684446,1076555601&fm=27&gp=0.jpg></center>"+
		            "</body></html>");
		        }
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
