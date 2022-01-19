<header style="background-color: #E2E4E1;">
	<script type="text/javascript">pathGlobal = "<%=request.getContextPath()%>";</script>
	<nav
		class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
		<img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 15rem;"
			src="<%=request.getContextPath()%>/recursos/img/CBPEH.png">
        <div class="d-flex justify-content-center">
		<h3 class="d-flex justify-content-center">Plataforma Hidalgo Busca Contigo</h3>
		</div>
		<!-- Topbar Navbar -->
		<ul class="navbar-nav ml-auto">
			<div class="topbar-divider d-none d-sm-block"></div>
<% 
				if(request.getAttribute("nameUser")== null){
				%>
			<!-- Nav Item - User Information -->
			<li class="nav-item dropdown no-arrow">
			<a	class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/login" id="mLogin"
				role="button" aria-haspopup="true"
				aria-expanded="false"> 
				
				<span class="mr-2 d-none d-lg-inline text-gray-600 small">Login</span>
					
			</a>
			</li>
<% }
				if(request.getAttribute("nameUser") != null)
				{
				%>
				<!-- Nav Item - User Information -->
			<li class="nav-item dropdown no-arrow">
			<a	class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/logout" id="mLogin"
				role="button" aria-haspopup="true"
				aria-expanded="false"> 
				
				
					<img class="img-profile rounded-circle"	src="<%=request.getContextPath()%>/recursos/img/undraw_profile.svg">
					<br>
					<span class="mr-2 d-none d-lg-inline text-gray-600 small">Salir</span>
			</a>
			</li>
			<%} %>
		</ul>

	</nav>
</header>