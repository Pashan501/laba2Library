<%@include file="/WEB-INF/static/header.jsp"%>
<main id = "main">
	<style>
		.main_info
		{
			min-height: 400px;
		}

	</style>
	<div class="container fuel">
		<div class="row main_info">
			<div class="col-3">
				<img src="${imageSource}" style="width: 300px;height: 350px;margin-top:10px;float: right;border: 1px solid black;">
			</div>
			<div class="col-9">
				<div class="row">
					<h2>Name</h2>
				</div>
				<div class="row">
					<h5> ${name} </h5>
				</div>
				<div class="row">
					<h2>Genre</h2>
				</div>
				<div class="row">
					<h5> ${genre} </h5>
				</div>
				<div class="row">
					<h2>Author</h2>
				</div>
				<div class="row">
					<h5> ${authorName}</h5>
				</div>
				<div class="row">
					<h2> Year </h2>
				</div>
				<div class="row">
					<h5> ${year} </h5>
				</div>
				<div class="row">
					<h2>Description</h2>
				</div>
				<div class="row">
					<h5>${description}</h5>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-2">
				<input class="submit" type="submit" value="Buy">
			</div>
			<div class="col-9"></div>
		</div>
	</div>
</main>
<%@include file="/WEB-INF/static/footer.jsp"%>