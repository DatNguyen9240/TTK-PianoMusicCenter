<%-- 
    Document   : Register
    Created on : Jun 20, 2024, 1:32:11 PM
    Author     : XinWei
--%>


<%@page import="Registration.RegistrationInsertErr"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style3.css">
    </head>
    <body>
        <style>
            .register button:active{
                box-shadow: none;
                transform: translateY(3px);

            }
            .reset button:active{
                box-shadow: none;
                transform: translateY(5px);
            }
        </style>
        <div class="container-register">
            <div><h1>Create new Account</h1></div>
            <div><form action="MainController" class="form-register">
                    <div><label for="username">Username:</label>
                        <input type="text" name="txtUsername" value="<%=request.getParameter("txtUsername")%>" id="username"> <h1>(from 6 to 20 chars)</h1>
                        <%
                            RegistrationInsertErr errors = (RegistrationInsertErr) request.getAttribute("INSERTERRORS");
                            if (errors != null) {
                                if (errors.getUsernameLengthErr() != null) {
                        %> 
                        <h1><font color="red">
                            <%=errors.getUsernameLengthErr()%>
                            </font></h1>
                            <%
                                    }
                                }
                            %>
                            <%
                                if (errors != null) {
                                    if (errors.getUsernameIsExisted() != null) {
                            %>
                        <h1><font color="red"><%= errors.getUsernameIsExisted()%> </font></h1>
                            <%
                                    }
                                }
                            %><br></div>  
                    <div><label for="password">Password:</label>
                        <input type="text" name="txtPassword" value="" id="password"/><h1>(from 8 to 20 chars)</h1>
                        <%                if (errors != null) {
                                if (errors.getPasswordLengthErr() != null) {

                        %>
                        <h1><font color="red">
                            <%=errors.getPasswordLengthErr()%>
                            </font></h1>
                            <%
                                    }
                                }
                            %>
                        <br>
                    </div>
                    <div><label for="cofirm">ConfirmPassword:</label>
                        <input type="text" name="txtConfirm" value="" id="confirm"><h1>(the same password)</h1>
                        <%
                            if (errors != null) {
                                if (errors.getConfirmPassNotMatch() != null) {

                        %>
                        <h1><font color="red">
                            <%=errors.getConfirmPassNotMatch()%>
                            </font></h1>
                            <%
                                    }
                                }
                            %>
                        <br>
                    </div>
                    <div><label>Fullname:</label>
                        <input type="text" name="txtFullname" value="<%=request.getParameter("txtFullname")%>"/><h1>(from 2 to 40 chars)</h1>

                        <%
                            if (errors != null) {
                                if (errors.getFullnameLengthErr() != null) {

                        %>
                        <h1><font color="red">
                            <%=errors.getFullnameLengthErr()%>
                            </font></h1>
                            <%
                                    }
                                }
                            %>
                        <br>
                    </div>
                    <div class="submit" style="display: flex;justify-content: space-around;">

                        <div class="register"><button type="submit" value="Register" name="btAction" style="background-color: #FA6A69;
                                                      width: 150px;

                                                      border-radius: 10px;
                                                      height: 50px;
                                                      border: none;
                                                      font-family: Poppins;
                                                      box-shadow: 0 10px 20px #FA6A6999;
                                                      margin-bottom: 40px;
                                                      transition: 0.5s;
                                                      color: #fff;
                                                      font-size: 14px;
                                                      cursor: pointer;
                                                      ">Register</button></div>
                        <div class="reset"><button type="submit" value="Reset" name="btAction" style="background-color: #FA6A69;
                                                   width: 150px;
                                                   border-radius: 10px;
                                                   height: 50px;
                                                   border: none;
                                                   font-family: Poppins;
                                                   box-shadow: 0 10px 20px #FA6A6999;
                                                   margin-bottom: 40px;
                                                   transition: 0.5s;
                                                   color: #fff;
                                                   cursor: pointer;
                                                   font-size: 14px;
                                                   ">Reset</button></div>  
                    </div>

                </form>
            </div>
        </div>

    </body>
</html>

