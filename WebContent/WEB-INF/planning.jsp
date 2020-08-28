<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="planning" />
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
                  <h6 class="m-0 font-weight-bold text-primary">Planning</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
  					<div id='calendar'></div>
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

</body>
</html>

<script>
document.addEventListener('DOMContentLoaded', function() {
	
	  var calendarEl = document.getElementById('calendar');

	  var calendar = new FullCalendar.Calendar(calendarEl, {
	    headerToolbar: {
	      left: 'prev,next today',
	      center: 'title',
	      right: 'addEventButton'
	    },
	    themeSystem: 'bootstrap',
	    locale: 'fr',
	    slotMinTime: '07:30:00',
	    slotMaxTime: '17:30:00',
	    minTime : '08:30',
	    weekends: false,
		firstDay : 1,
		initialView: 'timeGridWeek',
	    navLinks: true, // can click day/week names to navigate views
	    businessHours: true, // display business hours
	    editable: true,
	    selectable: true,
	    customButtons: {
		      addEventButton: {
		        text: 'Ajouter un cours',
		        click: function() {
		          var dateStr = prompt('Entrer une date au format YYYY-MM-DD HH:MM');
		          var date = new Date(dateStr + ':00'); // will be in local time
		          
		          var titreStr = prompt('Entrer un titre');

		          if (!isNaN(date.valueOf())) { // valid?
		            calendar.addEvent({
		              title: titreStr,
		              start: date,
		              allDay: false
		            });
		          //Update the database
		            alert('Great. Now, update your database...');
		          } else {
		            alert('Date invalide.');
		          }
		        }
		      }
		    },
	    businessHours: {
	    	  daysOfWeek: [ 1, 2, 3, 4, 5 ], // Monday - Thursday

	    	  startTime: '8:30', // a start time (10am in this example)
	    	  endTime: '16:30', // an end time (6pm in this example)
	    	},
	    events: [
	      {
	        title: 'Business Lunch',
	        start: '2020-06-03T13:00:00',
	        constraint: 'businessHours'
	      },
	      {
	        title: 'Meeting',
	        start: '2020-06-13T11:00:00',
	        constraint: 'availableForMeeting', // defined below
	        color: '#257e4a'
	      },
	      {
	        title: 'Conference',
	        start: '2020-06-18',
	        end: '2020-06-20'
	      },
	      {
	        title: 'Party',
	        start: '2020-06-29T20:00:00'
	      },

	      // areas where "Meeting" must be dropped
	      {
	        groupId: 'availableForMeeting',
	        start: '2020-06-11T10:00:00',
	        end: '2020-06-11T16:00:00',
	        display: 'background'
	      },
	      {
	        groupId: 'availableForMeeting',
	        start: '2020-06-13T10:00:00',
	        end: '2020-06-13T16:00:00',
	        display: 'background'
	      },

	      // red areas where no events can be dropped
	      {
	        start: '2020-06-24',
	        end: '2020-06-28',
	        overlap: false,
	        display: 'background',
	        color: '#ff9f89'
	      },
	      {
	        start: '2020-06-06',
	        end: '2020-06-08',
	        overlap: false,
	        display: 'background',
	        color: '#ff9f89'
	      }
	    ]
	  });

	  calendar.render();

	});
</script>