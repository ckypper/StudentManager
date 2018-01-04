<%-- 
    Document   : attendance.jsp
    Created on : Jul 16, 2017, 12:24:02 PM
    Author     : admin
--%>

<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");%>
<!DOCTYPE html>
<html>
    <head>
        <title>FPT UNIVERSITY</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="headertext">
                    <a href="login"> <img src="https://uniap.fpt.edu.vn/logo.jpg"> </a>
                </div>
                <div class="headerright">
                    <a href="login">
                        <span class="text">Home</span>
                        <span class="line -right"></span>
                        <span class="line -top"></span>
                        <span class="line -left"></span>
                        <span class="line -bottom"></span>
                    </a>

                    <a href="teachingschedule" style="text-decoration:none">
                        <span class="text">Teaching Schedule</span>
                        <span class="line -right"></span>
                        <span class="line -top"></span>
                        <span class="line -left"></span>
                        <span class="line -bottom"></span>
                    </a>
                </div>
            </div>
            <div class="middle">
                <div class="leftside">
                    <div class="logged">
                        <div class="headerleft">
                            <img src="img/64x64.png"/>
                            <p class="textleft">Welcome. <strong><%=session.getAttribute("logged")%></strong></p>
                            <div class="img">
                                <a href="accountdetail" class="lynk"><img src="img/24.png"/></a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="logout" class="lynk"><img width="24px" height="24px" src="img/logout.png"/></a>
                            </div>
                        </div>
                    </div>
                    <div class="mainleft">
                        <a href="login" style="text-decoration:none">Home</a>
                        <a href="teachingschedule" style="text-decoration:none">Teaching Schedule</a>
                    </div>    
                </div>
                <div class="rightside" style="font-size:16px;">
                    <h2 style="text-align: center;">Check Attendance Your Course</h2>
                    <br>
                    <form action="attendance" method="POST">
                        <table class="table">
                            <thead>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Roll Number</th>
                            <th>Present</th>
                            <th>Absent</th>
                            </thead>
                            <%for (Student i : studentList) {%>
                            <tr>
                                <td><%=i.getStudentID()%></td>
                            <td><a href="accountdetail?id=<%=i.getStudentID()%>"><%=i.getFullName()%></a></td>
                                <td><%=i.getRollNumber()%></td>
                                <td><input type="radio" name="<%=i.getStudentID()%>" value="present" 
                                           <%if (i.getStatus().equals("PRESENT")) {%>checked="checked"<%}%>></td>
                                <td><input type="radio" name="<%=i.getStudentID()%>" value="absent"
                                           <%if (i.getStatus().equals("ABSENT")) {%>checked="checked"<%}%>></td>
                            </tr>
                            <%}%>
                        </table>
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-default" value="save" name="save">SAVE</button>
                            <a href="teachingschedule"><button type="button" class="btn btn-default">Cancel</button></a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
