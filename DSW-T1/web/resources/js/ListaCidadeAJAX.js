var xmlHttp;

function buscarTeatros(cidade){
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    
    var url = "ajax?cidade=" + cidade;
    xmlHttp.onreadystatechange = atualizaTabela;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}

function atualizaTabela() {
    if (xmlHttp.readyState === 4 || xmlHttp.readyState === "complete") {
        document.getElementById("tbodyresposta").innerHTML = xmlHttp.responseText;
    }
}