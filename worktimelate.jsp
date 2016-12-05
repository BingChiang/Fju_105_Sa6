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
                    <h1 class="page-header">補打卡介面</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="container">
        <div class="row">
            <br>
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <form method="post" action="worktime.jsp" id="insertForm">
                
                    <div class="form-group">
                    <label>員工:</label>
                        <input type="text" name="desc" placeholder="員工" required>
                        </div>
                        <div class="form-group">
                        <label>時間:</label>
                        <input type="text" name="desc" placeholder="時間" required>
                        
                    </div>
                    <div class="form-group">
                    <label>上下班:</label>
                        <select id=type name="type" onchange="updateData(this)">
      <option value="">請選擇</option>
      <option value="1">上班</option>
      <option value="2">下班</option>
     
    </select>
                        </div>
                        
                    
                    <button type="submit" class="btn btn-default">新增</button>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>
    </div>
    </div><!-- /.container -->
            

            <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../vendor/raphael/raphael.min.js"></script>
    <script src="../vendor/morrisjs/morris.min.js"></script>
    <script src="../data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>