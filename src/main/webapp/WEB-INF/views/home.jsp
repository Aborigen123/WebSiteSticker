<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
  <script src="${rootUrl}/resources/js/axios.min.js"></script>
<script src="${rootUrl}/resources/js/vue.min.js"></script>
  <script>
new Vue({
	el: "#app",
	data:{
		carEntitys: [],
		serverUrl: "http://localhost:8080/api/v1"
	},
	methods: {
		
	function handSelect(myForm){
		var selindex = myForm.selectList.selectedIndex;
		var choose = myForm.selectList.[selindex].name;
	}
	mounted(){
		this.getCarEntitys();
		
	}
	
});
</script>
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  -->
<div class="panel panel-default">
  <div class="panel-body">
    <div class="row">
    <div class="container">
<div class="row">

<img  src="/resources/stiker_logo3.jpg" width="1000"  height= "250"></div>
</div>

<div class="col-md-12">
<div class="panel-body">
       <div class="nav navbar-nav navbar-right">
    	
        <div id = "search" class="nav nav-justified navbar-nav">
 	
            <form class="navbar-form navbar-search" role="search">
                <div class="input-group">
                
 
                    <input type="text" class="form-control">
                
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-search btn-success">
                            <span class="glyphicon glyphicon-search"></span>
                            <span class="label-icon">Search Sticker</span>
                        </button>
                        <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                          <li>
                                <a href="#">
                                 
                                    <span class="label-icon">Search By Carton sticker</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                              
                                <span class="label-icon">Search By Super Heroes Sticker</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>  </div>
            </form>   
         
        </div>
    
    </div>
  </div>

</div></div></div>


<form action="/search">
<input type="text" name="search">
<input type="submit" value="Search">
</form>

 <%-- <div class = "col-3">
<div class="row">
<div class = "col-6 text-center">
<button class="dropdown-toggle btn btn-outline-primary btn-sm" type="button" data-toggle="dropdown">Sort
</button>
<div class="dropdown-menu">
<custom:sort innerHtml="Name asc" paramValue="name"/>
<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
</div>
</div></div></div>  --%>

<%-- <c:forEach items="${stickerList}" var = "stickeName">
${stickeName.id} | ${stickeName.name} | ${stickeName.price}
</c:forEach> --%>

<%--  <--select problem here --%>
	<form action="/select" name="myForm">
<select name="stickerType" id="stickerType"  name="selectList" id="selectList" onchange="handSelect(this.form)" >
    <option value="StickerType" ></option>
    <c:forEach items="${stickerType}" var="value"  >
       <option>${value}</option>
    </c:forEach>
</select>
<input type="submit" value="Choose">
</form>

<!-- 	path="stickerType" id="stickerType" itemValue="stickerType" itemLabel="stickerType"  -->
<%-- <form>
<form:select path="stickerType">
<form:options items="${select}"/>
<input type="submit" value="Select">
</form:select>
</form> --%>

<div class="container">
    <div class="row">
<c:forEach items="${stickerList}" var="sticker">

			<div class="col-sm-6 col-md-4">
				<div class="thumbnail" >
					<h4 class="text-center"><span class="label label-info">Type:${sticker.stickerType} </span></h4>
					<img src="data:image/png;base64, ${sticker.stickerImage}" class="img-responsive">
					
<%-- 						<img alt="sticker" src="data:image/png;base64, ${sticker.stickerImage} class="img-responsive"> --%>
						
					<div class="caption">
						<div class="row">
							<div class="col-md-6 col-xs-6">
								<h3>${sticker.name}</h3>
							</div>
							<div class="col-md-6 col-xs-6 price">
								<h3>
								<label>Topic sticker: ${sticker.price}</label></h3>
							</div>
						</div>
						<p>Description sticker:${sticker.aboutSticker}</p>
						<p>User seller:${sticker.user.firstName}</p>
					<sec:authorize access="isAuthenticated()">
						<div class="row">
							<div class="col-md-6">
								<a class="btn btn-primary btn-product"><span class="glyphicon glyphicon-thumbs-up"></span>add to basket</a> 
							</div>
							<c:choose>
							<c:when test="${!sticker.user.block}">
							<div class="col-md-6">
								<a href="${pageContext.request.contextPath}/buy/${sticker.id}" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</a></div>
						</c:when>
						<c:otherwise>
							<div class="col-md-6">
						<a href="/buy" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> You block</a></div>
						</c:otherwise>
							</c:choose>
						</div>
					</sec:authorize>

						<p> </p>
					</div></div></div>
			
			</c:forEach></div>
<br>


<c:url var = "firstUrl" value="/pages?page=0" />
<c:url var = "lastUrl" value="/pages?page=${stickersList.totalPages}" />
<c:url var = "prevUrl" value="/pages?page=${currentIndex - 1}" />
<c:url var = "nextUrl" value="/pages?page=${currentIndex + 1}" />

<div class = "container">
<div class="row">
<ul class = "pagination">
<c:choose>
<c:when test="${currentIndex == 0}">
<li class = "disabled"><a href="#">&lt;&lt;</a></li>
<li class = "disabled"><a href="#">&lt;</a></li>
<li class = "active"><a href="${firstUrl}">1</a></li>
</c:when>
<c:otherwise>
<li><a href="${firstUrl}">&lt;&lt;</a></li>
<li><a href="${prevUrl}">&lt;</a></li>
</c:otherwise>
</c:choose>

<c:forEach var = "i" begin="${beginIndex}" end="${endIndex}">
<c:url var = "pageUrl" value="${pageContext.request.contextPath}/pages?page=${i+1}"/>
<c:choose>
<c:when test="${i == currentIndex}">
<li class="active"><a href="#"><c:out value="${i+1 }"/></a></li>
</c:when>
<c:otherwise>
<li><a href="${pageUrl}"><c:out value="${i + 1}"/></a></li>
</c:otherwise>
</c:choose>
</c:forEach>

<c:choose>
<c:when test = "${currentIndex == stickersList.totalPages}">
<li class="disabled"><a href="#">&gt;</a></li>
<li class="disabled"><a href="#">&gt;&gt;</a></li>
</c:when>
<c:otherwise>
<li><a href="${nextUrl}">&gt;</a></li>
<li><a href="${lastUrl}">&gt;&gt;</a></li>
</c:otherwise>
</c:choose>
</ul>
</div>
</div></div>
