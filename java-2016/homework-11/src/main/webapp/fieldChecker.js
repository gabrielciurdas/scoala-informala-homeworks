function checkFields() {
	var yearOfBirth = document.getElementsByName('yearOfBirth')[0].value;
	var monthOfBirth = document.getElementsByName('monthOfBirth')[0].value;
	var dayOfBirth = document.getElementsByName('dayOfBirth')[0].value;
	var currentYear = document.getElementsByName('currentYear')[0].value;
	var currentMonth = document.getElementsByName('currentMonth')[0].value;
	var currentDay = document.getElementsByName('currentDay')[0].value;

	if (yearOfBirth == "" || monthOfBirth == "" || dayOfBirth == ""
			|| currentYear == "" || currentMonth == "" || currentDay == "") {
		alert("Fields cannot be empty!");
		return false;
	}
	return true;
}