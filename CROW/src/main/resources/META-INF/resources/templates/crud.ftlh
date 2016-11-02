<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <!-- VIEWPORT -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">

        <link rel="stylesheet" href="templates/build/css/reset.css" media="all">
        <link rel="stylesheet" href="templates/src/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="templates/src/css/crow.css" media="all">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">

        <script src="templates/src/jquery/jquery-2.1.3.min.js"></script>
        <script src="templates/src/bootstrap/js/bootstrap.js"></script>
        <script src="templates/src/js/crow.js"></script>

        <title>Crow - A simple CRUD framework</title>
    </head>
    <body>

        <header>
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="logo-header"></div>
                    </div>
                </div>
            </div>
        </header>

        <section class="section-crow">
            ${table}
        </section>


			${dialogInsert}


            ${dialogUpdate}


        <div class="modal fade" tabindex="-1" role="dialog" id="modal-delete">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Excluir</h4>
                    </div>

                    <form action="" id="crow-add-form">
                        <div class="modal-body">

                            <div class="row">
                                <div class="col-xs-12">

                                    <h3 class="item-delete">Deseja excluir o item: <span>1</span>?</h3>




                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button class="bt bt-padrao" name="excluir" type="submit">Excluir</button>
                            <button class="bt bt-nao" type="submit" data-dismiss="modal">Cancelar</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>



    </body>
</html>
