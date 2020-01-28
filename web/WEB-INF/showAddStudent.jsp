<%-- 
    Document   : showAddStudent
    Created on : Jan 27, 2020, 9:11:57 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Запись нового студента</title>
    </head>
    <body>
        <h1>Добавить нового студента</h1>
        
        <form action="addStudent" method="POST">
            Имя:<br>
            <input type="text" name="firstname"><br>
            Фамилия:<br>
            <input type="text" name="lastname"><br>
            Статус:<br>
            <input type="text" name="status"><br>
            <input type="submit" name="Добавить">
        </form>
    </body>
</html>
