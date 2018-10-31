//******************** Set the content of modal box ********************/
function setAlertMessage(title,alertMessage) {
	$('.modal-title').html(title);
	$('#modalMsg').html(alertMessage);
	$('#messageModal').modal('show');
}

//******************** Create the content of the video card section ********************/
function addCard(data, type) {
	var cardVideo = '', cardText = '', cardButton = '';
	//data contains these fields
	var idSingle = data['idSingle']; 
	var title = data['title'];
	var info = data['info'];
	var name = data['name'];
	var image = data['image'];
	var uri = data['uri'];
	var nameGenre = data['nameGenre'];
	
	// prepare cardVideo
	var cardVideo = '<div class="col-md-4"><div class="card mb-4 box-shadow"><div class="embed-responsive embed-responsive-16by9"><iframe class="embed-responsive-item" src="https://www.youtube.com/embed/' + uri + '?rel=0" allowfullscreen></iframe></div>';
	
	//prepare cardText and cardButton
	var cardText = '<div class="card-body"><h5 class="card-text card-title">' + name + '</h5>';
	cardText += '<div class="d-flex flex-sm-row justify-content-between align-items-center mb-2"><h6 class="card-text card-subtitle text-muted">' + title + '</h6>';
	
	//content of cardText for original single
	if (type == 'original') {
		if (info)
			cardText += '<small class="text-muted mr-1"><a href="' + info + '" target="_new">More</a></small></div>';
		else 
			cardText += '<small class="text-muted mr-1"><a href="#" style="color:#999999">More</a></small></div>';
		
		//content of cardButton for original single
		cardButton = '<div class="d-flex justify-content-between align-items-center"><div class="btn-group"><button type="button" class="btn btn-sm btn-outline-secondary view-covers" data-idsingle="' + idSingle + '">View Covers</button></div>';	
	}
	
	//content of cardText for remake single
	if (type == 'remake') {
		cardText += '</div>';
		
		//content of cardButton for remake single
		cardButton = '<div class="d-flex justify-content-between align-items-center"><div class="btn-group"><button type="button" class="btn btn-sm btn-outline-secondary rate-it" data-idsingle="' + idSingle + '">Rate It</button></div>';
	}
	
	//other content cardButton
	cardButton += '<div class="btn-group"><button type="button" class="btn btn-sm btn-outline-secondary genre-button" data-genre="' + nameGenre + '">' + nameGenre + '</button></div></div></div></div>';
	
	//dynamically create and add card
	$('#indexRow').append(cardVideo + cardText + cardButton);
	
}

//******************** Remove the content of the card section ********************/
function removeCard() {
	$('#singleTitle').hide();
	$("#indexRow").empty();
}

/* Return true if the inputString doesn't contains character like <, >, ', " or words like script */
function isSecure(inputString) {
	if (inputString.includes('<') || inputString.includes('>') || inputString.includes('\'') || inputString.includes('"') || inputString.includes('script') || inputString.includes(' '))
		return false;
	else
		return true;
}
