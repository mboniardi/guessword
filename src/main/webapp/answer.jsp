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
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    
        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <title>Answer</title>
    </head>
    <body>
        <!--div class="container" -->
             <div class="container" id="container1">
                    <div class="row centered-form">
                        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title text-center">Domanda Numero <%= game.getNextQuestion() + 1%> / <%= game.getNumberOfQuestions() %></h3>
                                </div>
                                <div class="panel-body">
                                    <form action="answer_action.jsp" method="post" role="form">
                                        <div class="form-group">
                                            Traduci: &nbsp; <strong><%= game.getNextQuestionOriginal()%></strong>
                                        </div>
                                        
                                        <% if (game.getGameDefiniton().getLevelOfComplexity()!=2){
                                            int id = 0;
                                            for (String elem : game.getNextQuestionPossibleAnswers()) {%>
                                                <div class="form-group">
                                                    <input type="submit" name="submit" value="<%= id%>">&nbsp; <%= elem%>
                                                </div> <%
                                                ++id;
                                            }} else { %>
                                        <tr><td colspan="2">Inserisci la traduzione</td></tr> 
                                        <div class="form-group">
                                            Inserisci la traduzione: <%= game.getNextQuestionCorrectAnswerStringMasked()%>
                                        </div>
                                        
                                        <div class="form-group"><input type="text" name="textanswer"></div>
                                        <div class="form-group"><input type="submit" name="submit" value="invia"></div>
                                      <% }%>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            
            <style>
            #container1 {
                background-color: #e2dada;
            }
            
            .centered-form {
                margin-top: 120px;
                margin-bottom: 120px;
            }
            
            .centered-form .panel {
                background: rgba(255, 255, 255, 0.8);
                box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
            }
            .form-group {
                margin-bottom: 15px;
                margin-top: 15px;
            }
            </style>
            <!--/div -->
    </body>
</html>
