
<%@ page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="model.Hospedagem" 
import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
List<Hospedagem> hospedagens = (List<Hospedagem>) request.getAttribute("hospedagem");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Hospedagem</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">	
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css">	
<link rel="stylesheet" href="https://cdn.es.gov.br/fonts/font-awesome/css/font-awesome.min.css">
	
  <link rel="stylesheet" href="./css/style.css">

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
						<li class="nav-item">
							<a class="nav-link" href="./index"><i class="ico-h fa fa-home fa-fw "></i></a></li>
							
						<li class="nav-item"><a class="nav-link" href="./passagens">Passagens</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="./companhias">Companhias</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="./pacotes">Pacotes</a>
						</li>
						<li class="nav-item"><a class="nav-link active"
							style="color: orange;" aria-current="page" href="./hospedagem"target="_self">Hospedagem</a></li>
						<li class="nav-item">
						<a class="nav-link" href="./Permissoes">Permissão</a>
						</li>
						<li class="nav-item">
							<a class="nav-link"href="./Usuarios">Usuarios</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="header2">
			<h1 class="titulo-cadast text-center">
				<strong>Hospedagem</strong>
			</h1>
		</div>
	</header>	     
	
		<main class="container py-3">			
		<div class="input-group" id="create">
				<a class="btn btn-primary mb-2 py-2" name="create" type="submit"
					data-test-id="submit-button" href="./views/hospedagem/create.html.">
					Cadastrar Hospedagem &nbsp; 
					<i class="ic fa fa-plus"></i>				
				</a>
			</div>	
			<div class="table table-striped highlight table-responsive mx-2">
				<table class="table" id="tabela">
					<thead class="table-light">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome</th>
							<th scope="col">Cidade/Estado</th>
							<th scope="col">Logradouro</th>
							<th scope="col">Telefone</th>
							<th scope="col">Preço/diária</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>
					<tbody>				
	   	                <% 
	   	                for (Hospedagem h: hospedagens){ 
	   	                 %>
	                    <tr>
	                        <td scope="row"><%=h.getId() %></td>
	                        <td><%=h.getNome() %></td>
	                        <td><%=h.getTel() %></td>
	                        <td><%=h.getCidadeEstado() %></td>
	                        <td><%=h.getLogradouro() %></td>	                        
	                        <td><%=h.getPrecoHosped() %></td>
	                        <td class="d-flex">	                        
								<!-- botão Editar --> 
								<a href="./hospedagens-edit?id=<%=h.getId() %>" class="btn btn-info"
								     data-bs-toggle="tooltip" data-bs-placement="bottom"
								 title="Editar"><i class="icon-edite fa fa-pencil-square-o"></i></a>
								 
								<!-- botão deletar -->								
	                             <a href="./hospedagens-delet?id=<%=h.getId() %>" class="btn btn-danger" data-bs-toggle="tooltip"
	                             data-bs-placement="bottom" title="deletar" style="margin-left: 10px;">
	                                <i class="icon-delete fa fa-trash"></i> 
	                               </a>	                           
	                            </td>                         
	                         </tr>			
	                     <% } %>	                  
	                  </tbody>
	            </table>
	        </div>	  	
	</main>

	<footer>
		<div id="copyright">
			<div class="small text-dark p-sm-0 mb-0 text-center">
				<small>&copy; 2022 by Copyrights: VDSviagem</small>
					<a class="text-primary" href="#"></a>
			</div>
		</div>
	</footer>
	<script src="./../JS/script.js" defer></script>
	<!-- Bootstrap JavaScript Libraries -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>



