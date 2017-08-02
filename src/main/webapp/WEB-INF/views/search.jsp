<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>EOH Digital</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
        <spring:url value="/display" var="pageurl" />
    </head>
    <body>
    <center>
        <div style="padding: 40px" >

            <p><h1><font color="blue">EOH Digital Assessment Account Details </font></h1></p>
            <hr/><hr/><br/>

            <%-- table for account--%>
            <div>
                <p><h3>ACCOUNT </h3></p><hr/>
                <table class="table table-striped table-bordered">
                    <thead> 
                        <tr>
                            <td>Account ID</td>
                            <td>Account Number</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${account.accountId}</td>
                            <td>${account.accountNumber}</td>
                        </tr>
                    <tbody>
                </table>
            </div>
            <hr/><hr/><br/>           

            <%-- table for account holder contact details--%>
            <div>
                <p><h3>ACCOUNT HOLDER CONTACT DETAILS</h3></p><hr/>
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <td>Contact ID </td>
                            <td>Contact First Name</td>
                            <td>Contact Last Name</td>
                            <td>Contact Email</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${contacts}" var="contactList">
                            <tr>
                                <td>${contactList.contactId}</td>
                                <td>${contactList.firstName}</td>
                                <td>${contactList.lastName}</td>
                                <td>${contactList.email}</td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>
            </div>
            <hr/><hr/><br/> 

            <%-- table for invoice details--%>
            <div>
                <p><h3>INVOICE  DETAILS</h3></p><hr/>
                <p:table class="table table-striped table-bordered" >
                    <thead>
                        <tr>
                            <td>Invoice ID</td>
                            <td>Opening Balance</td>
                            <td>Closing Balance</td>
                            <td>Invoice Due Date</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${invoices}" var="invoiceList">
                            <tr>
                                <td>${invoiceList.invoiceId}</td>
                                <td>${invoiceList.openingBalance}</td>
                                <td>${invoiceList.closingBalance}</td>
                                <td>${invoiceList.invoiceDueDate}</td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </p:table>
            </div>
            <hr/><hr/><br/> 

            <%-- table for itemised calls--%> 
            <div>
                <p><h3>ITEMISED CALLS</h3></p><hr/>
                <table class="table table-striped table-bordered" >
                    <thead>
                        <tr>
                            <td>Itemised ID</td>
                            <td>Call Date</td>
                            <td>Call Time</td>
                            <td>Call Type </td>
                            <td>Call Cost </td>
                        </tr>
                    </thead>  
                    <tbody>
                        <c:forEach items="${itemised}" var="itemisedList" >
                            <tr>
                                <td>${itemisedList.itemisedId}</td>
                                <td>${itemisedList.callDate}</td>
                                <td>${itemisedList.callTime}</td>
                                <td>${itemisedList.callType}</td>
                                <td>${itemisedList.callCost}</td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table> 
                <tag:paginate max="15" offset="${offset}" accountNumber="${accountNumber}" count="${count}" uri="/EOHDigital/display" next="&raquo;" previous="&laquo;" ></tag:paginate>
                <hr/><hr/><br/> 
            </div>
        </div>
    </center>
</body>
</html>