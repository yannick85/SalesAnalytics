<%-- 
    Document   : index
    Created on : 16 mars 2013, 15:04:44
    Author     : Yannick
--%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.supinfo.salesbetou.entity.Channel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String contextPath = getServletContext().getContextPath(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link href="<%=contextPath %>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=contextPath %>/css/style.css" rel="stylesheet">
        <script src="<%=contextPath %>/js/jquery.js"></script>
        <script src="<%=contextPath %>/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    </head>
    <body>
        <header class="header">
            <div id="api_links">
                <a class="dropdown-toggle" data-toggle="dropdown">APIs</a>
                <ul class="dropdown-menu">
                    <li><a href="<%=contextPath %>/SalesWS?WSDL">France SOAP</a><a href="<%=contextPath %>/SalesWS?TESTER"> (GLASSFISH TESTER)</a></li>
                    <li><a href="<%=contextPath %>/rest/api/sales/canada">Canada REST/JSON</a></li>
                    <li><a href="<%=contextPath %>/api/sales/japan.csv">Japan CSV</a></li>
                </ul>
            </div>
            <div id="logout_link">
                <a href="<%=contextPath %>/logout">Logout</a>
            </div> 
            <h1>Dashboard</h1>
        </header>
        <section class="section">
            <div id="filter_wrapper">
                <form action="" method="GET" id="form_filter" >
                    <div class="row-fluid" id="filters_wrapper">
                        <div class="span3">
                            Country :
                            <select name="filter_country" id="filter_country">
                                <option value="" >No filtering</option>
                                <c:forEach items="${countries}" var="country">
                                    <option value="<c:out value="${country.id}"/>" <c:if test="${filter_country == country.id}">selected="selected" class="active" </c:if> ><c:out value="${country.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="span3">
                            Gender :
                            <select name="filter_gender" id="filter_gender">
                                <option value="" >No filtering</option>
                                <c:forEach items="${genders}" var="gender">
                                    <c:if test="${gender != null}">
                                        <option value="<c:out value="${gender}"/>" <c:if test="${filter_gender == gender}">selected="selected" class="active" </c:if>><c:out value="${gender}"/></option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="span3">
                            Marital status :
                            <select name="filter_maritalstatus" id="filter_gender">
                                <option value="" >No filtering</option>
                                <c:forEach items="${maritalStatuses}" var="maritalStatus">
                                    <c:if test="${maritalStatus != null}">
                                        <option value="<c:out value="${maritalStatus}"/>" <c:if test="${filter_maritalstatus == maritalStatus}">selected="selected" class="active" </c:if>><c:out value="${maritalStatus}"/></option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="span3">
                            Income level :
                            <select name="filter_incomelevel" id="filter_gender">
                                <option value="" >No filtering</option>
                                <c:forEach items="${incomeLevels}" var="incomeLevel">
                                    <c:if test="${incomeLevel != null}">
                                        <option value="<c:out value="${incomeLevel}"/>" <c:if test="${filter_incomelevel == incomeLevel}">selected="selected" class="active" </c:if>><c:out value="${incomeLevel}"/></option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                     </div>
                    <div id="filter_title_wrapper"><div id="filter_title"><input type="submit" name="submit" value="Activate the filters" /></div></div>
                </form>
            </div>
            <div id="content_wrapper">
                <div class="row-fluid">
                    <div class="span4">
                        <div class="box">
                            <div class="box-header">Sales overview</div>
                            <div class="box-body">
                                <div id="sales_overview">
                                    <div>Sales number : <c:out value="${salesNumber}"/></div>
                                    <div>Total amount : <c:out value="${totalAmount}"/></div>
                                </div>
                            </div>
                        </div>
                        <div class="box">
                            <div class="box-header">Breakdown by channel</div>
                            <div class="box-body">
                                <div id="breakdown_channel_chart"></div>
                            </div>
                        </div>
                    </div>
                    <div class="span8">
                        <div class="box">
                            <div class="box-header">Breakdown by country</div>
                            <div class="box-body">
                                <div class="row-fluid">
                                    <div class="span6">
                                        <table class="table table-bordered table-striped responsive dataTable">
                                            <tr><th>#</th><th>Name</th><th>Quantity sold</th><th>Amount earned</th></tr>
                                            <c:set var="i" value="${0}"/>
                                            <c:forEach items="${countriesBreakdown}" var="country">
                                                <c:set var="i" value="${i+1}"/>
                                                <c:set var="amount" value="0"/><c:if test="${country[1] != null}"><c:set var="amount" value="${country[1]}"/></c:if>
                                                <c:set var="quantity" value="0"/><c:if test="${country[2] != null}"><c:set var="quantity" value="${country[2]}"/></c:if>
                                                <tr><td><c:out value="${i}"/></td><td><c:out value="${country[0].name}"/></td><td><c:out value="${quantity}"/></td><td><c:out value="${amount}"/></td></tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                    <div class="span6">
                                        <div id="breakdown_country_chart"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span4">
                        <div class="box">
                            <div class="box-header">Less sold products</div>
                            <div class="box-body">
                                <table class="table table-bordered table-striped responsive dataTable">
                                    <tr><th>#</th><th>Product name</th><th>Quantity sold</th><th>Amount earned</th></tr>
                                    <c:set var="i" value="${0}"/>
                                    <c:forEach items="${worstProducts}" var="product">
                                        <c:set var="i" value="${i+1}"/>
                                        <c:set var="amount" value="0"/><c:if test="${product[1] != null}"><c:set var="amount" value="${product[1]}"/></c:if>
                                        <c:set var="quantity" value="0"/><c:if test="${product[2] != null}"><c:set var="quantity" value="${product[2]}"/></c:if>
                                        <tr><td><c:out value="${i}"/></td><td><c:out value="${product[0].name}"/></td><td><c:out value="${quantity}"/></td><td><c:out value="${amount}"/></td></tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="span8">
                        <div class="box">
                            <div class="box-header">Best selling products</div>
                            <div class="box-body">
                                <div class="row-fluid">
                                    <div class="span6">
                                        <table class="table table-bordered table-striped responsive dataTable">
                                            <tr><th>#</th><th>Product name</th><th>Quantity sold</th><th>Amount earned</th></tr>
                                            <c:set var="i" value="${0}"/>
                                            <c:forEach items="${bestProducts}" var="product">
                                                <c:set var="i" value="${i+1}"/>
                                                <c:set var="amount" value="0"/><c:if test="${product[1] != null}"><c:set var="amount" value="${product[1]}"/></c:if>
                                                <c:set var="quantity" value="0"/><c:if test="${product[2] != null}"><c:set var="quantity" value="${product[2]}"/></c:if>
                                                <tr><td><c:out value="${i}"/></td><td><c:out value="${product[0].name}"/></td><td><c:out value="${quantity}"/></td><td><c:out value="${amount}"/></td></tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                    <div class="span6">
                                        <div id="best_products_chart"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="box">
                            <div class="box-header">Breakdown by customer gender</div>
                            <div class="box-body">
                                <div id="breakdown_gender_chart"></div>
                            </div>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="box">
                            <div class="box-header">Breakdown by marital status</div>
                            <div class="box-body">
                                <div id="breakdown_maritalstatus_chart"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span8">
                        <div class="box">
                            <div class="box-header">Breakdown by income level</div>
                            <div class="box-body">
                                <div class="row-fluid">
                                    <div class="span6">
                                        <table class="table table-bordered table-striped responsive dataTable">
                                            <tr><th>#</th><th>Income level</th><th>Quantity sold</th><th>Amount earned</th></tr>
                                            <c:set var="i" value="${0}"/>
                                            <c:forEach items="${incomelevelsBreakdown}" var="incomelevel">
                                                <c:if test="${incomelevel[0] != null}">
                                                    <c:set var="i" value="${i+1}"/>
                                                    <c:set var="amount" value="0"/><c:if test="${incomelevel[1] != null}"><c:set var="amount" value="${incomelevel[1]}"/></c:if>
                                                    <c:set var="quantity" value="0"/><c:if test="${incomelevel[2] != null}"><c:set var="quantity" value="${incomelevel[2]}"/></c:if>
                                                    <tr><td><c:out value="${i}"/></td><td><c:out value="${incomelevel[0]}"/></td><td><c:out value="${quantity}"/></td><td><c:out value="${amount}"/></td></tr>
                                                </c:if>
                                            </c:forEach>
                                        </table>
                                    </div>
                                    <div class="span6">
                                        <div id="breakdown_incomelevel_chart"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="box">
                            <div class="box-header">Best customers</div>
                            <div class="box-body">
                                <table class="table table-bordered table-striped responsive dataTable">
                                    <tr><th>#</th><th>Customer name</th><th>Quantity sold</th><th>Amount earned</th></tr>
                                    <c:set var="i" value="${0}"/>
                                    <c:forEach items="${bestCustomers}" var="customer">
                                        <c:set var="i" value="${i+1}"/>
                                        <c:set var="amount" value="0"/><c:if test="${customer[1] != null}"><c:set var="amount" value="${customer[1]}"/></c:if>
                                        <c:set var="quantity" value="0"/><c:if test="${customer[2] != null}"><c:set var="quantity" value="${customer[2]}"/></c:if>
                                        <tr><td><c:out value="${i}"/></td><td><c:out value="${customer[0].firstName}"/> <c:out value="${customer[0].lastName}"/></td><td><c:out value="${quantity}"/></td><td><c:out value="${amount}"/></td></tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>                    
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawCharts);
      
      function drawCharts(){
        var channelsBreakdownData = google.visualization.arrayToDataTable([
            ['Channel', 'Amount earned'],
            <c:forEach items="${channelsBreakdown}" var="channel">
                <c:set var="amount" value="0"/><c:if test="${channel[1] != null}"><c:set var="amount" value="${channel[1]}"/></c:if>
               ["<c:out value="${channel[0].desc}"/>", <c:out value="${amount}" />],
            </c:forEach>
        ]);
        var bestSellingProductsData = google.visualization.arrayToDataTable([
            ['Product', 'Amount Sold'],
            <c:forEach items="${bestProducts}" var="product">
                <c:set var="quantity" value="0"/><c:if test="${product[2] != null}"><c:set var="quantity" value="${product[2]}"/></c:if>
                ["<c:out value="${product[0].name}"/>",<c:out value="${quantity}"/>],
            </c:forEach>
        ]);
        var countriesBreakdownData = google.visualization.arrayToDataTable([
            ['Country', 'Amount earned'],
            <c:forEach items="${countriesBreakdown}" var="country">
                <c:set var="amount" value="0"/><c:if test="${country[1] != null}"><c:set var="amount" value="${country[1]}"/></c:if>
               ["<c:out value="${country[0].name}"/>", <c:out value="${amount}" />],
            </c:forEach>
        ]);
        var gendersBreakdownData = google.visualization.arrayToDataTable([
            ['Gender', 'Amount earned'],
            <c:forEach items="${gendersBreakdown}" var="gender">
                <c:set var="amount" value="0"/><c:if test="${gender[1] != null}"><c:set var="amount" value="${gender[1]}"/></c:if>
               ["<c:out value="${gender[0]}"/>", <c:out value="${amount}" />],
            </c:forEach>
        ]);
        var maritalstatusesBreakdownData = google.visualization.arrayToDataTable([
            ['Marital status', 'Amount earned'],
            <c:forEach items="${maritalstatusesBreakdown}" var="maritalstatus">
                <c:set var="amount" value="0"/><c:if test="${maritalstatus[1] != null}"><c:set var="amount" value="${maritalstatus[1]}"/></c:if>
               ["<c:out value="${maritalstatus[0]}"/>", <c:out value="${amount}" />],
            </c:forEach>
        ]);
        var incomelevelsBreakdownData = google.visualization.arrayToDataTable([
            ['Income level', 'Amount earned'],
            <c:forEach items="${incomelevelsBreakdown}" var="incomelevel">
                <c:set var="amount" value="0"/><c:if test="${incomelevel[1] != null}"><c:set var="amount" value="${incomelevel[1]}"/></c:if>
               ["<c:out value="${incomelevel[0]}"/>", <c:out value="${amount}" />],
            </c:forEach>
        ]);
        
        
        var options = {
            sliceVisibilityThreshold : 0
        };
        
        var chart1 = new google.visualization.PieChart(document.getElementById("breakdown_channel_chart"));
        var chart2 = new google.visualization.PieChart(document.getElementById("best_products_chart"));
        var chart3 = new google.visualization.PieChart(document.getElementById("breakdown_country_chart"));
        var chart4 = new google.visualization.PieChart(document.getElementById("breakdown_gender_chart"));
        var chart5 = new google.visualization.PieChart(document.getElementById("breakdown_maritalstatus_chart"));
        var chart6 = new google.visualization.PieChart(document.getElementById("breakdown_incomelevel_chart"));
        chart1.draw(channelsBreakdownData, options);
        chart2.draw(bestSellingProductsData, options);
        chart3.draw(countriesBreakdownData, options);
        chart4.draw(gendersBreakdownData, options);
        chart5.draw(maritalstatusesBreakdownData, options);
        chart6.draw(incomelevelsBreakdownData, options);
      }
    </script>
    </body>
</html>
