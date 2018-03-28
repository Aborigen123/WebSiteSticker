<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<nav  id="header" class="navbar navbar-dark bg-success"  ><!-- //class="navbar navbar-default" style="color:#33cc33"-->
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
      
    </div>

    <div class="collapse navbar-collapse"  id="bs-example-navbar-collapse-2" >
      <ul class="nav navbar-nav" >
       <li><a href="/"><h4 style="color:#ffffff">Home</h4><span class="sr-only">(current)</span></a></li>
       <li class="dropdown" >
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><p style="color:#ffffff">About shop</p><span class="caret" style="color:#ffffff"></span></a>
          <ul class="dropdown-menu" role="menu" >
            <li><a href="/aboutshop/ourcontacts"><p style="color:#ffffff">Our contacts</p></a></li>
            <li><a href="#"><p style="color:#ffffff">Discounts</p></a></li>
            <li><a href="/aboutshop/aboutus" ><p style="color:#ffffff">About us</p></a></li>
          </ul>
           </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"  style="color:#ffffff">Service <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="/service/deliverys"><p style="color:#ffffff">Deliverys</p></a></li>
            <li><a href="/service/payandret"><p style="color:#ffffff">Payment and return</p></a></li>
          </ul>
           </li>
      
      </ul>
     <div class="col-sm-4">
       <div class="nav navbar-nav navbar-center" id="bs-example-navbar-collapse-2" style="color:#ffffff; text-align:center">
                     Phone counseling:<br>
           (044) 000-00-00, (044) 000-00-00
            </div>
</div>
 
           
        <ul class="nav navbar-nav navbar-right" style="width: 300px;" >
     
			<sec:authorize access="!isAuthenticated()">
			
		            <li><a href="/login"  style="color:#ffffff"><span class="glyphicon glyphicon-log-in"  style="color:#ffffff"></span>Login</a></li>
		            <li class="divider"></li>
		            <li><a href="/register"  style="color:#ffffff"><span class="glyphicon glyphicon-user" style="color:#ffffff"></span>Register</a></li>	
		            </	
		     </sec:authorize>
		     
		     <sec:authorize access="isAuthenticated()">
		     		<sec:authentication property="principal.username" var="username"/>
	     			<li><a href="/user" style="color:#ffffff">${username}</a></li>

					<c:url var="logoutUrl" value="/logout" />
					<form:form action="${logoutUrl}" method="post" cssStyle="padding-top: 7px;">
						<li><input class="btn btn-danger" type="submit" value="logout" /></li>
					</form:form>
			</sec:authorize>
      </ul>
    </div>
  </div>
</nav>
