<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<ul>
	<c:forEach items="${carList}" var="car">
		<li>
			<img alt="car" src="data:image/png;base64, ${sticker.stickerImage}" width="300px">
			| ${sticker.name} | ${sticker.price } | ${sticker.user.firstName}
		</li>
	</c:forEach>
</ul>