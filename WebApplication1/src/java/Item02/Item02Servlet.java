/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item02;

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
@WebServlet(name = "Item02Servlet", urlPatterns = {"/Item02Servlet"})
public class Item02Servlet extends HttpServlet {

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
            int IndexValue = Integer.parseInt(request.getParameter("buttonPressed"));
            String nombre, NumeroCuenta;
            Double interes, Saldo;
            Transaccion oTransaccion;
            switch (IndexValue) {
                case 1:
                    nombre = request.getParameter("txtNombre");
                    NumeroCuenta = request.getParameter("txtCuenta");
                    interes = Double.parseDouble(request.getParameter("txtInteres"));
                    Saldo = Double.parseDouble(request.getParameter("txtSaldo"));
                    Singleton.CrearCuenta(nombre, NumeroCuenta, interes, Saldo);
                    response.sendRedirect("Item2.jsp");
                    break;
                case 2:
                    nombre = request.getParameter("txtNombre");
                    Singleton.oCuenta.AsignarNombre(nombre);
                    response.sendRedirect("Item2.jsp");
                    break;
                case 3:
                    NumeroCuenta = request.getParameter("txtCuenta");
                    Singleton.oCuenta.AsignarCuenta(NumeroCuenta);
                    response.sendRedirect("Item2.jsp");
                    break;
                case 4:
                    Saldo = Double.parseDouble(request.getParameter("txtSaldo"));
                    Singleton.oCuenta.Deposito(Saldo);
                    oTransaccion = new Transaccion(Singleton.oCuenta.ObtenerCuenta(),Singleton.oCuenta.EstadoCuenta()-Saldo,"Deposito", Saldo,Singleton.oCuenta.EstadoCuenta());
                    Singleton.oCuenta.transacciones.add(oTransaccion);
                    response.sendRedirect("Item2.jsp");
                    break;
                case 5:
                    Saldo = Double.parseDouble(request.getParameter("txtSaldo"));
                    int resp = Singleton.oCuenta.Retiro(Saldo);
                    if (resp==1) {
                        oTransaccion = new Transaccion(Singleton.oCuenta.ObtenerCuenta(),Singleton.oCuenta.EstadoCuenta()+Saldo,"Retiro", Saldo,Singleton.oCuenta.EstadoCuenta());
                        Singleton.oCuenta.transacciones.add(oTransaccion);
                    }
                    response.sendRedirect("Item2.jsp");
                    break;
                case 6:
                    interes = Double.parseDouble(request.getParameter("txtInteres"));
                    Singleton.oCuenta.AsignarInteres(interes);
                    response.sendRedirect("Item2.jsp");
                    break;
                case 7:
                    int tiempo = Integer.parseInt(request.getParameter("txtTiempo"));
                    Singleton.oCuenta.ObtenerInteresGanado(tiempo);
                    response.sendRedirect("Item2.jsp");
                    break;
            }
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
