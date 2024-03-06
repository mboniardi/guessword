<%-- 
    Document   : answer.jsp
    Created on : 1 May 2023, 11:25:42
    Author     : mboniardi
--%>

<%@page import="org.boniardi.guesswords.elements.Game"%>
<%@page import="org.boniardi.guesswords.helper.GameHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (request.getParameter("pgtype") != null && request.getParameter("pgtype").equals("restart")) {
        session.setAttribute("game", GameHelper.createNewGame(request.getParameter("numberOfQuestions"), request.getParameter("level")));
    }

    Game game = (Game) session.getAttribute("game");
    if (game==null) response.sendRedirect("newTest.jsp");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Answer</title>
        <link rel="stylesheet" href="mycss.css" />
    </head>
    <body>
        Domanda numero <%= game.getNextQuestion() + 1%> <br><!-- comment -->
        <table>
            <form action="answer_action.jsp" method="post">
                <tr>
                    <td colspan="2">Traduci: &nbsp; <span class="boldtext"><%= game.getNextQuestionOriginal()%></span></td>
                </tr>
                <tr>
                    <td colspan="2">______________________________</td>
                </tr>
                <% if (game.getGameDefiniton().getLevelOfComplexity()!=2){
                    int id = 0;
                    for (String elem : game.getNextQuestionPossibleAnswers()) {%>
                <tr><td><%= elem%></td><td>&nbsp;<input type="submit" name="submit" value="<%= id%>"></td></tr> <%
                        ++id;
                    }} else { %>
                <tr><td colspan="2">Inserisci la traduzione</td></tr> 
                <%-- <tr><td colspan="2"><%= game.getNextQuestionCorrectAnswerStringMasked()%></td></tr> --%>
                <tr><td colspan="2"><input type="text" name="textanswer"></td></tr> 
                <tr><td colspan="2"><input type="submit" name="submit" value="invia"></td></tr> 
              <% }%>
            </form>
        </table>
    </body>
</html>
