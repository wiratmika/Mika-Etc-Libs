var dataSource = new Bloodhound({
	datumTokenizer: Bloodhound.tokenizers.obj.whitespace,
	queryTokenizer: Bloodhound.tokenizers.whitespace,
	sorter: function(a, b) {
		console.log('sorting...');
		//var InputString = $('.typeahead').val();
		var InputString = 'ipho';
		console.log(InputString);
		console.log(a);
		console.log(b);

        //move exact matches to top
		if (InputString==a.value) {
			return -1;
		}
		if (InputString==b.value) {
			return 1;
		}

         //close match without case matching
		if (InputString.toLowerCase() == a.name.toLowerCase()) {
			return -1;
		}
		if (InputString.toLowerCase() == b.name.toLowerCase()) {
			return 1;
		}

		if ((InputString!=a.value) && (InputString!=b.value)) {
			if (a.value < b.value) {
				return -1;
			} else if (a.value > b.value) {
			return 1;
			}
		}
        else {
        	return 0;
        }
	},
	remote: {
		url: baseURL + '/api/search?q=%QUERY',
		wildcard: '%QUERY',
		transform: function (products) {
			//console.log(products);
			return $.map(dataSource.sorter(products.result), function (product) {
				if (product.images[0]) {
					return {
						id: product.id,
						name: product.name,
						img: imageURL + '/standard/product/thumbnail/' + product.images[0].url,
						url: baseURL + '/' + product.publicUrl + '-' + product.publicId
					};
				} else {
					return {
						id: product.id,
						name: product.name,
						img: baseURL + '/img/default-product-300x300.png'
					};
				}
			});
		}
	},
});

var key = '';

$("#autocomplete").on('keyup', function(e) {
	key = $("#autocomplete").typeahead("val");
});
