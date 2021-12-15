
const isPrime = function(n){
	for (var i = 2; i<n; i++){
		if (n%i == 0) return false;
	}
	return n>1
}

var gcd = function(a, b){
	return (!b) ? a : gcd(b, a%b);
}

var invMod = function(a, m){
	for (var x = 2; x<m; x++){
		if (((a%m) * (x%m)) % m == 1){
			return x;
		}
	}
}

var n, t, e, d, M, C;

function rsa(){
	var p = parseInt(document.getElementById("p").value);
	var q = parseInt(document.getElementById("q").value);
	
	if (!(isPrime(p) && isPrime(q))){
		return;
	}

	n = p * q;
	t = (p-1) * (q-1)

	for (e = 2; e<t; e++){
		if (gcd(e, t) == 1){
			break;
		}
	}
	d = invMod(e, t);

	document.getElementById("publicKey").innerHTML = "(e, n):\t" + e + ", " +n;
	document.getElementById("privateKey").innerHTML = "(d, n):\t" + d + ", " +n;

	var M = parseInt(document.getElementById("msg").value);

	C = (Math.pow(M, e)) % n;
	document.getElementById("cipherText").innerHTML = " "+ C;

}