

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class addprofile extends HttpServlet {

   
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
         PrintWriter out = response.getWriter();
         String regno=request.getParameter("regno");
         String name=request.getParameter("name");
         String gender=request.getParameter("gender");
         String email=request.getParameter("email");
         String dob=request.getParameter("dob");
         String phone=request.getParameter("phoneno");
         String cgpa=request.getParameter("cgpa");
         Connection conn ;
         String url = "jdbc:mysql://localhost:3306/";
         String dbName = "portal";
        
         String driver = "com.mysql.jdbc.Driver";
	 String userName = "root"; 
         String password = "";
                 
         String n="";
         try {
            
           
            
            Socket skt=new Socket("127.0.0.1",8084);
            PrintWriter out1 = new PrintWriter(skt.getOutputStream(), true);
            BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));
            
          
            while(!in.ready()){}
            out.println(in.readLine());
            out.println("\n");
            
            
           
           try{
                  Class.forName(driver).newInstance();
                  conn = DriverManager.getConnection(url+dbName,userName,password);
                  Statement st = conn.createStatement();
                  String sql="insert into student values('"+regno+"','"+name+"','"+gender+"','"+email+"','"+dob+"','"+phone+"','"+cgpa+"','"+n+"')";
                   st.executeUpdate(sql);
                  
                  }
            catch(Exception e){
                  out.println("error in server"+e);
              }
            
            out.println("\n\n");
            out.println("Database Updated Successfully for ");
            out.println(regno); 
            in.close();
            
            
            
            
        } 
         catch(Exception e){
            out.println("eroor is "+e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
