$(document).ready(function () {
    $("#add-registro").on('click', function (event) {
        event.preventDefault();

        $("#modal-add").modal("show");
    });

    $(".editar").on('click', function (event) {
        event.preventDefault();
       $.ajax({  
          type: "POST",  
          url: "GenericGetByIdServlet",  
          data: "id="+1,  
          success: function(result){  
            alert(result);
          }                
        });  
        $("#modal-update").modal("show");
    });

    $(".excluir").on('click', function (event) {
        event.preventDefault();

        $(".item-delete span").html($(event.target).attr('data-info'));

        $("#modal-delete").modal("show");
    });

});