$(document).ready(function() {
	
	//******************** Init Tooltip *************************/
	$('[data-toggle="tooltip"]').tooltip();
	
	//******************* Event: click on hamburger button *******************/
	$('#hamburger').click(function() {
		//go to navbar
		$('html, body').animate({ scrollTop: $('body').offset().top }, 500);
	});

	//******************* Search original single for a year *******************/
	/* Event: submit form #searchForm */
	$('#indexSearchForm').submit(function(e) {
		e.preventDefault();
		//get input value
		var year = $('#indexInputYear').val().trim();
		//get current year
		var currentYear = (new Date).getFullYear();
		if (year && year >= 1980 && year <= currentYear && $.isNumeric(year)) {
			var params = {year: year};
			$.post("SearchSingles", $.param(params), function(response, status) {
				if (response.length > 0 && status == 'success') { //exist singles
					//remove previous cards
					removeCard();
					for(i = 0; i < response.length; i++)  
						//add new cards
						addCard(response[i], 'original');
					//add title
					var title = "Singles of " + year;
					$('#singleTitle').html(title);
					$('#singleTitle').show();
					//go to video section
					$('html, body').animate({ scrollTop: $('.album').offset().top }, 1000);
				} //end if
				else if (response.length == 0) //no singles
					setAlertMessage('WARNING', 'No singles found for ' + year);
				else if (status == 'error') //ajax problems
					setAlertMessage('ERROR', 'The service is temporarily not available. Retry later.');
			}); //end post
		} //end if
		else { //year is out of range or is not numeric
			if (! $.isNumeric(year))
				setAlertMessage('ERROR', '<strong>Wrong value!</strong> Insert a numeric value.');
			else if (year < 1980 || year > currentYear ) {
				var alertMessage = '<strong>Wrong year!</strong> Enter it between 1980 and ' + currentYear;
				setAlertMessage('ERROR', alertMessage);
			}
		} //end else
	});

	//******************* Search all the covers from the original single *******************/
	/* Event: click on View Covers button */
	$(document).on('click', '.view-covers', function() {
		var idSingle = $(this).attr('data-idsingle');
		var params = {idSingle: idSingle};
		$.post("SearchCovers", $.param(params), function(response, status) {
			if (response.length > 0 && status == 'success') { //exist covers
				//remove previous cards
				removeCard();
				for(i = 0; i < response.length; i++)  
					//add new cards
					addCard(response[i], 'remake');
				//add title
				var title = "Covers of " + response[0]['title'];
				$('#singleTitle').html(title);
				$('#singleTitle').show();
				
				//go to video section
				$('html, body').animate({ scrollTop: $('.album').offset().top }, 1000);
			} //end if
			else if (response.length == 0) //no covers
				setAlertMessage('WARNING', 'No covers found for the selected singles');
			else if (status == 'error') //ajax problems
				setAlertMessage('ERROR', 'The service is temporarily not available. Retry later.');
		}); //end post
	});
	
	/* Vote a cover */
	/* Event: click on a Rate It button */
	$(document).on('click', '.rate-it', function() {
		//TODO: verify that user is authorizated
		var idSingle = $(this).attr('data-idsingle');
		console.log('idSingle = ' + idSingle); //DEBUG
		var params = {idSingle: idSingle};
		$.post("AddRating", $.param(params), function(response, status) {
			console.log('status=' + status); //DEBUG
			if (response.length > 0 && status == 'success') { //exist covers
				var coverList = JSON.stringify(response);
				console.log(coverList); //DEBUG
				//remove previous cards
				removeCard();
				for(i = 0; i < response.length; i++) { 
					var idSingle = response[i]['idSingle']; 
					console.log('idSingle=' + idSingle); //DEBUG
					var title = response[i]['title'];
					console.log('title=' + title); //DEBUG
					var name = response[i]['name'];
					console.log('name=' + name); //DEBUG
					var image = response[i]['image'];
					console.log('image=' + image); //DEBUG
					var uri = response[i]['uri'];
					console.log('uri=' + uri); //DEBUG
					//add new cards
					addCard(response[i], 'remake');
				} //end for
			} //end if
			else if (response.length == 0) //no covers
				setAlertMessage('WARNING', 'No covers found for the selected singles');
			else if (status == 'error') //ajax problems
				setAlertMessage('ERROR', 'The service is temporarily not available. Retry later.');
		}); //end post
	});
	
	//************** Login **************/
	/* Event: submit form #loginForm */
	$('#loginForm').submit(function(e) {
		e.preventDefault();
		var errorMessage ='';
		//get input value
		var username = $('#usrLogin').val().trim();
		var password = $('#pwdLogin').val().trim();
		//username and password must have a length less or equals to 30
		if (! isSecure(username) || username.length > 30) {
			setAlertMessage('ERROR', 'Wrong Username');
			return;
		}
		if (! isSecure(password) || password.length > 30) {
			setAlertMessage('ERROR', 'Wrong Password');
			return;
		}
		
		//all checks have been passed
		var params = {
			username: username,
			password: password
		};
		$.post("UserLogin", $.param(params), function(response, status) {
			var newResponse = '';
			if (status == 'success') { //user is registered
				if (response.includes('error'))
					newResponse = response.replace('error', '');
				else {
					newResponse = response;
					$('#login').hide();
					$('#logout').show();
					$('#loggedUser').html('<img src="assets/icons/user.png" width="25" height="25" class="mr-2">' + username);
				}
				setAlertMessage('OUTCOME', newResponse);
				console.log('newResponse=' + newResponse);
				//reset form
				$('#loginForm')[0].reset();
				$('#loginDiv').collapse('hide');
				$('#navbarHeader').collapse('hide');
			}
		});
	});
	
	/* Logout */
	/* Event: click on Logout link */
	$('#logout').click(function() {
		$.post("UserLogout", function(response, status) {
			if (status == 'success') {
				setAlertMessage('OUTCOME', response);
				$('#navbarHeader').collapse('hide');
				$('#login').show();
				$('#logout').hide();
				$('#loggedUser').html('');
				removeCard();
				$('#singleTitle').hide();
				$('#indexSearchForm')[0].reset();
			}
		});
	});
	
	//************** Signup ***************/
	/* Event: submit form #signupForm */
	$('#signupForm').submit(function(e) {
		e.preventDefault();	
		var errorMessage ='';
		//get input value
		var username = $('#usrSignup').val().trim();
		var password = $('#pwdSignup').val().trim();
		var confirmPass = $('#pwdConfirm').val().trim();
		var email = $('#emailSignup').val().trim();
		var artist = $('#roleSignup').prop('checked');
		
		//username and password must have a length <= 30 and >=3
		if (! isSecure(username) || username.length < 3 || username.length > 30) {
			setAlertMessage('ERROR', 'Wrong Username');
			return;
		}
		if (! isSecure(password) || password.length < 8 || password.length > 30) {
			setAlertMessage('ERROR','Wrong Password');
			return;
		}
		if (confirmPass != password) {
			setAlertMessage('ERROR','Passwords don\'t match');
			return;
		}
		
		//all checks have been passed 
		var params = {
				username: username,
				password: password,
				email: email,
				artist: artist
			};
			$.post("UserSignup", $.param(params), function(response, status) {
				if (status == 'success') { //user is registered
					setAlertMessage('OUTCOME', response);
					//reset form
					$('#signupForm')[0].reset();
					$('#signupDiv').collapse('hide');
					$('#navbarHeader').collapse('hide');
				}
			});
	});
});
