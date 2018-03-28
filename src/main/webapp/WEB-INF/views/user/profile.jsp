<div class="col-sm-8 col-sm-offset-2">
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
</div>
