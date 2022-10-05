function ComicsDel() {
    var ids = [];
    $("input[name='id_del']:checked").each(function () {
        ids.push($(this).val());
    });
    if (ids.length === 0) {
        alert("Advertencia\n\nSeleccione la(s) fila(s) a Retirar");
    } else {
        var exito = confirm('¿Seguro que deseas borrar el comic?');
        if (exito) {
            window.location = "ComicsP.comicsDel()" + ids.toString();
        } else {
            alert("Operación cancelada");
        }
    }
}