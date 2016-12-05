<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=utf-8"%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="../vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="mainpage.jsp">說說茶飲</a>
            </div>
            
                    
                        
        

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        <li>
                            <a href="mainpage.jsp"><i class="fa fa-dashboard fa-fw"></i> 點餐介面</a>
                        </li>

                        <li>
                            <a href="inventoryorder.jsp"><i class="fa fa-table fa-fw"></i> 進貨單</a>
                        </li>
                        <li>
                            <a href="inventoryleft.jsp"><i class="fa fa-edit fa-fw"></i> 庫存剩餘數量</a>
                        </li>
                        <li>
                            <a href="worktime.jsp"><i class="fa fa-edit fa-fw"></i> 打卡</a>
                        </li>
                        <li>
                            <a href="Mproductmanage.jsp"><i class="fa fa-edit fa-fw"></i> 產品管理</a>
                        </li>
                        <li>
                            <a href="Memployeemanage.jsp"><i class="fa fa-edit fa-fw"></i> 員工管理</a>
                        </li>
                        <li>
                            <a href="index.jsp"><i class="fa fa-edit fa-fw"></i> 登出</a>
                        </li>
                        
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">進貨單介面</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

            <div class="container">
        <div class="row">
            
                <a class="btn btn-primary" href="inventoryorderadd.jsp">新增</a>
                <br>
                </br>
                 <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>

                                    <tr>
                                        <th>編號</th>
                                        <th>項目</th>
                                        <th>數量</th>
                                        <th>訂貨時間</th>
                                        <th>訂貨人員</th>
                                        <th>管理</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="odd gradeX">
                                        <td>Trident</td>
                                        <td>Internet Explorer 4.0</td>
                                        <td>Win 95+</td>
                                        <td class="center">4</td>
                                        <td class="center">X</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="even gradeC">
                                        <td>Trident</td>
                                        <td>Internet Explorer 5.0</td>
                                        <td>Win 95+</td>
                                        <td class="center">5</td>
                                        <td class="center">C</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>

                                    </tr>
                                    <tr class="odd gradeA">
                                        <td>Trident</td>
                                        <td>Internet Explorer 5.5</td>
                                        <td>Win 95+</td>
                                        <td class="center">5.5</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    
                                    
                                    <tr class="gradeA">
                                        <td>Gecko</td>
                                        <td>Epiphany 2.20</td>
                                        <td>Gnome</td>
                                        <td class="center">1.8</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="gradeA">
                                        <td>Webkit</td>
                                        <td>Safari 1.2</td>
                                        <td>OSX.3</td>
                                        <td class="center">125.5</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="gradeA">
                                        <td>Webkit</td>
                                        <td>Safari 1.3</td>
                                        <td>OSX.3</td>
                                        <td class="center">312.8</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="gradeA">
                                        <td>Webkit</td>
                                        <td>Safari 2.0</td>
                                        <td>OSX.4+</td>
                                        <td class="center">419.3</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="gradeA">
                                        <td>Webkit</td>
                                        <td>Safari 3.0</td>
                                        <td>OSX.4+</td>
                                        <td class="center">522.1</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="gradeA">
                                        <td>Gecko</td>
                                        <td>Epiphany 2.20</td>
                                        <td>Gnome</td>
                                        <td class="center">1.8</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="gradeA">
                                        <td>Webkit</td>
                                        <td>Safari 1.2</td>
                                        <td>OSX.3</td>
                                        <td class="center">125.5</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="gradeA">
                                        <td>Webkit</td>
                                        <td>Safari 1.3</td>
                                        <td>OSX.3</td>
                                        <td class="center">312.8</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="gradeA">
                                        <td>Webkit</td>
                                        <td>Safari 2.0</td>
                                        <td>OSX.4+</td>
                                        <td class="center">419.3</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                    <tr class="gradeA">
                                        <td>Webkit</td>
                                        <td>Safari 3.0</td>
                                        <td>OSX.4+</td>
                                        <td class="center">522.1</td>
                                        <td class="center">A</td>
                                        <td>
                                <a class="btn btn-default" href="inventoryorderchange?id=${inventory.id}">修改</a>
                                <a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${inventory.id}">刪除</a>
                            </td>
                                    </tr>
                                </tbody>
                            </table>
                    <c:forEach items="${inventoryList}" var="inventory">
                        <tr>
                            <td>${inventoryorder.id}</td>
                            <td>${inventoryorder.name}</td>
                            <td>${inventoryorder.number}</td>  
                            <td>${inventoryprder.ordertime}</td>
                            <td>${inventoryorder.orderpeople}</td>
                            
                            
                        </tr>
                    </c:forEach>
               
            </div>
        </div>
    </div>
    <div class="modal fade bs-example-modal-sm" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">刪除</h4>
                </div>
                <div class="modal-body">
                    <p>確認刪除後，相關之訊息也將刪除</p>
                </div>
                <div class="modal-footer">
                    <form id="deleteForm" action="deleteProduct" method="post">
                        <input type="hidden" name="id" id="deleteID">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-danger">確認刪除</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
            

            <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../vendor/raphael/raphael.min.js"></script>
    <script src="../vendor/morrisjs/morris.min.js"></script>
    <script src="../data/morris-data.js"></script>
    <script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    <script src="../dist/js/sb-admin-2.js"></script>
      <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>