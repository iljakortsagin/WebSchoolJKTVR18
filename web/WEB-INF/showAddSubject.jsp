<%-- 
    Document   : showAddSubject
    Created on : Jan 28, 2020, 9:09:47 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Запись нового спредмета</title>
    </head>
    <body>
        <h1>Добавить новый предмет</h1>
        
        <form action="addSubject" method="POST">
            Количество часов:<br>
            <input type="number" name="hours"><br>
            Название предмета:<br>
            <input type="text" name="name"><br>
            Фамилия преподавателя:<br>
            <input type="" name="person"><br>
            <input type="submit" name="Добавить">
        </form>
    </body>
</html>