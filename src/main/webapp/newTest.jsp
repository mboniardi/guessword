<%-- Document : newTest Created on : 1 May 2023, 11:14:54 Author : mboniardi --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />

            <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
            <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

            <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
            <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
            <title>New Test</title>
        </head>

        <body>
            <div class="container" id="container1">
                <div class="row centered-form">
                    <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title text-center">Seleziona numero domande e livello di difficolta'
                                </h3>
                            </div>
                            <div class="panel-body">
                                <form action="answer.jsp" method="post" role="form">
                                    <input type="hidden" name="pgtype" value="restart">
                                    <div class="form-group">
                                        Numero delle domande: <select name="numberOfQuestions">
                                            <option value="5">5</option>
                                            <option value="10">10</option>
                                            <option value="20">20</option>
                                            <option value="30">30</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        Difficoltà: <select name="level">
                                            <option value="0">Facile (4 possibili risposte)</option>
                                            <option value="1">Medio (8 possibili risposte)</option>
                                            <option value="2">Difficile (testo libero)</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" name="submit">
                                    </div>
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