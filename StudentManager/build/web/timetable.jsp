<%-- 
    Document   : timetable
    Created on : Jul 12, 2017, 4:39:55 PM
    Author     : admin
--%>

<%@page import="pagging.Pagger"%>
<%@page import="model.StudentAttendance"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList studentCourseList = (ArrayList) session.getAttribute("studentCourseList");%>
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
                        <a href="login">Home</a>
                        <a href="course" style="text-decoration:none">Join Class</a>
                        <a href="timetable" style="text-decoration:none">Time table</a>
                    </div>    
                </div>
                <div class="rightside">
                    <div class="mainright">
                        <h2 style="text-align:center;">Choose Your Course</h2>
                        <br>
                        <form action="timetable" method="POST">
                            <div style="display:flex; margin-left:250px;" >
                                <h4>Course List</h4> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <select name="courseId" class="form-control" style="width:30%; margin-top:1px;">
                                    <%for (int i = 0; i < studentCourseList.size(); i++) {%>
                                    <option value="<%=studentCourseList.get(i)%>"><%=studentCourseList.get(i)%></option>  
                                    <%}%>
                                </select>
                                <button type="submit" class="btn btn-default" style="margin-left:10px; margin-top:-5px;">Show Timetable</button>
                            </div>
                        </form>
                        <br>
                        <%if (loadPage != null) {%>
                        <%ArrayList<StudentAttendance> attendanceList = (ArrayList) request.getAttribute("list");%>
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
                            <th>Teacher</th>
                            <th>Slot</th>
                            <th>Status</th>
                            </thead>
                            <%for (StudentAttendance i : attendanceList) {%>
                            <tr>
                                <td><%=i.getNumber()%></td>
                                <td><%=i.getDay()%></td>
                                <td><%=i.getDate()%></td>
                                <td><%=i.getRoomCode()%></td>
                                <td><%=i.getSubjectCode()%></td>
                                <td><%=i.getSubjectName()%></td>
                                <td><%=i.getCourseCode()%></td>
                                <td><%=i.getTeacher()%></td>
                                <td><%=i.getSlot()%></td>
                                <td style="<%if (i.getStatus().equals("ABSENT")) {%>color:red;<%} else if (i.getStatus().equals("PRESENT")) {%>color:green;<%}%>
                                    font-weight: bold"><%=i.getStatus()%></td>
                            </tr>
                            <%}%>
                        </table>
                        <div class="pagger">
                            <h4>Page No.</h4>
                            <%=Pagger.generate(current_page, 5, total_page, "timetable")%>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
