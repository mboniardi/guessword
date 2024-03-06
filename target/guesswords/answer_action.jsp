<%-- 
    Document   : answer_action.jsp
    Created on : 1 May 2023, 12:12:32
    Author     : mboniardi
--%>

<%@page import="org.boniardi.guesswords.elements.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Game game = (Game) session.getAttribute("game");
        if (game==null) response.sendRedirect("newTest.jsp");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Answer Action</title>
        <link rel="stylesheet" href="mycss.css" />
    </head>
    <body>
        <%
            boolean answerOK =false;
            String givenanswer="";
            if (request.getParameter("textanswer")!=null) {
              givenanswer=request.getParameter("textanswer");
              answerOK = game.isNextQuestionCorrectTextAnswer(givenanswer);
            } else {
            String answer = request.getParameter("submit");
            answerOK = game.isNextQuestionCorrectAnswer(answer);
            givenanswer=game.getNextQuestionAnswersById(answer);
            }
        %>        
        Hai tradotto <span class="boldtext"><%= game.getNextQuestionOriginal()%></span> <br>
        Con <span class="boldtext"><%= givenanswer%></span> - 
        <%
            if (answerOK) {
                game.increaseCorrectAnswer();
        %> 
        <span class="greenText">Risposta Corretta</span><br>
        <%} else {%> 
        <span class="redText">Risposta Sbagliata</span><br>
        <% } %>
        Possibili risposte corrette: <span class="boldtext"><%= game.getNextQuestionCorrectAnswerString()%></span><br>
        <%    if (game.isTestCompeted()) {%>
        ______________________________<br/>
        Grazie per aver partecipato!<br><!-- comment -->
        le risposte corrette sono state:<br> <span class="boldtext"><%= game.getNumberOfCorrectAnswer()%> / <%= game.getNextQuestion()+1%> - <%= game.getPercCorrect()%>%</span>
        <br><form method="post" action="newTest.jsp"><input type="submit" name="submit" value="Nuovo Test"></form>
            <% } else { %>
        Risposte giuste <%= game.getNumberOfCorrectAnswer()%> / <%= game.getNextQuestion()+1%> - <%= game.getPercCorrect()%>%<br>
        <br><form method="post" action="answer.jsp"><input type="submit" name="submit" value="Prossima domanda"></form>
            <% }
                game.increaseNextQuestion();%>
    </body>
</html>
