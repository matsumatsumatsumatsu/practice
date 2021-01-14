package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticateCommand extends HttpServlet{
  protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
    req.setCharacterEncoding("Windows-31J");

    String name=req.getParameter("name");
    String pass=req.getParameter("pass");

    if(name.equals("yahagi") && pass.equals("a")){
      HttpSession session=req.getSession();
      session.setAttribute("token","OK");
    }

    RequestDispatcher dis=req.getRequestDispatcher("/productinput");
    dis.forward(req,res);
  }
}
