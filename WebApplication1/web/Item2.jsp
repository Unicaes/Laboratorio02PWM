<%-- 
    Document   : Item2
    Created on : Sep 1, 2021, 9:57:15 AM
    Author     : bryan
--%>

<%@page import="Item02.clsCuenta"%>
<%@page import="Item02.Singleton"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String Nombre = "", Cuenta = "";
    Double Saldo = 0.0, Interes = 0.0;
    clsCuenta oCuenta = Singleton.GetCuenta();
    boolean bandera = false;
    if (oCuenta != null) {
        Nombre = oCuenta.ObtenerNombre();
        Cuenta = oCuenta.ObtenerCuenta();
        Interes = oCuenta.ObtenerInteres();
        Saldo = oCuenta.EstadoCuenta();
        bandera = true;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body style="background-color: cadetblue">
        <div class="container rounded mt-5 mb-5 p-5" style="background-color: white">
            <h1 class="text-center">Interes Simple</h1>
            <form action="${pageContext.request.contextPath}/Item02Servlet" method="post">
                <div class="row">
                    <label  class="col-4">Nombre:</label>
                    <input class="col-4" type="text" name="txtNombre" placeholder="Ingrese el nombre" value="<%=Nombre%>">
                    <button class="col-4 btn btn-info" type="submit" name="buttonPressed" value="2">Modificar nombre</button>

                </div>
                <br>
                <div class="row">
                    <Label class="col-4">Cuenta:</Label>
                    <input class="col-4" type="text" name="txtCuenta" placeholder="Ingrese la cuenta" value=<%=Cuenta%>>
                    <button class="col-4  btn btn-info" type="submit" name="buttonPressed" value="3">Modificar Cuenta</button>

                </div>
                <br>    
                <div class="row">
                    <Label class="col-3">Saldo:</Label>
                    <input class="col-2" type="number" min="1" value="1" name="txtSaldo" placeholder="Ingrese el saldo inicial" value=<%=Saldo%>>
                    <div class="col-1"></div>
                    <button class="col-2 btn btn-info" type="submit" name="buttonPressed" value="4">Depositar</button>
                     <div class="col-1"></div>
                    <button class="col-3 btn btn-info" type="submit" name="buttonPressed" value="5">Retirar</button>

                </div>
                <br>
                <div class="row">
                    <label class="col-4">Interes:</label>
                    <input class="col-4" type="number" min="0.01" value="0.01" step=".01" name="txtInteres" placeholder="Ingrese el interes" value=<%=Interes%>>
                    <button class="col-4  btn btn-info" type="submit" name="buttonPressed" value="6">Modificar Interes</button>

                </div>
                <br>
                <div class="row">
                    <label class="col-4">Tiempo en meses</label>
                    <input class="col-4" type="number" name="txtTiempo">
                    <button class="col-4  btn btn-info" type="submit" name="buttonPressed" value="7">Calcular Interes</button>

                </div>
                <br>
                <button class=" btn btn-success" type="submit" name="buttonPressed" value="1" >Registrar</button> 
            </form>
            <br>
            <label><% if (Singleton.oCuenta != null) {
                    if (Singleton.oCuenta.UltimoInteresCalculado != -5) {
                        out.println("El interes es: $" + Singleton.oCuenta.UltimoInteresCalculado);
                    }
                }
                %></label>
            <table class="table">
                <thead>
                    <tr>
                        <th>Numero Cuenta</th>
                        <th>Saldo Antiguo</th>
                        <th>Accion</th>
                        <th>Monto</th>
                        <th>Saldo Nuevo</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (oCuenta != null) {
                            for (int i = oCuenta.transacciones.size() - 1; i >= 0; i--) {
                                out.println("<tr>");
                                out.println("<td>" + oCuenta.transacciones.get(i).NumeroCuenta + "</td>");
                                out.println("<td>" + oCuenta.transacciones.get(i).SaldoAntiguo + "</td>");
                                out.println("<td>" + oCuenta.transacciones.get(i).action + "</td>");
                                out.println("<td>" + oCuenta.transacciones.get(i).monto + "</td>");
                                out.println("<td>" + oCuenta.transacciones.get(i).NuevoSaldo + "</td>");
                                out.println("</tr>");
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body> 
</html>
