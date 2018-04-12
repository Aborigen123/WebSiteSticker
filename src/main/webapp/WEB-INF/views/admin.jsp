
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Admin</h1>

<sec:authorize access="isAuthenticated()">

<sec:authorize access="hasRole('ROLE_ADMIN')">
<h4>Admin + </h4>
</sec:authorize>

</sec:authorize>

<h2>All users</h2>
<c:forEach items = "${findAllUsers}" var = "user">
<div class="container">
<div class="row">

<table class="table table-bordered">
<thead>
<tr>

<th>${user.id} </th>
<th>${user.email} </th>
<th>${user.firstName} </th>
<th>${user.lastName} </th>
<th>${user.role}</th>
<th>${user.block}</th>
<th> <a href="${pageContext.request.contextPath}/adminun/${user.id}">unblock</a></th>
<th> <a href="${pageContext.request.contextPath}/admin/${user.id}">block</a></th>
<%-- <th><a href="${pageContext.request.contextPath}/delete">block</a></th> --%>
</tr></thead></table></div></div>
</c:forEach>
