<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>EOH Digital</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                margin: 20px;
            }

            .input-group-btn .dropdown-toggle:not(:last-of-type) {
                border-radius: 0 !important;
            }
        </style>
    </head>
    <body>
        <center>
            <form:form method = "POST" action = "/EOHDigital/display" 
                       id="accountForm"  >
                <h1>EOH Digital User Account Search </h1>
                <div class="container">
                    <div class="row">
                        <p><font color="red">${errormessage}</font></p>
                        <div class="input-group input-group-lg">
                            <input name="accountNumber" type="text" 
                                        class="form-control" id="accountNumber"
                                        placeholder="Enter Account Number e.g A0000001" />

                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>         
                            </div>
                        </div>
                    </div>
                </form:form>
        </center>
    </body>
</html>