<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<title>Cadastro | Hospedagem</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS v5.0.2-beta1 -->
<link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css">	
<link rel="stylesheet"href="https://cdn.es.gov.br/fonts/font-awesome/css/font-awesome.min.css">
	
<link rel="stylesheet" href="../../css/style.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light p-2 pb-0 pt-0"
			style="background-color: #68810bc2;" id="cabecalho2">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">
					<h1 class="display-6">
						<strong>DVSviagem</strong>
					</h1>
				</a>
				<button class="navbar-toggler me-2" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-center mx-4"
					id="navbarSupportedContent">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="../../index.jsp"><i class="ico-h fa fa-home fa-fw "></i></a>
						</li>
						<li class="nav-item"><a class="nav-link" href="./passagens">Passagens</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="./passagens">Companhias</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="./pacotes">Pacotes</a>
						</li>
						<li class="nav-item">
						<a class="nav-link active"style="color: orange;" aria-current="page" 							
							href="./Hospedagem"target="_self">Hospedagem</a></li>							
						<li class="nav-item">
						<a class="nav-link"href="../Permissoes.html">Permissão</a></li>							
						<li class="nav-item">
						<a class="nav-link"href="../Usuarios/index.html">Cadastro</a></li>							
					</ul>
				</div>
			</div>
		</nav>
		<div class="header2">
			<h1 class="titulo-cadast text-center">
				<strong>Cadastro | Hospedagem</strong>
			</h1>
		</div>
	</header>	
		<main class=" container-row g-3 col-md-11 mx-auto col-lg-9 mb-2 ">
		      
              <form action="../../hospedagem-create" method="post" class="row g-3 needs-validation" id="form-create" novalidate>
              <fieldset>	
                <div class="mb-0 mt-2">
                    <h3 class="text-center"><strong>Cadastrar / Criar</strong></h3>
                </div>
                <div class="col-md-6">
                    <div class="form-outline">
                        <label for="validationCustom01" class="form-label">Nome</label>
                        <input type="text" id="validationCustom01" class="form-control"
                            placeholder="nome do hotel ou pousada" value="" required />
                        <div class="valid-feedback">
                            <i class="ico ri-check-fill text-success"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-outline">
                        <label for="validation02" class="form-label">Cidade / Estado</label>
                        <input type="text" class="form-control" id="validation02" placeholder="Cidade /Estado" value="" required>
                        <div class="valid-feedback">
                            <i class="ico ri-check-fill text-success"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-outline">
                        <label for="validationCustom03" class="form-label">Logradouro</label>
                        <input type="text" class="form-control" id="validationCustom03" placeholder="Logradouro"
                            value="" required>
                        <div class="valid-feedback">
                            <i class="ico ri-check-fill text-success"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-outline">
                        <label for="validationCustom04" class="form-label">Telefone</label>
                        <input type="tel" class="form-control" id="validationCustom04" placeholder="Telefone ou celular"
                            value="" required>
                        <div class="valid-feedback">
                            <i class="ico ri-check-fill text-success"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-outline">
                        <label for="validationCustom05" class="form-label">Preço/Diária</label>
                        <input type="text" class="form-control" id="validationCustom05" placeholder="Preço por diárias"
                            value="" required>
                        <div class="valid-feedback">
                            <i class="ico ri-check-fill text-success"></i>
                        </div>
                    </div>
                </div>
                <!-- botão enviar -->
                
                	<div class="col-12 mt-4">
                
                    <button class="btn btn-primary text-black rounded-5 buttonBase mb-3" type="submit"
                        data-test-id="submit-button">Enviar&nbsp;<?xml version="1.0" encoding="iso-8859-1"?>                        
                        <svg class="seta-input m-1" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg"
                            width="20" height="20" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                            viewBox="0 0 513.32 513.32" xml:space="preserve">
                            <g>
                                <g>
                                    <polygon points="299.437,42.777 269.493,72.72 432.045,235.272
                                                   0,235.272 0,278.048 432.045,278.048 269.493,440.6 
                                                     299.437,470.543 513.32,256.66" />
                                </g>
                            </g>
                        </svg>
                    </button>                 
				<a href="./index.jsp" class="btn btn-outline-danger text-black rounded-5 buttonBase mb-3 py-2 mx-3">Cancelar</a>							
					</div>
				</fieldset>
			</form>	
	</main>

	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>




