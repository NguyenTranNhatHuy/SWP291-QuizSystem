<%-- 
    Document   : questionList.jsp
    Created on : Jun 4, 2023, 3:12:47 PM
    Author     : W
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <link rel="stylesheet" href="css/nav.css"/>
    </head>
    <body>


        <style>

            * {
                padding: 0;
                margin: 0;
                box-sizing: border-box;

            }
            body{
                background-color: #f6f7fb;
            }

            .question {
                font-family: courier, arial, helvetica;
                cursor: pointer;
                position: relative;
                margin-top: 20%;
                width: 100%;
                animation: animation .5s ease-in-out 1;
                animation-fill-mode: forwards;
                background-color: #fff;
                margin-top: 0;
                border-radius: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                color: #2e3856;
            }

            .answer {
                display: none;
                margin-top: 0;
            }

            h1,
            h3 {
                text-align: justify;
                line-height: 1.4;
                /*                letter-spacing: 1px;*/
            }

            h1 {
                margin: 0 9px;
                font-size: 26px;
            }

            h3 {
                text-indent: 20px;
            }

            .container {
                width: 600px;
                height: 450px;
                display: flex;
                background-color: #fff;
                text-align: justify !important;
                border-radius: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);

            }
            #a {
                overflow-y: auto;
            }
            .wrapper {
                display: flex;
                justify-content: space-evenly;
                align-items: center;
            }

            @keyframes animation {
                0% {
                    transform: rotateY(90deg);
                }
                50%{
                    background-color:f6f7fb;
                }

                100% {
                    transform: rotateY(0);
                }
            }

            .div-content p {
                font-size: 25px;
                margin-left: 10px;
            }
            .pagging{
                font-size: 19px;
                padding: 10px;
                background-color: #e9e9e9;
                /*margin: 0px -24px;*/
                width: 8%;
                text-align: center;
                border-radius: 20px;
                display: inline-block;
            }
            .paggingmanage{
                /*display: flex;*/
                /*justify-content: center;*/
                align-items: center;
                margin-top: 10px;
                width: 80%;
                padding-left: 24%;
            }

            b{
                background-color: #c17a74;
                color:#000;
            }
            .divpagging{
                border: 1px solid #ccc;
                border-radius: 10px;
                background-color: #ccc;
            }

            .pagging a {
                text-decoration: none;
                color:#000;
                font-family:Cursive;
            }
            .iconadd{
                color: #000;
                font-weight: bold;
                font-family: Cursive;
                text-decoration: none;
                font-size: 20px;
            }
            .learning{
                display: flex;
                background-color: #fff;
                margin: 5%;
                border-radius: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                height: 50%;
            }
            .learning .learning-content{
                width: 40%;
                position: relative;
                padding: 20px 10px;
                overflow-y: auto;
                height: 100%;
            }
            .learning .learning-content::after{
                content: "";
                position: absolute;
                right:  0;
                height: 70%;
                top: 50%;
                transform: translateY(-50%);
                border-left: 1px solid #ccc;

            }

            .learning .leaning-anwser{
                width: 60%;
                padding: 20px 0;
                display: flex;
                justify-content: center;
                align-items: center;
                font-size: 25px;
            }
            .option-edit, .option-test, .option-copy_paste{
                padding: 20px;
                border-radius: 20px;
                background-color: #fff;
                width: 150px;
                margin: 10px 0;

            }
            .option-edit:hover{
                cursor: pointer;
                box-shadow: 10px 10px 5px lightblue;

            }
            .option-test:hover{
                cursor: pointer;
                box-shadow: 10px 10px 5px lightblue;

            }
            .option-copy_paste:hover{
                cursor: pointer;
                box-shadow: 10px 10px 5px lightblue;

            }
            .option a i {
                margin-left: 0;
            }
            .option a{
                text-decoration: none;
                text-align: center;
                margin-left: 10%;
            }
        </style>
        <c:set var="numPage" value="${param.numPage}"/>  
        <c:set var="pageSize" value="1"/>
        <c:set var="id" value="${id}"/>

        <c:if test="${numPage ==null}">
            <c:set var="numPage" value="1"/>   
        </c:if>
        <div id="header">
            <!-- Begin: Nav -->
            <div class="header-logo">
                <h2>FLearn</h2>
            </div>
            <div class="header-content">
                <ul id="nav">
                    <li><a class="active" href="#">Home</a></li>
                    <li><a class="" href="#">About</a></li>
                    <li><a class="" href="#">Courses </a></li>
                    <li><a class="" href="#">Contact</a></li>
                        <c:if test="${sessionScope.accountS==null}">                
                        <li><a  href="login.jsp">Join now</a></li>
                        </c:if>
                        <c:if test="${sessionScope.accountS!=null}">
                        <li>
                            <a href="#">
                                Account: ${sessionScope.accountS.username}

                            </a>
                            <ul class="subnav">
                                <li><a href="profileServlet?pid=${accountS.id}">My profile</a></li>
                                <li><a href="logoutServlet">Logout</a></li>
                            </ul>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
        <h1 style="margin-top: 80px">QuestionList</h1>

        <div class="wrapper">


            <c:forEach items="${collection}" var="i" begin="${(numPage-1)*pageSize}" end="${(numPage*pageSize)-1}">
                <div class="container">

                    <div class="question " id="a" onclick="showAnswer()">
                        <div class="div-content">
                            <h1>Q${i.id}: ${i.detail}</h1>
                            <p>A.${i.answerA}</p>
                            <p>B.${i.answerB}</p>
                            <p>C.${i.answerC}</p>
                            <p>D.${i.answerD}</p>
                        </div>
                    </div>
                    <div class="answer question" onclick="showAnswer()" id="answer">
                        <p
                            style="text-align: center; margin-top: calc(450px * 0.5 - 44.79px); transform: translate(0); font-size: 35px; font-weight: bold;">
                            ${i.trueAnswer}</p>
                    </div>

                </div>
            </c:forEach>
            <div style="display: flex; flex-direction: column" class="option">
                <div class="option-test">
                    <a href=""><i class="fa fa-solid fa fa-graduation-cap"></i>Test</a>
                </div>
                <div class="option-edit">
                    <a href=""><i class="fa fa-solid fa fa-pen"></i>Edit</a>
                </div>
                <div class="option-copy_paste">
                    <a href=""><i class="fa fa-solid fa fa-copy"></i>Copy-New</a>
                </div>
            </div>
        </div>

        <div class="paggingmanage">

            <div class="pagging active">
                <a href="collection"><<</a>  
            </div>
            <div class="pagging">
                <a href="collection?numPage==<fmt:formatNumber value="${(numPage!=1)?(numPage-1):1}" type="number" pattern="###"/>  "><</a> 
            </div>
            <div class="pagging">
                ${numPage}  
            </div>
            <div class="pagging">
                <a href="collection?numPage=<fmt:formatNumber value="${(numPage!=lastPage)?(numPage+1):lastPage}" type="number" pattern="###"/> ">></a>
            </div>
            <div class="pagging">
                <a href="collection?numPage=${lastPage}">>></a>
            </div>
        </div>

        <c:forEach items="${list}" var="i">
            <div class="learning">
                <div class="learning-content">
                    <p>Q${i.id}: ${i.detail}</p>
                    <p>A.${i.answerA}</p>
                    <p>B.${i.answerB}</p>
                    <p>C.${i.answerC}</p>
                    <p>D.${i.answerD}</p>                  
                </div>
                <div class="leaning-anwser">
                    <p> ${i.trueAnswer}</p>    
                </div>
            </div>
        </c:forEach>
        <script>
            function showAnswer(questionNumber) {
                var answera = document.getElementById(a);
                var answerElement = document.getElementById('answer');

                if (answerElement.style.display === "none") {
                    a.style.display = "none";
                    answerElement.style.display = "block";
                    answerElement.style.textAlign = "center";
                } else {
                    answerElement.style.display = "none";
                    a.style.display = "block";
                }
            }

        </script>
    </body>
</html>
