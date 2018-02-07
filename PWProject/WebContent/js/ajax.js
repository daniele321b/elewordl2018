/**
 *
 */

  function getCat() {
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          var categoria = JSON.parse(this.responseText);
          for (var i = 0; i < categoria.cat.length; i++) {
              console.log(categoria.cat[i].categoria);
              addSelectCat(categoria.cat[i]);
          }
        }
      }

      console.log("not"+this.status);
      xhttp.open("GET", "GetCat", true);
	  xhttp.send();
  }

  function addSelectCat(cat) {

    var select = document.getElementById("category");
    var op = document.createElement("option");
    op.setAttribute("value", cat.categoria);
    op.appendChild(document.createTextNode(cat.categoria));
    select.appendChild(op);
  }


  function getCod() {
	      var xhttp = new XMLHttpRequest();
	      xhttp.onreadystatechange = function() {
	        if (this.readyState == 4 && this.status == 200) {
	          var x = JSON.parse(this.responseText);
	          for (var i = 0; i < x.codici.length; i++) {
	              addSelectCod(x.codici[i]);
	              // addSelect(categoria.cat[i]);
	          }
	        }
	      }
	      xhttp.open("GET", "GetCod", true);
		    xhttp.send();
	  }

	  function addSelectCod(cod) {
	    var select = document.getElementById("codiceM");
	    var op = document.createElement("option");
      op.setAttribute("value", cod.codice);
	    op.appendChild(document.createTextNode(cod.codice));
	    select.appendChild(op);
	  }
