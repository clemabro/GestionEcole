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
            <select class="form-control col-2 ml-4" id="selectClasse">
            	<c:forEach var="classe" items="${listClasses}">
            		<option id="${classe.id}" value="${classe.niveau.libelle}">${classe.nom}</option>
            	</c:forEach>
			</select>
			<h4 class="mr-auto ml-4">Niveau de la classe : <i id="niveauClasse"></i></h4>
          </div>

          <!-- Content Row -->

          <div class="row">

            <!-- Area Chart -->
            <div class="col-xl col-lg">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Elèves</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                	<a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" data-toggle="modal" data-target="#modalAjoutEleve" onclick="ajoutEleveModal()"><i class="fas fa-user-plus"></i> Ajouter un élève</a>
                	<div class="table-responsive">
	                 	<table id="tabEleve" class="table table-bordered" width="100%"	cellspacing="0">
	                 		<thead>
	                 			<tr>
	                 				<th>Nom</th>
	                 				<th>Prénom</th>
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

      <jsp:include page="footer.jsp"></jsp:include>

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  
  <div class="modal fade" id="modalAjoutEleve" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold" id="titreModal">Ajouter un élève</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body mx-3">
        <div class="md-form mb-5">
          <label data-error="wrong" data-success="right" for="nomEleve">Nom de l'élève</label>
          <input type="text" id="nomEleve" class="form-control validate">
        </div>
        <div class="md-form mb-5">
          <label data-error="wrong" data-success="right" for="prenomEleve">Prénom de l'élève</label>
          <input type="text" id="prenomEleve" class="form-control validate">
        </div>

        <div class="md-form mb-4">
          <label data-error="wrong" data-success="right" for="dateNaiss">Date de naissance de l'élève</label>
          <input type="date" id="dateNaiss" class="form-control validate">
        </div>
        
        <div class="md-form mb-4">
          	<label for="selectClasseAdd">Classe de l'élève : </label>
          	<select class="form-control" id="selectClasseAdd" disabled>
			</select>
        </div>

      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button id="btnSaveEleve" class="btn btn-primary" onclick="saveEleve(this.id)">Ajouter l'élève</button>
        <button class="btn btn-light" data-dismiss="modal">Annuler</button>
      </div>
    </div>
  </div>
</div>
  <script type="text/javascript">
  		var tableEleve;
  			
		$(document).ready(function() {
				$('#niveauClasse').text($('#selectClasse').find(":selected").attr("value"));
		    	reloadTableByIdClasse($('#selectClasse').find(":selected").attr("id"));
		    	
		    	 $('#selectClasse').on('change', '', function (e) {
		    		 $('#niveauClasse').text($('#selectClasse').find(":selected").attr("value"));
			    	 tableEleve.destroy();
			    	 reloadTableByIdClasse($('#selectClasse').find(":selected").attr("id"));
			    });
		} );
		
		var reloadTableByIdClasse = function(idClasse){
			var table = $("#tabEleve tbody");
		    
		    $.ajax({
		        url: "<%= request.getContextPath() %>/eleveAjax",
		        method: "POST",
		        dataType : "json",
		        data : {
		        	"action" : "getAllById",
		        	"idClasse" : idClasse
		        },
		        success: function (data) {
		            table.empty();
		            console.log(data);
		            
		            $.each(data, function (a, b) {
		                table.append("<tr id='" + b.idEleve + "'><td>"+b.nom+"</td>" +
		                    "<td>"+b.prenom+"</td>"+
		                    "<td>" + b.dateNaissance + "</td>" +
		                    "<td>" +
		                    '<div class="d-flex justify-content-center align-item-center" style="display: block;">'+
								'<i style="color: #4e73df; cursor: pointer" class="fas fa-edit mx-2" onclick="toggleModalForUpdate(this.id)" id="' + b.idEleve + '"></i>'+
								'<i style="color: #dc3545; cursor: pointer" class="far fa-trash-alt mx-2" onclick="demanderSupprEleve(this.id)" id="' + b.idEleve + '"></i>'+
							"</div>" +
		                    "</td></tr>");
		            });
		           
		        }
		    });
		    
		    tableEleve = $('#tabEleve').DataTable(optionDataTable);
		}
		
		var addOptionSelectAdd = function() {
			optionToAdd = $('#selectClasse').find(":selected").clone();
			$('#selectClasseAdd').children().remove();
			$("#selectClasseAdd").append(optionToAdd);
		}
		
		var saveEleve = function(idEleve) {
			var idClasse = $('#selectClasseAdd').find(":selected").attr('id');
			
			$.ajax({
		        url: "<%= request.getContextPath() %>/eleveAjax",
		        method: "POST",
		        data : {
		        	"action" : "saveEleve",
		        	"idClasse" : idClasse,
		        	"idEleve" : idEleve,
		        	"nomEleve" : $('#nomEleve').val(),
		        	"prenomEleve" : $('#prenomEleve').val(),
		        	"dateNaissEleve" : $('#dateNaiss').val()
		        },
		        success: function (data) {
		        	tableEleve.destroy();
		        	reloadTableByIdClasse(idClasse);
		        	$('#modalAjoutEleve').modal('toggle');
		        	clearInputModal();
		        },
		        error : function(e) {
		        	console.log(e)
		        }
		    });
		}
		
		var clearInputModal = function(){
			$('#nomEleve').val("");
			$('#prenomEleve').val("");
			$('#dateNaiss').val("");
		}
		
		var toggleModalForUpdate = function(idEleve) {			
			addOptionSelectAdd()
			$.ajax({
		        url: "<%= request.getContextPath() %>/eleveAjax",
		        method: "POST",
		        data : {
		        	"action" : "getById",
		        	"idEleve" : idEleve
		        },
		        success: function (data) {
		        	console.log(data)
		        	$('#nomEleve').val(data.nom);
					$('#prenomEleve').val(data.prenom);
					$('#dateNaiss').val(data.dateNaissance);
					
					$('#btnSaveEleve').attr("onclick", "saveEleve(" + idEleve + ");");
					$('#btnSaveEleve').text("Modifier l'élève");
					$('#titreModal').text("Modifier l'élève");
					$('#modalAjoutEleve').modal('toggle');
		        }
		    });
		}
		
		var ajoutEleveModal = function() {
			addOptionSelectAdd();
			clearInputModal();
			$('#btnSaveEleve').attr("onclick", "saveEleve(0);");
			$('#titreModal').text("Ajouter l'élève");
			$('#btnSaveEleve').text("Ajouter l'élève");
		}
		
		var demanderSupprEleve = function(idEleve) {
			Notiflix.Confirm.Show('	Supprimer l\'élève',
					'Êtes-vous sûr de supprimer cet élève ?',
					'Supprimer',
					'Annuler',
					function(){
						deleteEleve(idEleve);
					},
					function(){
					});
		}
		
		var deleteEleve = function(idEleve) {
			$.ajax({
		        url: "<%= request.getContextPath() %>/eleveAjax",
		        method: "POST",
		        data : {
		        	"action" : "deleteById",
		        	"idEleve" : idEleve
		        },
		        success: function (data) {
		        	console.log(data)
		        	$('#' + idEleve).fadeOut( 800,
						function() {
							$('#'+ idEleve).remove();
						})
		        }
		    });
		}
	</script>
</body>
</html>