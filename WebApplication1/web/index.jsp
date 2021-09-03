<%-- 
    Document   : index
    Created on : Aug 27, 2021, 9:01:35 AM
    Author     : bryan
--%>

<%@page import="Item01.clsRandomGame"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5 mb-5">
            <h1>Adivina el número!</h1>
            <%
                Item01.clsRandomGame item = new clsRandomGame();
                int number = item.GenerateRandomNumber();
            %>
            <span style="color: white"><%=number%></span>
            <br>
            <%
                if (clsRandomGame.result == 1) {
                    out.println("Felicidades, ha ganado");
                } else if (clsRandomGame.result == 0) {
                    out.println("El numero ingresado es demasiado alto");
                } else if (clsRandomGame.result == -1) {
                    out.println("El numero ingresado es demasiado bajo");
                } else if (clsRandomGame.result == -2) {
                    out.println("Se han acabado los intentos, la respuesta era: " + clsRandomGame.LastRandomNumber);
                }
            %>
            <form action="${pageContext.request.contextPath}/Item1Servlet" method="post ">
                <label> Intento #<%=clsRandomGame.intentos%> </label>
                <input type="number" max="1000" min="0" name="txtUserNumber" value="0" />
                <button class="btn btn-success" type="submit" name="Consultar">Validar</button>    
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
