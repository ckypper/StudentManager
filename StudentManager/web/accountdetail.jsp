<%-- 
    Document   : accountdetail
    Created on : Jul 16, 2017, 6:22:07 PM
    Author     : admin
--%>

<%@page import="model.Teacher"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String level = (String) session.getAttribute("level");%>
<%String view = (String) request.getAttribute("view");%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/index.css">
        <title>FPT UNIVERSITY</title>
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
                    <%if (level != null) {
                            if (level.equals("student")) {%>
                    <a href="course" style="text-decoration:none">
                        <span class="text">Join Course</span>
                        <span class="line -right"></span>
                        <span class="line -top"></span>
                        <span class="line -left"></span>
                        <span class="line -bottom"></span>
                    </a>
                    <a href="timetable" style="text-decoration:none">
                        <span class="text">Time table</span>
                        <span class="line -right"></span>
                        <span class="line -top"></span>
                        <span class="line -left"></span>
                        <span class="line -bottom"></span>

                    </a>
                    <%} else if (level.equals("teacher")) {%>
                    <a href="teachingschedule" style="text-decoration:none">
                        <span class="text">Teaching Schedule</span>
                        <span class="line -right"></span>
                        <span class="line -top"></span>
                        <span class="line -left"></span>
                        <span class="line -bottom"></span>
                    </a>
                    <%}
                        }%>
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
                        <a href="login">Home</a>
                        <%if (level.equals("student")) {%>
                        <a href="course" style="text-decoration:none">Join Class</a>
                        <a href="timetable" style="text-decoration:none">Time table</a>
                        <%} else if (level.equals("teacher")) {%>
                        <a href="teachingschedule" style="text-decoration:none">Teaching Schedule</a>
                        <%}%>
                    </div>    
                </div>
                <div class="rightside">
                    <div class="accountdetail">
                        <h2 style="text-align:center;">Account Details</h2>
                        <br>
                        <%if (view != null) {%>
                        <%Student std = (Student) request.getAttribute("account");%>
                        Roll Number: <input class="form-control" type="text" disabled value="<%=std.getRollNumber()%>"></br>
                        First Name: <input class ="form-control" type="text" disabled value="<%=std.getFirstName()%>"></br>
                        Mid Name: <input class ="form-control" type="text" disabled value="<%=std.getMidName()%>"></br>
                        Last Name: <input class ="form-control" type="text" disabled value="<%=std.getLastName()%>"></br>
                        Date Of Birth: <input class ="form-control" type="text" disabled value="<%=std.getDateOfBirth()%>"></br>
                        Country: <input class ="form-control" type="text" disabled value="<%=std.getCountry()%>"></br>
                        Address: <input class ="form-control" type="text" disabled value ="<%=std.getAddress()%>"></br>
                        Phone Number: <input class ="form-control" disabled type="text" required value="<%=std.getPhoneNumber()%>"></br>
                        Email: <input class ="form-control" name="email"  disabled type="email" required value="<%=std.getEmail()%>"></br>
                        <%} else {%>
                        <form action="accountdetail" method="POST">
                            <%if (level.equals("student")) {%>
                            <%Student std = (Student) request.getAttribute("account");%>
                            Roll Number: <input class="form-control" type="text" disabled value="<%=std.getRollNumber()%>"></br>
                            First Name: <input class ="form-control" type="text" disabled value="<%=std.getFirstName()%>"></br>
                            Mid Name: <input class ="form-control" type="text" disabled value="<%=std.getMidName()%>"></br>
                            Last Name: <input class ="form-control" type="text" disabled value="<%=std.getLastName()%>"></br>
                            Date Of Birth: <input class ="form-control" type="text" disabled value="<%=std.getDateOfBirth()%>"></br>
                            Country: <input class ="form-control" type="text" disabled value="<%=std.getCountry()%>"></br>
                            Address: <input class ="form-control" type="text" disabled value ="<%=std.getAddress()%>"></br>
                            Phone Number: <input class ="form-control" name="phonenumber" type="text" required value="<%=std.getPhoneNumber()%>"></br>
                            Email: <input class ="form-control" name="email" type="email" required value="<%=std.getEmail()%>"></br>
                            Change Password:<input class ="form-control" type="password" name="pwd" required value="<%=std.getPassword()%>"></br>
                            <%} else if (level.equals("teacher")) {%>
                            <%Teacher tcr = (Teacher) request.getAttribute("account");%>
                            Teacher ID: <input class="form-control" type="text" disabled value="<%=tcr.getTeacherId()%>"></input></br>
                            First Name: <input class="form-control" type="text" disabled value="<%=tcr.getTeacherFirstName()%>"></input></br>
                            Mid Name: <input class="form-control" type="text" disabled value="<%=tcr.getTeacherMidName()%>"></input></br>
                            Last Name: <input class="form-control" type="text" disabled value="<%=tcr.getTeacherLastName()%>"></input></br>
                            Year Of Experience: <input class="form-control" type="text" disabled value="<%=tcr.getYearOfExp()%>"></input></br>
                            Status <input class="form-control" type="text" disabled value="<%=tcr.getStatus()%>"></input></br>
                            Change Password: <input class="form-control" type="password" name="pwd" value="<%=tcr.getPassword()%>"></input></br>
                            <%}%>
                            <br>
                            <div style="text-align:center">
                                <button type="submit" class="btn btn-default" value="save" name="save">Save
                                    <a href="login" style="text-decoration: none;"><button type="button" class="btn btn-default">Cancel</button></a>
                            </div>
                        </form>
                        <%}%>   
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
