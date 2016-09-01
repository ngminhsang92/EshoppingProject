function SetShipping(checked) {
	if (checked) {
		document.getElementById('shippingStreetField').style.display="none";
		document.getElementById('shippingStreet').value = document.getElementById('billingStreet').value;
        document.getElementById('shippingApartmentNumberField').style.display="none";
        document.getElementById('shippingApartmentNumber').value = document.getElementById('billingApartmentNumber').value;
        document.getElementById('shippingCityField').style.display="none";
        document.getElementById('shippingCity').value = document.getElementById('billingCity').value;
        document.getElementById('shippingStateField').style.display="none";
        document.getElementById('shippingState').value = document.getElementById('billingState').value;
        document.getElementById('shippingCountryField').style.display="none";
        document.getElementById('shippingCountry').value = document.getElementById('billingCountry').value;
        document.getElementById('shippingZipField').style.display="none";
        document.getElementById('shippingZip').value = document.getElementById('billingZip').value;
	} else {
		document.getElementById('shippingStreetField').style.display="block";
		document.getElementById('shippingStreet').value = ''; 
        document.getElementById('shippingApartmentNumberField').style.display="block";
        document.getElementById('shippingApartmentNumber').value = ''; 
        document.getElementById('shippingCityField').style.display="block";
        document.getElementById('shippingCity').value = ''; 
        document.getElementById('shippingStateField').style.display="block";
        document.getElementById('shippingState').value = ''; 
        document.getElementById('shippingCountryField').style.display="block";
        document.getElementById('shippingCountry').value = ''; 
        document.getElementById('shippingZipField').style.display="block";
        document.getElementById('shippingZip').value = ''; 
	}
}