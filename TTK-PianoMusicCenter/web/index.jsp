<%-- 
    Document   : index
    Created on : Jul 1, 2024, 3:25:56 PM
    Author     : XinWei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Style.css">
        <title>Document</title>
    </head>
    <body>
        <form action="MainController" method="post">
            <div class="login">

                <div class="title">Hello Again!</div>
                <div class="des">
                    Wellcome back you've <br> beeb missed!
                </div>
                <div class="group">
                    <input value="${txtUsername}" name="txtUsername" type="text" placeholder="Enter username">
                </div>
                <div><%
                    String ms = (String) request.getAttribute("msg");
                    if (ms != null) {
                    %>
                    <p style="color: red;"><%=ms%></p>
                    <% }%></div>
                <div class="group">
                    <input name="txtPassword" type="password" id="inputPassword" placeholder="Password">
                </div>
                <div class="recovery">
                    <a href="">recovery password</a>
                </div>
                <div class="signIn">
                    <button type="submit" name="btAction" value="Login">Sign In</button>
                </div>
                <div class="or">
                    Or continue with
                </div>
                <div class="list">
                    <div class="item">
                        <img src="https://cdn1.iconfinder.com/data/icons/google-s-logo/150/Google_Icons-09-512.png" alt="">
                    </div>
                    <div class="item">
                        <img src="https://museumandgallery.org/wp-content/uploads/2020/03/Facebook-Icon-Facebook-Logo-Social-Media-Fb-Logo-Facebook-Logo-PNG-and-Vector-with-Transparent-Background-for-Free-Download.png" alt="">
                    </div>
                    <div class="item">
                        <img src="https://www.iconpacks.net/icons/2/free-twitter-logo-icon-2429-thumb.png" alt="">
                    </div>
                </div>
                <div class="register">
                    Not a member? <a href="Register.html">Register now</a>
                </div>

            </div>
        </form>
    </body>
</html>
