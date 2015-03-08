/**
 * Symbol Table based on binary search on ordered array.
 */
BinarySearchST = function() {

	var keys = [], values = [], N = 0, me = this;

	this.put = function(k, v) {
		var i = me.rank(k);
		if(i < keys.length && keys[i] === k)
			values[i] = v;
		for(var x = N; x > i; x--){
			keys[x] = keys[x-1];
			values[x] = values[x-1];
		}
		keys[i] = k; 
		values[i] = v;
		N++;
	};

	this.get = function(k) {
		var i = me.rank(k);
		if(i < keys.length && k === keys[i])
			return values[i];
		return null;
	};

	this.rank = function(k) {
		var lo = 0, hi = keys.length, mid, midTemp;
		while (lo <= hi) {
			midTemp = (hi-lo)/2;
			mid =  (lo + midTemp) | 0;
			if (k < keys[mid])
				hi = mid - 1;
			else if (k > keys[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	};
};

var st = new BinarySearchST();
st.put("mango", "mango".length);
st.put("apple", "apple".length);
st.put("orange", "orange".length);
print("mango -> " + st.get("mango"));
