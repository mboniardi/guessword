<%-- 
    Document   : newTest
    Created on : 1 May 2023, 11:14:54
    Author     : mboniardi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NewTest</title>
        <link rel="stylesheet" href="mycss.css" />
        <style>
            td {
                vertical-align: top;
            }
        </style>
    </head>
    <body>
        <h3>Seleziona numero domande e <br>livello di difficolta'</h3>
        <table>
            <form action="answer.jsp" method="post">
                <input type="hidden" name="pgtype" value="restart">
                <tr><td>Numero delle<br>domande:</td><td>&nbsp;<select name="numberOfQuestions">
                            <option value="5">5</option>
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                        </select></td></tr>
                <tr><td>Difficolta'</td><td>&nbsp;<select name="level">
                            <option value="0">Facile (4 possibili risposte)</option>
                            <option value="1">Medio (8 possibili risposte)</option>
                            <option value="2">Difficile (testo libero)</option>
                        </select></td></tr>
                <tr><td></td><td>&nbsp;<br>&nbsp;<input type="submit" name="submit"></td></tr>
            </form>            
        </table>        
    </body>
</html>
