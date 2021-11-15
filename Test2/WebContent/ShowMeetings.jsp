<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="util.MyDBconnectionUtil" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<title>Meeting Details</title>
<style>
		#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #8c8c8c;
    color: white;
}
</style>
<link href="Styles/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="Styles/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav sidebar sidebar-dark accordion" id="accordionSidebar" style = "background-color: #212529">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="FrontPage.jsp">

        <div class="sidebar-brand-text mx-3">Procons Infotech</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="FrontPage.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

  
     

      <div class="sidebar-heading">
        Pages
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      
     <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseuser" aria-expanded="true" aria-controls="collapseuser">
          <i class="fas fa-fw fa-address-card"></i>
          <span>User</span>
        </a>
        <div id="collapseuser" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">User</h6>
            <a class="collapse-item" href="Register.jsp">Add New User</a>
            <a class="collapse-item" href="UserList.jsp">User Details</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Charts -->
      
	  <li class="nav-item">
        <a class="nav-link" href="Positions.jsp">
          <i class="fas fa-fw fa-male"></i>
          <span>Positions</span></a>
      </li>
      
       <li class="nav-item">
        <a class="nav-link" href="UserLevel.jsp">
          <i class="fas fa-fw fa-level-up-alt"></i>
          <span>User Levels</span></a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseleavels" aria-expanded="true" aria-controls="collapseleavels">
          <i class="fas fa-fw fa-door-open"></i>
          <span>Leaves</span>
        </a>
        <div id="collapseleavels" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Leaves - For User</h6>
            <a class="collapse-item" href="ApplyLeaves2.jsp">Apply for Leaves</a>
            <h6 class="collapse-header">Leaves - For Admin</h6>
            <a class="collapse-item" href="Leaveapprove.jsp">Leave Approval</a>
            <a class="collapse-item" href="MannualLeaveAdd.jsp">Manual Leaves</a>
            <a class="collapse-item" href="LeaveTableView.jsp">Leave Table</a>
          </div>
        </div>
      </li>
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSal" aria-expanded="true" aria-controls="collapseSal">
          <i class="fas fa-fw fa-money-check-alt"></i>
          <span>Salary</span>
        </a>
        <div id="collapseSal" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Salary</h6>
            <a class="collapse-item" href="ListMasterSalaryInfo.jsp">Basic Salary Details</a>
            <a class="collapse-item" href="DisplaySalary.jsp">Add Salary Details</a>
          </div>
        </div>
      </li>
      
      
      
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseMeetings" aria-expanded="true" aria-controls="collapseMeetings">
          <i class="fas fa-fw fa-calendar-alt"></i>
          <span>Meetings</span>
        </a>
        <div id="collapseMeetings" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Meetings</h6>
            <a class="collapse-item" href="Tem.jsp">Add a Meeting</a>
            <a class="collapse-item" href="ShowMeetings.jsp">Meeting Details</a>
          </div>
        </div>
      </li>
      
      
      <li class="nav-item">
        <a class="nav-link" href="AttenMan.jsp">
          <i class="fas fa-fw fa-check-circle"></i>
          <span>Attendance</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MainEmail.jsp">
          <i class="fas fa-fw fa-mail-bulk"></i>
          <span>Mail</span></a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseProfile" aria-expanded="true" aria-controls="collapseProfile">
          <i class="fas fa-fw fa-chalkboard-teacher"></i>
          <span>User profile & Promotion</span>
        </a>
        <div id="collapseProfile" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">User profile & Promotion</h6>
            <a class="collapse-item" href="FinalUserprofile.jsp">User Profile</a>
            <a class="collapse-item" href="FinalPromotion.jsp">Promotion</a>
          </div>
        </div>
      </li>
      
      
      

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand topbar mb-4 static-top" style = "background-color: #212529">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>
            </div>
          </form>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>

            <!-- Nav Item - Alerts -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">3+</span>
              </a>
              <!-- Dropdown - Alerts -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                  Alerts Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 12, 2019</div>
                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-success">
                      <i class="fas fa-donate text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 7, 2019</div>
                    $290.29 has been deposited into your account!
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-warning">
                      <i class="fas fa-exclamation-triangle text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">December 2, 2019</div>
                    Spending Alert: We've noticed unusually high spending for your account.
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
              </div>
            </li>

            <!-- Nav Item - Messages -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Messages -->
                <span class="badge badge-danger badge-counter">7</span>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                <h6 class="dropdown-header">
                  Message Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div class="font-weight-bold">
                    <div class="text-truncate">Hi there! I am wondering if you can help me with a problem I've been having.</div>
                    <div class="small text-gray-500">Emily Fowler · 58m</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
                    <div class="status-indicator"></div>
                  </div>
                  <div>
                    <div class="text-truncate">I have the photos that you ordered last month, how would you like them sent to you?</div>
                    <div class="small text-gray-500">Jae Chun · 1d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
                    <div class="status-indicator bg-warning"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Last month's report looks great, I am very happy with the progress so far, keep up the good work!</div>
                    <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</div>
                    <div class="small text-gray-500">Chicken the Dog · 2w</div>
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
              </div>
            </li>

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">User</span>
                <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Meeting Schedules</h1>
          </div>
          
          
          
          
          
         <table id="customers">
		<tr>
			<th>MeetingID</th>
			<th>Date</th>
			<th>Description</th>
			<th>Location</th>
			<th>Start-time</th>
			<th>End-Time</th>
			<th>Initiator</th>
			<th>Created-dateTime</th>
			<th>Updated-dateTime</th>
		</tr>
		
	<% 
	
	Connection con =null;
	PreparedStatement ps = null;
	
	String sql = "select * from meetings";
		
	
	try {
		con = new MyDBconnectionUtil().getDBconnection();
		ps = con.prepareStatement(sql);
		ResultSet rs1= ps.executeQuery();
		
		while(rs1.next()) {
			System.out.println(rs1.getString(1));
			%>
			<tr>
				<td><%=rs1.getString(1)%></td>
				<td><%=rs1.getString(2)%></td>
				<td><%=rs1.getString(3)%></td>
				<td><%=rs1.getString(4)%></td>
				<td><%=rs1.getString(5)%></td>
				<td><%=rs1.getString(6)%></td>
				<td><%=rs1.getString(7)%></td>
				<td><%=rs1.getString(8)%></td>
				<td><%=rs1.getString(9)%></td>
			
		</tr>
				
			<%
		}
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	%>
	
	
	</table>
	
	<br>
	<br>
	<br>
	<br>
	<div class="text-center">
	 <h1 class="h3 mb-0 text-gray-800">Delete Meetings</h1>
	</div>
	 <br>
	 <br>
	 
	 <div class="row justify-content-center">
            <form action="Delmeetings" style="border-style: groove;height:100px;width:300px" align="center" method="POST">
		
			<h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">Enter Meeting ID</h4>
			<hr>
  			<input list="browsers" name="voter">
  			<datalist id="browsers">
  			<% 
	
	 con =null;
	 ps = null;
	
	 String sql1 = "select * from meetings";
		
	
	try {
		con = new MyDBconnectionUtil().getDBconnection();
		ps = con.prepareStatement(sql);
		ResultSet  rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
			%>
			
			   <option width="100%" value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>	
			<%
		}
		
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	%>
	
  			
   				
   				 
 		 </datalist>
  	
  <input type="submit" value="Delete">
  
  
 
  
  
  
</form>

</div>
<hr>
<h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">${delete}<h4>

<br>
	<br>
	<br>
	<br>


<!-- 
    <h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">${delete}<h4>
            
                <form action ="Updatemeetings" method="post">
    <br>
	<br>
	<br>
	<br>
	
	 <h1 class="h3 mb-0 text-gray-800">Update Meetings</h1>
	<br>
	<br>
		 
        <input type="text" placeholder="Enter MeetingID here" name="meetID">
         <br>
         <br>
         <input type="text" placeholder="description" name="description">
         <br>
         <br>
         <input type="text" placeholder="location" name="location">
         <br>
         <br>
         <input type="date" placeholder="date" name="date">
         <br>
         <br>
         <input type="time" placeholder="start_time" name="start_time">
         <br>
         <br>
         <input type="time" placeholder="end_time" name="end_time">
         <br>
         <br>
         <input type="text" placeholder="initiator" name="initiator">
         <br>
         <br>
         <input type="submit" placeholder="Edit" name="edit">
     </form>
     
      -->
      
      <hr>
     
     <div>

			    <div class="card o-hidden border-0 shadow-lg my-5" style="width: 70rem;">
			      <div class="card-body p-5">
			        <!-- Nested Row within Card Body -->
			        <div class="row justify-content-center">
			          <div class="col-lg-7">
			            <div class="p-5">
			              <div class="text-center">
			                <h1 class="h4 text-gray-900 mb-4">Update Meetings</h1>
			              </div>
			              
			              <h4 style="font-family: Trebuchet MS", Arial, Helvetica, sans-serif;">${update}<h4>
			              
			              
			              <form class="user" method="post" action ="Updatemeetings">
			              
			                <div class="form-group">
			                  <input type="text" class="form-control form-control-user" placeholder="Enter MeetingID here.." name="meetID">
			                </div>
			              
			                <div class="form-group">
			                  <input type="text" class="form-control form-control-user" name="description" id="description" placeholder="Description...">
			                </div>
			                
			                <div class="form-group">
			                  <input type="text" class="form-control form-control-user" name="location" id="location" placeholder="Location..">
			                </div>
			                
			                <div class="form-group">
			                  <input class="form-control form-control-user" type="date" name="date" id="date" placeholder="Date..">
			                </div>
			                
			                <div class="form-group">
			                  <input class="form-control form-control-user" type="time" placeholder="Start time.." name="start_time" id="start_time">
			                </div>
			                
			                <div class="form-group">
			                  <input class="form-control form-control-user" type="time" placeholder="End time.." name="end_time" id="end_time">
			                </div>
			                
			                <div class="form-group">
			                  <input type="text" class="form-control form-control-user" type="text" placeholder="Initiator.." name="initiator" id="initiator">
			                </div>
			                
			                
			            	<button type="submit" class="btn btn-primary btn-user btn-block">Save</button>
			                
			                <hr>
			              </form>
			              <br>
			              <br>
			              <br>
			              
			              
			            </div>
			          </div>
			        </div>
			      </div>
			    </div>
			
			  </div>
             


			
                  
       
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="Styles/vendor/jquery/jquery.min.js"></script>
  <script src="Styles/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="Styles/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="Styles/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="Styles/vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="Styles/js/demo/chart-area-demo.js"></script>
  <script src="Styles/js/demo/chart-pie-demo.js"></script>

</body>
</html>