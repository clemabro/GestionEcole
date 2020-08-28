<!-- Sidebar -->
   <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

     <!-- Sidebar - Brand -->
     <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<%= request.getContextPath() %>/classe">
       <div class="sidebar-brand-icon">
         <i class="fas fa-school"></i>
       </div>
       <div class="sidebar-brand-text mx-3">Gestion école</div>
     </a>

     <!-- Divider -->
     <hr class="sidebar-divider my-0">

     <!-- Nav Item - Dashboard -->
     <li class="nav-item active">
       <a class="nav-link" href="<%= request.getContextPath() %>/classe">
         <i class="fas fa-users"></i>
         <span>Classes</span></a>
     </li>
     <li class="nav-item active">
       <a class="nav-link" href="<%= request.getContextPath() %>/planning">
         <i class="fas fa-calendar-alt"></i>
         <span>Planning</span></a>
     </li>

   </ul>
   <!-- End of Sidebar -->