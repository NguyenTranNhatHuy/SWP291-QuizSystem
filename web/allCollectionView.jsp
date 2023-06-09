<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    </head>
    <body>
        <style>
            body{
                background-color: #f6f7fb;
                font-family: courier, arial, helvetica;
            }

            .container{
                display: flex;
                justify-content: center;
                align-items: center;
                flex-wrap: wrap;
            }
            .tittle{
                padding: 10px 0 30px 0;
            }

            .content{
                border: 1px solid black;
                width: 30%;
                margin: 0 20px 20px 10px;
                text-align: center;
                border-radius: 15px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            }
            .content:hover{
                /*                box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.7);*/
                box-shadow: 10px 10px 5px lightblue;
                cursor: pointer;
            }
            .content p {
                font-size: 20px;
                font-weight: bold;
            }

            @media (max-width: 800px) {
                .container {
                    flex-direction: column;
                }
                .content{
                    width: 60%;
                }
            }
        </style>
        <a href="index.jsp"><i style="font-size: 2.5rem; color: #000" class="fa fa-3x fa-home text-primary mb-4"></i></a>
        <div class="tittle">            
            <h1>There are all collection</h1>
        </div>
        <div class="container">

            <c:forEach var="i" items="${requestScope.listCollectionDetail}">

                <div class="content">
                    <p> ${i.name}</p>
                    <p>Author: ${i.owner.firstname} ${i.owner.lastname}</p>
                    <a href="collection?id=${i.id}" style="text-decoration: none; color: "><h1>Learn</h1></a>
                </div>

            </c:forEach>
        </div>
    </body>
</html>