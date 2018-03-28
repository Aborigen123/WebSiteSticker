<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Create Advertisement</h3>
					<form:form method="POST" 
					action="/user/${advModel.entity.id}/create" 
					modelAttribute="advModel"
					enctype="multipart/form-data">
					
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
							<form:hidden path="entity"/>
							
							<label class="control-label">Sticker name:</label>
							<form:input path="name" cssClass="form-control" />
						
							<label class="control-label">Sticker price:</label>
							<form:input path="price" cssClass="form-control" />
						
  							<label class="control-label">Choose your type sticker</label>
							<form:select path="StickerType" cssClass="form-control">
								<c:forEach items="${stickerTypes}" var="st">
									<form:option value="${st}">${st}</form:option>
								</c:forEach>
							</form:select>
							
							
								<label class="control-label">Choose your topic sticker</label>
							<form:select path="aboutSticker" cssClass="form-control">
								<c:forEach items="${aboutStickers}" var="aboutst">
									<form:option value="${aboutst}">${aboutst}</form:option>
								</c:forEach>
							</form:select>
								
						
							
							<label class="control-label">Sticker Image:</label>
							<form:input path="stickerImage" type="file" cssClass="form-control"/>
						</div>
						
						
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary btn-block" value="Create advertisement">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>