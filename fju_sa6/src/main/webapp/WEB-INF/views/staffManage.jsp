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
        <title>mainpag</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/dashboard.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>
    </head>

    <body>
                        <%@include file="navbar.jspf" %>

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-top:30px;">
                    <div class="col-md-7">
                        <h2>員工管理</h2></div>
                    <div class="col-md-3"><a href="#"><button class="btn btn-primary" id="addStaff">新增員工</button></a></div>
                    <table class="table table-striped">
                        <tr>
                            <th>員工編號</th>
                            <th>員工名稱</th>
                            <th>員工階級</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td>0001</td>
                            <td>name</td>
                            <td>一般員工</td>
                            <td><span style="margin-top:-5px;" class="badge"><a class="inline" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true" style="color:white;"></span></a>
                                </span> <span style="margin-top:-5px;" class="badge"><a class="inline" href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true" style="color:white;"></span></a>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td>0002</td>
                            <td>name2</td>
                            <td>一般員工</td>
                            <td><span style="margin-top:-5px;" class="badge"><a class="inline" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true" style="color:white;"></span></a>
                                </span> <span style="margin-top:-5px;" class="badge"><a class="inline" href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true" style="color:white;"></span></a>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td>0003</td>
                            <td>name3</td>
                            <td>一般員工</td>
                            <td><span style="margin-top:-5px;" class="badge"><a class="inline" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true" style="color:white;"></span></a>
                                </span> <span style="margin-top:-5px;" class="badge"><a class="inline" href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true" style="color:white;"></span></a>
                                </span>
                            </td>
                        </tr>
                    </table>
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