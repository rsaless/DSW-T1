var xmlHttp;

function buscarPromocoes(cnpj){
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    
    var url = "ajax?cnpj=" + cnpj;
    xmlHttp.onreadystatechange = atualizaTabela;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}

function atualizaTabela() {
    if (xmlHttp.readyState === 4 || xmlHttp.readyState === "complete") {
        document.getElementById("tbodyresposta").innerHTML = xmlHttp.responseText;
    }
}
