<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Accueil" />
</jsp:include>
<body>
  <!-- Page Wrapper -->
  <div id="wrapper">

    <jsp:include page="sidebar.jsp"></jsp:include>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <jsp:include page="topbar.jsp"></jsp:include>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-flex justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Classe :</h1>
            <select class="form-control col-2 mr-auto ml-4" id="selectClasse">
            	<c:forEach var="classe" items="${listClasses}">
            		<option id="${classe.id}">${classe.nom}</option>
            	</c:forEach>
			</select>
          </div>

          <!-- Content Row -->

          <div class="row">

            <!-- Area Chart -->
            <div class="col-xl col-lg">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">El�ves</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                	<a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-user-plus"></i> Ajouter un �l�ve</a>
                	<div class="table-responsive">
	                 	<table id="tabEleve" class="table table-bordered" width="100%"	cellspacing="0">
	                 		<thead>
	                 			<tr>
	                 				<th>Nom</th>
	                 				<th>Pr�nom</th>
	                 				<th>Date de naissance</th>
	                 				<th>Actions</th>
	                 			</tr>
	                 		</thead>
	                 		<tbody>
	                 		</tbody>
	                 	</table>
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
            <span>Copyright &copy; Your Website 2020</span>
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
            <span aria-hidden="true">�</span>
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
  <script type="text/javascript">
		$(document).ready(function() {
				$('#tabEleve').DataTable(optionDataTable);
		    	reloadTableByIdClasse($('#selectClasse').find(":selected").attr("id"));
		    
		} );
		
		var reloadTableByIdClasse = function(idClasse){
			var table = $("#tabEleve tbody");
		    
		    $.ajax({
		        url: "<%= request.getContextPath() %>/eleveAjax",
		        method: "POST",
		        data : {
		        	"action" : "getAllById",
		        	"id" : idClasse
		        },
		        success: function (data) {
		            table.empty();
		            console.log(data);
		            
		            $.each(data, function (a, b) {
		                table.append("<tr><td>"+b.nom+"</td>" +
		                    "<td>"+b.prenom+"</td>"+
		                    "<td>" + b.dateNaissance + "</td><td></td></tr>");
		            });
		           
		        }
		    });
		}
	</script>
</body>
</html>