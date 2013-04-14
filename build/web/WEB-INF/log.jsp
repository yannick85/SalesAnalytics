<%-- 
    Document   : log
    Created on : 16 mars 2013, 19:44:26
    Author     : Yannick
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
    </head>
    <body>
        <h1>Log in</h1>
        <p>
            Welcome<br />
            - To access the application, please add a line in the "user" table (/!\ password in MD5).<br />
            - The dashboard take some time to load, please wait.
        </p>
        <form action="" method="POST">
            <input type="text" placeholder="Your username" name="user-name"/>
            <input type="password" placeholder="Your password" name="user-pass"/>
            <input type="submit"/>
        </form>
    </body>
</html>
