
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Admin</h1>

<sec:authorize access="isAuthenticated()">

<sec:authorize access="hasRole('ROLE_ADMIN')">
<h4>Admin + </h4>
</sec:authorize>

</sec:authorize>
<ul>
<h2>All users</h2>
<c:forEach items = "${findAllUsers}" var = "user">
<li>${user.id} | ${user.email} | ${user.firstName} | ${user.lastName} | ${user.age}| ${user.role} | ${user.phoneNumber} |<br>
<a href="${pageContext.request.contextPath}/delete/${user.id}">block</a>
</li>
</c:forEach>
</ul>