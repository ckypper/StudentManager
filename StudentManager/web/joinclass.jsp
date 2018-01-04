<%-- 
    Document   : joinclass
    Created on : Jul 10, 2017, 5:21:56 PM
    Author     : admin
--%>

<%@page import="model.Courses"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<Courses> list = (ArrayList<Courses>) request.getAttribute("list");%>
<%ArrayList studentCourseList = (ArrayList) session.getAttribute("studentCourseList");%>
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
                        <a href="course" style="text-decoration:none">Join Class</a>
                        <a href="timetable" style="text-decoration:none">Time table</a>
                    </div>    
                </div>
                <div class="rightside">   
                    <h2 style="text-align:center;">Course List</h2>
                    <br>
                    <table class="table table-hover">
                        <thead>
                        <th>CourseId</th>
                        <th>Course Code</th>
                        <th>Subject Code</th>
                        <th>Subject Name</th>
                        <th>Teacher Name</th>
                        <th>Term Name</th>
                        <th>From Date</th>
                        <th>To Date</th>
                        <th>Capacity</th>
                        <th>Join In</th>
                        </thead>
                        <%for (Courses i : list) {
                                    boolean joined = false;%>
                        <tr>
                            <td><%=i.getCourseId()%></td>
                            <td><%=i.getCourseCode()%></td>
                            <td><%=i.getSubjectCode()%></td>
                            <td><%=i.getSubjectName()%></td>
                            <td><%=i.getTeacherName()%></td>
                            <td><%=i.getTermName()%></td>
                            <td><%=i.getFromDate()%></td>
                            <td><%=i.getToDate()%></td>
                            <td><%=i.getCapacity()%></td>
                            <td><%for (int j = 0; j < studentCourseList.size(); j++) {
                                    if (i.getCourseId() == (Integer) studentCourseList.get(j)) {
                                        joined = true;
                                    }
                                }
                                if (joined) {%>
                                Joined
                                <%} else if (i.getCapacity() > 0) {%>
                                <a href="course?id=<%=i.getCourseId()%>"><button class="btn btn-default">Join In</button></a>
                                <%} else {%>
                                Full
                                <%}%>
                            </td>
                        </tr>
                        <%}%>
                    </table> 
                </div>    
            </div>
        </div>        
    </body>
</html>
