function carregarPesssoas(element) {
    var pessoasArray = [];

    if (document.getElementById('para').value !== '') {
        pessoasArray = document.getElementById('para').value.split(",");
    }

    if (pessoasArray.indexOf(element.value) === -1) {
        pessoasArray.push(element.value);
        element.style.color = 'black';
        element.style.background = '#f2f2f2';
        element.style.fontWeight = '800';
    } else {
        pessoasArray.splice(pessoasArray.indexOf(element.value), 1);
        element.disable = false;
        element.style.color = 'white';
        element.style.background = '#428BCA';
        element.style.fontWeight = 'normal';
    }

    var numuerosDeBotaos = document.getElementsByClassName('emails');
//    if (pessoasArray.length === 6) {
//        for (i = 0; i < numuerosDeBotaos.length; i++) {
//            if (pessoasArray .indexOf(numuerosDeBotaos[i].id) === -1) {
//                numuerosDeBotaos[i].disabled = true;
//                numuerosDeBotaos[i].style.color = 'grey';
//                numuerosDeBotaos[i].style.fontWeight = 'normal';
//            }
//        }
//    } else {
//        for (i = 0; i < numuerosDeBotaos.length; i++) {
//            if (pessoasArray .indexOf(numuerosDeBotaos[i].id) === -1) {
//                numuerosDeBotaos[i].disabled = false;
//                numuerosDeBotaos[i].style.color = 'white';
//                numuerosDeBotaos[i].style.fontWeight = 'normal';
//            }
//        }
//    
//    }
    pessoasArray.sort(function(a, b) {
        return a - b
    });
    document.getElementById('para').value = pessoasArray;
}