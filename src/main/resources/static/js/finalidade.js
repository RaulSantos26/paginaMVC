        function FinalidadeDiv(elem){
        if(elem.value == 1){
        document.getElementById('outros').style.display = "none";
        document.getElementById('bb').style.display = "none";
        document.getElementById('diversas').style.display = "none";
        } else if (elem.value == 2) {
        document.getElementById('outros').style.display = "block";
        document.getElementById('bb').style.display = "none";
        document.getElementById('diversas').style.display = "none";
        } else if (elem.value == 3) {
        document.getElementById('outros').style.display = "none";
        document.getElementById('bb').style.display = "block";
        document.getElementById('diversas').style.display = "none";
        } else if (elem.value == 4) {
        document.getElementById('outros').style.display = "none";
        document.getElementById('bb').style.display = "none";
        document.getElementById('diversas').style.display = "block";
        }

        }