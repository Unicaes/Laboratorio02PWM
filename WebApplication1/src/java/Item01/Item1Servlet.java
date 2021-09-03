/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bryan
 */
@WebServlet(name = "Item1Servlet", urlPatterns = {"/Item1Servlet"})
public class Item1Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            clsRandomGame obj = new clsRandomGame();
            int tryout = Integer.parseInt(request.getParameter("txtUserNumber"));
            int indexNumber = Integer.parseInt(request.getParameter("Consultar"));

            if (indexNumber == 0) {
                int resp = obj.CheckRandomNumber(tryout);
                clsRandomGame.result = resp;
//            out.println(tryout+"<br>");
//            out.println(obj.GenerateRandomNumber()+"<br>");
                if (resp == 1) {
                    out.println("Felicidades, ha ganado");
                    obj.ResetRandomNumber();
                } else if (resp == 0) {
                    out.println("El numero ingresado es demasiado alto");
                } else if (resp == -1) {
                    out.println("El numero ingresado es demasiado bajo");
                } else {
                    out.println("Se han acabado los intentos, la respuesta era: " + obj.GenerateRandomNumber());
                    obj.ResetRandomNumber();
                }
            } else {
                obj.Surrender();
            }

            response.sendRedirect("index.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
