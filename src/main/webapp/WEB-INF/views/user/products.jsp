
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>



<div id="app">
	<br>

	<div v-for="carEntity in carEntitys">
		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<h4 class="text-center">
					<span class="label label-info">{{carEntity.make}}</span>
					<span class="label label-danger">In stock: {{carEntity.inStock}}</span>
				</h4>
				<img src="http://placehold.it/650x450&text=iMAC" class="img-responsive">
				<div class="caption">
					<div class="row">
						<div class="col-md-8 col-xs-8">
							<small>{{carEntity.name}}</small>
						</div>
						<div class="col-md-4 col-xs-4 price">
							<small>
								<label>$ {{carEntity.price}}</label>
							</small>
						</div>
					</div>
					<div class="row">
						<div class="col-md-8"></div>
						<div class="col-md-4">
							<a @click = "buy(carEntity)" href="#" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</a>
						</div>
					</div>
					<p></p>
				</div>
			</div>
		</div>
	</div>
</div>


<script src="/resources/js/axios.min.js"></script>
<script src="/resources/js/vue.min.js"></script>

<script>
new Vue({
	el: "#app",
	data:{
		carEntitys: [],
		serverUrl: "http://localhost:8080/api/v1"
	},
	methods: {
		
		getCarEntitys: function(){
			var self = this;
			
			axios.get(this.serverUrl + "/products")//method get a date
			.then(function(response){//return znachenya
				console.log(response);
				self.carEntitys = response.data;
			})
			.catch(function(err){
				console.log(err);
			})
		},
		
		buy: function(carEntity){
			axios.get(this.serverUrl + "/buy?carEntityId=" + carEntity.id)
			.then(function(response){
			alert("You bought" + carEntity.name + ":-)");
			carEntity.inStock--;
		})
		.catch(function(err){
			console.log(err);
		})
		}
	},
	
	mounted(){
		this.getCarEntitys();
		
	}
	
});


</script>
