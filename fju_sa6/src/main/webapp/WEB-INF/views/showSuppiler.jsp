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
        <title>showOrder</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/dashboard.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>
    </head>

    <body>
                        <%@include file="navbar.jspf" %>

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-top:30px;">
                    <div class="col-md-12 form-group">
                        <h2>查看供應商供應存貨</h2>
                        <hr> 
                        <h3>供應商名稱：${supplier.supplierName}</h3></div>
                    <table class="table table-striped">
                        <tr>

                            <th>存貨編號</th>
                            <th>存貨名稱</th>
                        </tr>
                        <c:forEach items="${invList}" var="inv">
                        <tr>
                            <td>${inv.inventoryNum}</td>
                            <td>${inv.inventoryName}</td>
                        </tr>
                        </c:forEach>
                    </table>
                    <button class="btn btn-dafault" type="button" onClick="javascript:history.back(1)">按此返回上頁 </button>
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