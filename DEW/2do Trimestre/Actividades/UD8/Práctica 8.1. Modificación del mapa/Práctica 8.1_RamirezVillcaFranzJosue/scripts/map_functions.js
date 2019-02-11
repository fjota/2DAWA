// See post: http://asmaloney.com/2014/01/code/creating-an-interactive-map-with-leaflet-and-openstreetmap/

var map = L.map('map', {
	center: [28.4554796, -16.2832658],
	minZoom: 16,
	zoom: 16
})

L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
	attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>',
	subdomains: ['a', 'b', 'c']
}).addTo(map)

var myURL = jQuery('script[src$="scripts/map_functions.js"]').attr('src').replace('scripts/map_functions.js', '');

function SelectIconMap(image) {
	if (image != undefined) {
		if (image.length > 0) {
			let personalIcon = L.icon({
				iconUrl: image.toString(),
				iconRetinaUrl: image.toString(),
				iconSize: [29, 24],
				iconAnchor: [9, 21],
				popupAnchor: [0, -14]
			});
			return personalIcon;
		}		
	} 
	let myIcon = L.icon({
		iconUrl: myURL + 'maps/images/pin24.png',
		iconRetinaUrl: myURL + 'maps/images/pin48.png',
		iconSize: [29, 24],
		iconAnchor: [9, 21],
		popupAnchor: [0, -14]
	});
	return myIcon;
}

map.on('click', function (ev) {
	var latlng = map.mouseEventToLatLng(ev.originalEvent);
	console.log(latlng.lat + ', ' + latlng.lng);
	lat = latlng.lat;
	lon = latlng.lng;
});

$('#guardar').on('click', function (event) {
	console.log("CLICK");
	savePoint(lat, lon);
});

function savePoint(lat, lng) {

	let punto = {
		name: $('#lugar').val(),
		url: $('#web').val(),
		icon: $("#icono").val(),
		lat: lat,
		lng: lon
	};

	connSave = new XMLHttpRequest();

	let ruta = 'server/save_point.php?point=' + JSON.stringify(punto);

	connSave.onreadystatechange = function (event) {

		if (connSave.readyState == 4) {
			console.log(connSave.responseText);
			loadPointsToMap();
		}
	}
	connSave.open('GET', ruta, true);
	connSave.send();
}

function loadPointsToMap() {

	let ruta = 'server/load_points.php';

	connLoad = new XMLHttpRequest();

	connLoad.onreadystatechange = function (event) {

		if (connLoad.readyState == 4) {
			console.log("> " + connLoad.responseText);
			points = JSON.parse(connLoad.responseText);
			placePointsInMap(points);
		}
	}
	connLoad.open('GET', ruta, true);
	connLoad.send();
}

function placePointsInMap(points) {
	for (var i = 0; i < points.length; ++i) {		
		L.marker([points[i].lat, points[i].lng], { icon: SelectIconMap(points[i].icon) })
			.bindPopup('<a href="' + points[i].url + '" target="_blank">' + points[i].name + '</a>')
			.addTo(map);
	}
}