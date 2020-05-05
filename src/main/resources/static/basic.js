function $(id) {
    return document.getElementById(id);
}

$("btnClick").onclick = function () {
    let url = myForm.url.value;
    axios.post("/ip?url=" + url)
        .then(function (response) {
            // alert(response.data);
            document.getElementById("result").innerHTML=response.data.replace("\n","<br>").replace("\n","<br>");


        })
}

