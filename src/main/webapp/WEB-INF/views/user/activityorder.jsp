
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>My Acivity Order </h1>
<h3>User email = ${name}</h3>

  <c:forEach items = "${findAllActivityOrder}" var = "activityOrder">
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
</c:forEach>