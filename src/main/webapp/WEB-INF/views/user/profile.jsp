<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%-- <div class="col-sm-8 col-sm-offset-2">
	<div class="list-group">
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">Image</h4>
		<p class="list-group-item-text">
		<img alt="Profile" src="data:image/png; base64, ${imageSrc}" width="300px"></p>
				</a>
		
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">User name</h4>
			<p class="list-group-item-text">
			${userProfile.firstName} ${userProfile.lastName}</p>
		</a> 
		
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">User email</h4>
			<p class="list-group-item-text">${userProfile.email }</p>
		</a>
		
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading"></h4>
			<p class="list-group-item-text">
				<a href="/user/edit/${userProfile.id}" class="btn btn-warning btn-block">Edit user profile</a>
			</p>
		</a>
		
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading"></h4>
			<p class="list-group-item-text">
				<a href="/user/${userProfile.id}/create" class="btn btn-success btn-block">Create advertisement</a>
			</p>
		</a>
	</div>
</div> --%>







  <!------------- MAIN PAGE CONTENT AREA --------->
 <div class="site-panel"style="margin-top:110px">
    <div class="container">
        <div class="row">
                <div class="col-md-3 well hidden-xs">
                    <div class= "sidebar">
                        <div class="list-group">
  <a href="/user" class="list-group-item active">My Profile</a>
  <a href="/user/${userProfile.id}/create" class="list-group-item">Create Order</a>
  <a href="/user/edit/${userProfile.id}" class="list-group-item">Upgrade profile</a>
    <a href="/user/activityorder" class="list-group-item">My Activity Order</a>
  <a href="/user/history" class="list-group-item">History</a>
 
</div> 
                    </div>
                </div>
                <div class="col-md-9 ">
                    <div class= "content-box well">
                     <legend>My Profile  </legend>
                     
                    <div class="col-sm-8 col-sm-offset-2">
	<div class="list-group">
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">Image</h4>
		<p class="list-group-item-text">
		<img alt="Profile" src="data:image/png; base64, ${imageSrc}" width="300px"></p>
				</a></div></div>

<div class="container">
	<div class="row">
		<div class="col-md-6">
		    <div class=" clearfix">
		        <h3>Name:	${userProfile.firstName} </h3>
		              <h3>Second Name:	${userProfile.lastName} </h3>
		    
		       
 
                 	<a href="/user/edit/${userProfile.id}" class="btn btn-success btn-md pull-center">Edit user profile</a>
		       <hr>

	
				<a href="/user/${userProfile.id}/create" class="btn btn-success btn-block">Create advertisement</a>
			</div></div>
		<div class="col-md-6 hidden-xs">
		    <i class="fa fa-user x10"></i>
		</div>
	</div>
</div>
                     


          
                    </div>
    </div>
        </div>
    </div>
 </div>
 





 <%--  <c:forEach items = "${findAllActivityOrder}" var = "activityOrder">
<div class="container">
<div class="row">

<table class="table table-bordered">
<thead>
<tr>

<th>${activityOrder.name} </th>
<th>${activityOrder.price} </th>
<th>${activityOrder.date} </th>
 <th>${activityOrder.stickerImage} </th>
<th><img alt="Profile" src="data:image/png; base64, ${activityOrder.stickerImage}" width="100px"></th>

<th> <a href="${pageContext.request.contextPath}/user/finalyBuy/${activityOrder.id}">Buy</a></th>
<th> <a href="${pageContext.request.contextPath}/user/finalyReturn/${activityOrder.id}">Return</a></th>
</tr></thead></table></div></div>
</c:forEach>  --%>