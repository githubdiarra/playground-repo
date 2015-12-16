var grades = [[89, 77, 78], [76, 82, 81], [91, 94, 89]], total = 0, average = 0.0, row, col;
for (row = 0; row < grades.length; ++row){
	for(col = 0; col < grades[row].length; ++col){
		total += grades[row][col];
	}
	average = total/ grades[row].length;
	print("Student " + parseInt(row +1) + " average: " + average.toFixed(2));
	total = 0;
}
total = 0;
average = 0.0;
for(col = 0; col < grades.length; ++col){
	for(row = 0; row < grades[col].length; ++row){
		total += grades[row][col];
	}
	average = total /grades[col].length;
	print("Test " + parseInt(col+1) + " average: " + average.toFixed(2));
	total = 0;
	average = 0.0;
}