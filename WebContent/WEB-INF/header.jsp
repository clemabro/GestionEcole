<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.title}</title>
<style type="text/css">
    <%@include file="/ressource/bootstrap/bootstrap.min.css" %>
    <%@include file="/ressource/css/sb-admin-2.min.css" %>
    <%@include file="/ressource/css/font-awesome/all.min.css" %>
    <%@include file="/ressource/datatable/datatables.min.css" %>
    <%@include file="/ressource/notiflix/notiflix-2.4.0.min.css" %>
</style>
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href='ressource/calendar/main.css' rel='stylesheet' />
<script src="ressource/jquery/jquery.min.js"></script>
<script src="ressource/popper/popper.min.js"></script>
<script src="ressource/bootstrap/bootstrap.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="ressource/jquery-easing/jquery.easing.min.js"></script>
<!-- Custom scripts for all pages-->
<script src="ressource/js/sb-admin-2.min.js"></script>
<!-- Page level plugins -->
<script src="ressource/js/chart.min.js"></script>
<script type="text/javascript" src="ressource/datatable/datatables.min.js"></script>
<script src='ressource/calendar/main.js'></script>
<script type="text/javascript" src="ressource/notiflix/notiflix-2.4.0.min.js"></script>
<script type="text/javascript">
var optionDataTable = {
    	"order": [[ 0, "asc" ]],
    	"lengthChange": false,
    	"info" : false,
    	"ordering": false,
    	"searching": false,
    	"language": {
            "zeroRecords": "Aucune donnée",
            "search":         "Rechercher :",
            "info": "Affichage de la page _PAGE_ sur _PAGES_",
            "infoEmpty": "Aucun enregistrement disponible",
            "infoFiltered": "(filtered from _MAX_ total records)",
        	"paginate": {
                    "first":      "Premier",
                    "last":       "Dernier",
                    "next":       "Suivant",
                    "previous":   "Précédent"
                },
        }
    }
    
Notiflix.Notify.Init({
	width:'300px',
	fontSize:'14px',
	timeout:4000,
	messageMaxLength:200,
	titleColor:"#4e73df",
	okButtonBackground:"#4e73df",
	});
	
Notiflix.Confirm.Init({
	titleColor:"#4e73df",
	okButtonBackground:"#4e73df",
});
</script>

<style>

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }

</style>
</head>