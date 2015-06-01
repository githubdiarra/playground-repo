function PrintStuff(myDocuments){
	this.documents = myDocuments;
}

PrintStuff.prototype.print = function(){
	print(this.documents);
};

var obj = new PrintStuff("I got new stuffs");

obj.print();