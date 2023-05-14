function showContent(event) {
			var contentId = $(event).data('content');
			$('.content > div').hide();
			$('#' + contentId).show().addClass('animated slideInRight');
		}