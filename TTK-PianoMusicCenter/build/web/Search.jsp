<%-- 
    Document   : Search
    Created on : Jul 1, 2024, 10:57:36 PM
    Author     : XinWei
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="Registration.RegistrationDTO"%>
<%@page import="Registration.RegistrationDAO"%>
<%@page import="CartObj.CartObj"%>
<%@page import="java.util.Map"%>
<%@page import="Category.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="OrderCourse.OrderCourseDTO"%>
<%@page import="java.sql.Date"%>
<%@page import="OrderCourse.OrderCourseDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Home.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    </head>
    <body>

        <style>
            .checked {
                color: orange;
            }

            .sidenav {
                height: 100vh;
                width: 0;
                position: fixed;
                z-index: 1;
                top: 0;
                left: 0;
                background-color: #353432;
                overflow-x: hidden;
                transition: 0.5s;
                padding-top: 60px;
                box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.75);
                -moz-box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.75);
                box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.75);

            }

            .sidenav  a {
                padding: 8px 8px 8px 32px;
                text-decoration: none;
                font-size: 25px;
                color: #818181;
                display: block;
                transition: 0.3s;
                color: #FCF41B;
            }

            .sidenav a:hover {
                color: #FFFFFF;
                font-weight: bold;
            }

            .sidenav .closebtn {
                position: absolute;
                top: 0;
                right: 25px;
                font-size: 36px;
                margin-left: 50px;
                cursor: pointer;
            }
            .border{
                border: 1px solid black;
                margin-bottom: 10px;
                margin-right: -100px;

            }
            .desP{
                font-size: 22px;
                width: 254px;
            }
            @media screen and (max-height: 450px) {
                .sidenav {
                    padding-top: 15px;
                }

                .sidenav a {
                    font-size: 18px;
                }
            }
        </style>
        <div id="mySidenav" class="sidenav">
            <a class="closebtn" onclick="closeNav()">&times;</a>
            <%

                if (session.getAttribute("acc") != null) {
            %>


            <%

            %>
            <a href="MainController?btAction=logout">
                Logout
            </a>
            <%                RegistrationDTO k = (RegistrationDTO) session.getAttribute("acc");
                if (k.isRole()) {
            %>
            <a href="MainController?btAction=Manager">
                Manager
            </a>
            <%
                }
            } else {%>
            <a href="MainController?btAction=Login">
                Login
            </a>

            <%
                }

            %>

        </div>
        <div class="container">


            <div class="header">
                <div id="menu" class="header_menu" style="">

                    <div class="leftNav"><span style="font-size:30px;cursor:pointer;" onclick="openNav()">&#9776; </span> <a style="font-size:30px;cursor:pointer;"href="HomeController">Home</a>

                        <div class="leftNav-left">
                            <%                                List<CategoryDTO> lists = (List<CategoryDTO>) session.getAttribute("listC");
                                if (lists != null) {
                                    for (CategoryDTO results : lists) {
                            %>
                            <div ><a  href="CategoryController?cid=<%=results.getCid()%>"><%=results.getCname()%></a></div>

                            <%
                                    }
                                }

                            %>
                            <div  class="border"></div>
                            <div><h1>New Course</h1></div>
                            <%                                OrderCourseDTO listLast = (OrderCourseDTO) session.getAttribute("P");
                            %>

                            <div class="item">

                                <div class="img">
                                    <img src="<%=listLast.getImage()%>" alt="">
                                    <div class="description">
                                        <%= listLast.getDescription()%>
                                    </div>
                                </div>

                                <div class="content">

                                    <div class="des">
                                        <%=listLast.getName()%>
                                    </div>
                                    <%=listLast.getStartDate()%><br>
                                    <%=listLast.getEndDate()%>
                                    <%=listLast.getCid()%><br>
                                    <div class="price"><%=listLast.getPrice()%></div>
                                    <div class="select">
                                        <div>





                                            <button onclick="addToCart('<%=listLast.getName()%>')">Add To Cart</button>

                                        </div>
                                        <div>
                                            <nav>
                                                <details>
                                                    <summary>
                                                        <i class="fa-solid fa-ellipsis-vertical"></i>
                                                    </summary>
                                                    <ul>
                                                        <li>
                                                            <i class="fa-regular fa-comment"></i>
                                                            Note
                                                        </li>
                                                        <li>
                                                            <i class="fa-solid fa-flag"></i>
                                                            Report
                                                        </li>
                                                    </ul>
                                                </details>
                                            </nav>
                                        </div>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>



                <div class="center">
                    <%
                        if (session.getAttribute("acc") != null) {%>
                    <div class="loginName">        
                        <%

                            if (session != null) {
                                RegistrationDTO acc = (RegistrationDTO) session.getAttribute("acc");
                                String username = acc.getLastname();
                        %>

                        <font color ="red">Welcome, <%= username%> </font>

                        <% } %>
                    </div>  
                    <%
                        }
                    %>
                    <div class="form">
                        <form action="MainController" method="post">
                            <i class="fa-solid fa-magnifying-glass"></i>
                            <input oninput="searchByName(this)" value="<%if (session.getAttribute("saveSearch") != null) {
                                   %><%=session.getAttribute("saveSearch")%><%
                                           session.setAttribute("saveSearch", session.getAttribute("saveSearch"));
                                       }

                                   %>" id="search" name="txt" type="text" placeholder="Search...">
                            <button type="submit" name="btAction" value="Search">Search</button>

                            <ol id="list_results">
                            </ol>
                        </form>

                    </div>
                    <div class="search">

                        <div id="listAll" class="list">
                            <%                                List<OrderCourseDTO> list = (List<OrderCourseDTO>) session.getAttribute("listP");
                                if (list != null) {
                                    for (int i = 0; i <= list.size() - 1; i++) {
                            %>
                            <div class="item">

                                <div class="img">
                                    <img src="<%=list.get(i).getImage()%>" alt="">
                                    <div class="description">
                                        <%= list.get(i).getDescription()%>
                                    </div>
                                </div>

                                <div class="content">

                                    <div class="des">
                                        <%=list.get(i).getName()%>
                                    </div>
                                    <%=list.get(i).getStartDate()%><br>
                                    <%=list.get(i).getEndDate()%>
                                    <%=list.get(i).getCid()%><br>
                                    <div class="price"><%=list.get(i).getPrice()%></div>
                                    <div class="select">
                                        <div>

                                            <button onclick="addToCart('<%=list.get(i).getName()%>')">Add</button>



                                        </div>
                                        <div>
                                            <nav>
                                                <details>
                                                    <summary>
                                                        <i class="fa-solid fa-ellipsis-vertical"></i>
                                                    </summary>
                                                    <ul>
                                                        <li>
                                                            <i class="fa-regular fa-comment"></i>
                                                            Note
                                                        </li>
                                                        <li>
                                                            <i class="fa-solid fa-flag"></i>
                                                            Report
                                                        </li>
                                                    </ul>
                                                </details>
                                            </nav>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <%
                                    }
                                }
                            %> 
                        </div>
                        <div>
                            <ul onclick="" class="listPage" style="display:flex; ">
                                <%
                                    int h = 1;
                                    int p = 1;
                                    OrderCourseDAO dao = new OrderCourseDAO();
                                    int l = dao.getTotalCourse();
                                    if (session.getAttribute("cnt") == null) {
                                        p = 1;
                                    } else {
                                        p = (Integer) session.getAttribute("cnt");
                                        if (p > (l / 6) - 1) {
                                            h = 0;
                                        }
                                        if (p > 1) {
                                %>
                                <form action="MainController">   
                                    <input type="hidden" value="<%=p - 1%>" name="cnt">
                                    <button type="submit" value="Change" name="btAction">PRE</button>    
                                </form> 
                                <%
                                        }

                                    }

                                    for (int i = p; i <= l / 6; i++) {
                                        int k = 0;
                                        k = +i;
                                %>
                                <form action="MainController">   
                                    <input type="hidden" value="<%=k%>" name="cnt">
                                    <button type="submit" value="Change" name="btAction"><%=k%></button>    
                                </form>
                                <%
                                    }
                                    if (h == 1) {

                                %>

                                <form action="MainController">   
                                    <input type="hidden" value="<%=p + 1%>" name="cnt">
                                    <button type="submit" value="Change" name="btAction">Next</button>    
                                </form> 
                                <%
                                    }
                                %>
                            </ul>
                        </div>

                    </div>


                </div>





                <div class="shoppingCard">
                    <div class="icon-cart">
                        <svg aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 18 20">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M6 15a2 2 0 1 0 0 4 2 2 0 0 0 0-4Zm0 0h8m-8 0-1-4m9 4a2 2 0 1 0 0 4 2 2 0 0 0 0-4Zm-9-4h10l2-7H3m2 7L3 4m0 0-.792-3H1" />
                        </svg>
                        <span class="quantity">

                            <%=CartObj.count%>
                            <%session.setAttribute("Count", CartObj.count);%>

                        </span>

                    </div>

                </div>
            </div>



        </div>
        <div class="cartTab">

            <h1>Shopping Cart</h1>
            <div id="" class="listCard">

                <form action="MainController">
                    <input type="checkbox" name="chkItem" value=""><br>
                    <ul id="BuyCard">
                        <%
                            CartObj cart = (CartObj) session.getAttribute("CART");
                            if (cart == null) {
                                cart = new CartObj();
                            }
                            Map<String, Integer> items = cart.getItem();
                            if (items != null) {
                                for (Map.Entry<String, Integer> item : items.entrySet()) {
                        %>
                        <button type="button" onclick="changeToCart('<%=item.getKey()%>')">Minus</button>
                        <li><%=item.getKey()%></li>
                        <div class="kay">
                            <li><%=item.getValue()%></li>
                        </div>
                        <%
                                }
                            }
                        %>

                    </ul>

                    <button type="submit" name="btAction" value="Remove">Remove</button>
                </form>




            </div>
            <div class="btn">
                <button class="close">CLOSE</button>

                <button  class="total">
                    <a style="text-decoration: none;" href=""> </a>
                </button>


            </div>

        </div>
        <!--        <script src="./change.js"></script>-->
        <script>
            function searchByName(param) {
                var txtSearch = param.value;
                $.ajax({
                    url: "/TTK-PianoMusicCenter/SearchByAjax",
                    type: "get", //send it through get method
                    data: {
                        txt: txtSearch
                    },
                    success: function (data) {
                        var row = document.getElementById("list_results");
                        row.innerHTML = data;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
            function clickSearch(param) {


                $.ajax({
                    url: "/TTK-PianoMusicCenter/NewPage",
                    type: "get", //send it through get method
                    data: {
                        txt: param
                    },
                    success: function (data) {
                        var row = document.getElementById("listAll");
                        row.innerHTML = data;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
            function addToCart(param) {
                $.ajax({
                    url: "/TTK-PianoMusicCenter/AddController",
                    type: "get", //send it through get method
                    data: {
                        addList: param
                    },
                    success: function (data) {
                        var row = document.getElementById("BuyCard");
                        row.innerHTML = data;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });

            }
            function changeToCart(key) {
                $.ajax({
                    url: "/TTK-PianoMusicCenter/changeToCart",
                    type: "post", //send it through get method
                    data: {
                        key: key

                    },
                    success: function (data) {
                        var row = document.getElementById("BuyCard");
                        row.innerHTML = data;

                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });

            }
        </script>
        <script src="./search.js"></script>
        <script src="./open.js"></script>
        <script src="./card.js"></script>
    </body>
</html>
