<%-- 
    Document   : attendance
    Created on : Jul 16, 2017, 6:04:36 AM
    Author     : admin
--%>

<%@page import="model.CourseSchedule"%>
<%@page import="pagging.Pagger"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String level = (String) session.getAttribute("level");%>
<%ArrayList list = (ArrayList) request.getAttribute("teacherCourseList");%>
<%String loadPage = (String) request.getAttribute("loadPage");%>
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
                <div class="rightside">
                    <h2 style="text-align: center; margin-top:10px;">Choose Your Course</h2>
                    <br>
                    <form action="teachingschedule" method="POST">
                        <div style="display:flex; margin-left:250px;">
                            <h4>Course List</h4> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <select name="courseId" class="form-control" style="width:30%; margin-top:1px;">
                                <%for (int i = 0; i < list.size(); i++) {%>
                                <option value="<%=list.get(i)%>"><%=list.get(i)%></option>
                                <%}%>
                            </select>
                            <button class="btn btn-default" style="margin-left:10px; margin-top:-5px;" type="submit">Show Teaching Schedule</button>
                        </div>
                    </form>
                    <br>
                    <%if (loadPage != null) {%>
                    <%ArrayList<CourseSchedule> courseSchedule = (ArrayList) request.getAttribute("courseSchedule");%>
                    <%int total_page = Integer.parseInt(request.getAttribute("totalPage").toString());%>
                    <%int current_page = Integer.parseInt(request.getAttribute("page").toString());%>
                    <table class="table table-hover" >
                        <thead>
                        <th>No.</th>
                        <th>Day</th>
                        <th>Date</th>
                        <th>Room Code</th>
                        <th>Subject Code</th>
                        <th>Subject Name</th>
                        <th>Course Code</th>
                        <th>Slot</th>
                        <th>Attendance</th>
                        </thead>
                        <%for (CourseSchedule i : courseSchedule) {%>
                        <tr>
                            <td><%=i.getNumber()%></td>
                            <td><%=i.getDay()%></td>
                            <td><%=i.getDate()%></td>
                            <td><%=i.getRoomCode()%></td>
                            <td><%=i.getSubjectCode()%></td>
                            <td><%=i.getSubjectName()%></td>
                            <td><%=i.getCourseCode()%></td>
                            <td><%=i.getSlot()%></td>
                            <td><a href="attendance?teachingScheduleId=<%=i.getTeachingScheduleId()%>" style="text-decoration: none;"><button class="btn btn-default">Check Attendance</a></td>
                        </tr>
                        <%}%>
                    </table>
                    <div class="pagger">
                        <h4>Page No.</h4>
                        <%=Pagger.generate(current_page, 5, total_page, "teachingschedule")%>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
