  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<!-- <div class="panel panel-default">
  <div class="panel-body">
    <div class="row">
   		<div class="col-md-10 col-md-offset-1">
    		
   		</div>
    </div>
  </div>
</div> -->
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
						<p>${sticker.aboutSticker}</p>
						<p></p>
						<div class="row">
							<div class="col-md-6">
								<a class="btn btn-primary btn-product"><span class="glyphicon glyphicon-thumbs-up"></span> order</a> 
							</div>
							<div class="col-md-6">
								<a href="#" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</a></div>
						</div>

						<p> </p>
					</div></div></div>
				
			</c:forEach></div></div>
<br>

<%-- <ul>
	<c:forEach items="${stickerList}" var="sticker">
		<li>
			<img alt="sticker" src="data:image/png;base64, ${sticker.stickerImage}" width="300px">
			| ${sticker.name} | ${sticker.price}
		</li>
	</c:forEach>
</ul> --%>