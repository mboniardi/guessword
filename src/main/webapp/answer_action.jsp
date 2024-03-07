<%-- Document : answer_action.jsp Created on : 1 May 2023, 12:12:32 Author : mboniardi --%>

    <%@page import="org.boniardi.guesswords.elements.Game" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>
            <% Game game=(Game) session.getAttribute("game"); if (game==null) response.sendRedirect("newTest.jsp"); %>

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
                    <% boolean answerOK=false; String givenanswer="" ; if (request.getParameter("textanswer")!=null) {
                        givenanswer=request.getParameter("textanswer");
                        answerOK=game.isNextQuestionCorrectTextAnswer(givenanswer); } else { String
                        answer=request.getParameter("submit"); answerOK=game.isNextQuestionCorrectAnswer(answer);
                        givenanswer=game.getNextQuestionAnswersById(answer); } %>


                        <div class="container" id="container1">
                            <div class="row centered-form">
                                <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title text-center">
                                                <% if (answerOK) { game.increaseCorrectAnswer(); %>
                                                    <span style="color: green">Risposta Corretta</span><br>
                                                    <%} else {%>
                                                        <span style="color: red">Risposta Sbagliata</span><br>
                                                        <% } %>
                                            </h3>
                                        </div>
                                        <div class="panel-body">
                                            <div class="form-group">
                                                Hai tradotto <strong>
                                                    <%= game.getNextQuestionOriginal()%>
                                                </strong>
                                                <br>
                                                Con <strong>
                                                    <%= givenanswer%>
                                                </strong>
                                            </div>
                                            <div class="form-group">
                                                Possibili risposte corrette: <strong>
                                                    <%= game.getNextQuestionCorrectAnswerString()%>
                                                </strong>
                                            </div>

                                            <% if (game.isTestCompeted()) { %>
                                            <div class="container" id="container2">    
                                                <div class="form-group">
                                                <strong>Grazie per aver partecipato!</strong>
                                                </div>
                                                <div class="form-group">
                                                    le risposte corrette sono state:<br>
                                                <strong>
                                                        <%= game.getNumberOfCorrectAnswer()%> / <%=
                                                                game.getNextQuestion()+1%> - <%= game.getPercCorrect()%>
                                                                    %
                                                                </strong>
                                                </div>
                                                <div class="form-group">
                                                    <form method="post" action="newTest.jsp"><input type="submit"
                                                            name="submit" value="Nuovo Test"></form>
                                                </div>
                                            </div>
                                                <% } else { %>
                                                    <div class="form-group">
                                                        Risposte giuste <%= game.getNumberOfCorrectAnswer()%> / <%=
                                                                game.getNextQuestion()+1%> - <%= game.getPercCorrect()%>
                                                                    %
                                                    </div>
                                                    <div class="form-group">
                                                        <form method="post" action="answer.jsp"><input type="submit"
                                                                name="submit" value="Prossima domanda"></form>
                                                    </div>
                                                    <% } game.increaseNextQuestion();%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <style>
                            #container1 {
                                background-color: #e2dada;
                            }

                            #container2 {
                                background-color: #96fe04;
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