<%@page import="Category.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="OrderCourse.OrderCourseDTO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Manager</title>
    </head>

    <body>

        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            header {
                background-color: #333;
                color: #fff;
                text-align: center;
                padding: 10px 0;
            }

            nav {
                background-color: #f4f4f4;
                padding: 10px;
            }

            nav ul {
                list-style-type: none;
                padding: 0;
                margin: 0;
                text-align: center;
            }

            nav ul li {
                display: inline;
                margin-right: 10px;
            }

            nav a {
                text-decoration: none;
                color: #333;
            }

            .item{
                display: grid;
                grid-template-columns: auto auto auto auto auto auto auto auto;
                column-gap: 20px;
            }

            section {
                font-size: 20px;
                margin-left: 20px;
            }
            .img{
                width: 50px;
            }
            .img img{
                width: 100%;
            }
            .text{
                font-size: 15px;
            }
            .context{
                width: 100px;
                margin-bottom: 20px;
            }
            .border{
                border: 1px solid black;
                margin-bottom: 10px;
            }

            h2 {
                color: #333;
                border-bottom: 1px solid #333;
                padding-bottom: 5px;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .header{
                display: flex;
                margin-right: 90px;
                margin-bottom: 10px;
            }
            .headerNext{
                margin-left: 120px;
            }

            ul li{
                list-style-type: none;
                padding: 0;
                margin-bottom: 20px;
            }

            footer {
                background-color: #333;
                color: #fff;
                text-align: center;
                padding: 10px 0;
            }

            .addForm {
                max-width: 200px;
                margin: 0 auto;
                background-color: rgb(114, 114, 171);
                padding: 50px;
                padding-left: 80px;
                padding-right: 90px;
                position: absolute;
                left: 40%;
                display: none;
            }
            .close{
                position: absolute;
                top: -15px;
                left: 0;
                font-size: 60px;
                cursor: pointer;
            }
            .btn{

            }

            input[type="submit"] {
                padding: 10px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
            }
            input[type="submit"]:hover {
                background-color: #45a049;
            }

        </style>
        <header>
            <h1>Welcome to the Product Manager Dashboard</h1>
        </header>
        <form action="MainController"  class="addForm" id="addForm">
            <span class="close" onclick="closeModal()">&times;</span>
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name"><br><br>

            <label for="image">Link image:</label><br>
            <input type="text" id="image" name="image"><br><br>

            <label for="price">Price:</label><br>
            <input type="text" id="price" name="price"><br><br>

            <label for="date">Date Start (yyyy-mm-dd):</label><br>
            <input type="text" id="date" name="dateStart" placeholder="yyyy-mm-dd"><br><br>

            <label for="datef">Date End (yyyy-mm-dd):</label><br>
            <input type="text" id="datef" name="dateEnd" placeholder="yyyy-mm-dd"><br><br>

            <label for="description">Description:</label><br>
            <textarea id="description" name="description" rows="4"></textarea><br><br>

            
            <label for="quantity">Quantity:</label><br>
            <input type="text" id="quantity" name="quantity" placeholder=""><br><br>

            <label for="status">Status:</label><br>
            <input type="text" id="status" name="status" placeholder=""><br><br>
            
            <label >Category:</label><br>
            <select  name="category" >
                <%
                    for (CategoryDTO list : (List<CategoryDTO>) request.getAttribute("listC")) {
                %>
                <option value="<%=list.getCid()%>"><%=list.getCname()%></option>

                <%
                    }
                %>
            </select>
            
            <button class="btn" type="submit" name="btAction" value="AddMore">Add Product</button>
        </form>

        <div class="container">
            <nav>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Products</a></li>
                    <li><a href="#">Orders</a></li>
                    <li><a href="#">Customers</a></li>
                </ul>
            </nav>
            <%
                if(request.getAttribute("AddErr")!=null){
                
                    %>
                    <div style="margin-left: 60px;"><font color ="red"><%=
                        request.getAttribute("AddErr")
                    %></font></div>
                    
                    <%
                
}
            %>
            <h2>Products</h2>

            <section>

                <ul>
                    <li>

                        <div ><button onclick="modalForm()">Add</button></div>
                        <div class="header">
                            <div class="header">CourseID</div>
                            <div>Image</div>
                            <div class="headerNext">
                                <div>Name</div>
                            </div>
                            <div class="headerNext">
                                <div>Description</div>
                            </div>
                            <div class="headerNext">
                                <div>Price</div>
                            </div>
                            <div class="headerNext">
                                <div>Start Date</div>
                            </div>
                            <div class="headerNext">
                                <div>End Date</div>
                            </div>
                            <div class="headerNext">
                                <div>Category</div>
                            </div>

                        </div>


                        <%
                            List<OrderCourseDTO> list = (List<OrderCourseDTO>) request.getAttribute("listP");
                            if (list != null) {
                                for (OrderCourseDTO lists : list) {
                        %>
                        <form action="MainController">
                            <div class="item">


                                <div class="context">
                                    <div class="text">
                                        <input type="hidden" name="courseID" value="<%=lists.getCourseID()%>">
                                        <%=lists.getCourseID()%>
                                    </div>
                                </div>
                                <div class="context">
                                    <div class="img">

                                        <input name="image" value="<%=lists.getImage()%>">
                                        <img src="<%=lists.getImage()%>" alt="">
                                    </div>
                                </div>
                                <div class="context">
                                    <div class="text">
                                        <input name="Name" value="<%=lists.getName()%>">
                                    </div>
                                </div>
                                <div class="context">
                                    <div class="text">
                                        <input name="Des" value="<%=lists.getDescription()%>">
                                    </div>
                                </div>
                                <div class="context">
                                    <div class="text">
                                        <input name="Price" value="<%=lists.getPrice()%>">
                                    </div>
                                </div>
                                <div class="context">
                                    <div class="text">
                                        <input name="StartDate" value="<%=lists.getStartDate()%>">
                                    </div>
                                </div>
                                <div class="context">
                                    <div class="text">
                                        <input name="EndDate" value="<%=lists.getEndDate()%>">
                                    </div>
                                </div>
                                <div class="context">
                                    <div class="text">
                                        <input name="Category" value="<%=lists.getCid()%>">
                                    </div>
                                </div>
                                <div class="context">
                                    <div class="">
                                        <div>quantity</div>
                                    </div>

                                    <div class="text">
                                        <input name="quantity" value="<%=lists.getQuanity()%>">
                                    </div>
                                </div>

                                <div class="context">
                                    <div class="">
                                        <div>status</div>
                                    </div>
                                    <div class="text">
                                        <input name="status" value="<%=lists.getStatus()%>">
                                    </div>
                                </div>



                            </div>
                            <div><button type="submit" name="btAction" value="Update">Update</button></div>
                            <div><button type="submit" name="btAction" value="Delete">Delete</button></div>

                        </form>

                        <div  class="border"></div>
                        <%
                                }
                            }

                        %>    
                    </li>


                </ul>
            </section>




            <footer>
                <p>&copy; 2024 Product Manager. All rights reserved.</p>
            </footer>
        </div>


        <script>
            function modalForm() {

                var modal = document.getElementById('addForm');
                document.querySelector(".container").style.pointerEvents = 'none';

                modal.style.display = "block";
            }
            function closeModal() {
                document.querySelector(".container").style.pointerEvents = 'auto';
                addForm.style.display = "none";
            }
        </script>
    </body>
</html>
