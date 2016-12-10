<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>mainpage</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/dashboard.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>
    </head>

    <body>
                        <%@include file="navbar.jspf" %>

                <div class="col-sm-9 col-sm-offset-3 col-md-12 col-md-offset-2 main">
                    <h2>功能選擇</h2>
                    <div class="col-sm-9 btn-lg btn-primary" id="optionselect">
                        <a href="productSale" role="button">
                            <p>點餐介面</p>
                        </a>
                    </div>
                    <div class="col-sm-9 btn-lg btn-primary" id="optionselect">
                        <a href="#" role="button">
                            <p>上班打卡</p>
                        </a>
                    </div>
                    <div class="col-sm-9 btn-lg btn-primary" id="optionselect">
                        <a href="#" role="button">
                            <p>下班打卡</p>
                        </a>
                    </div>
                    <div class="col-sm-9 btn-lg btn-primary" id="optionselect">
                        <a href="productManage" role="button">
                            <p>產品管理</p>
                        </a>
                    </div>
                    <div class="col-sm-9 btn-lg btn-primary" id="optionselect">
                        <a href="inventoryManage" role="button">
                            <p>存貨管理</p>
                        </a>
                    </div>
                    
                    <div class="col-sm-9 btn-lg btn-primary" id="optionselect">
                        <a href="#" role="button">
                            <p>補打卡</p>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <!-- Bootstrap core JavaScript
    ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
        </script>
        <script src="../../dist/js/bootstrap.min.js"></script>
        <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
        <script src="../../assets/js/vendor/holder.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>

    </html>