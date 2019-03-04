function detailredirect(gameID){
            $.cookie('arr',gameID);
            alert(gameID);
            document.location.href = "./detail.html";

}

