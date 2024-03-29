<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<title>Conexão 360 - Doação</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--Código para inserir o logo na aba-->
<link rel="icon" type="image/png"
	href="../../assets/img/Icones/icone.png" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet" href="../../assets/css/cadastro.css">
</head>

<body>
	<div class="section">
		<!-- INÍCIO BARRA DE NAVEGAÇÃO -->
		<header>
			<header>
				<div class="nav1">
					<nav class="navbar navbar-expand-lg navbar-dark">
						<div class="container-fluid">
							<img src="../../assets/img/Icones/LogoHorizontal.png"
								height="40px">
							<button class="navbar-toggler" type="button"
								data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
								aria-controls="navbarNavAltMarkup" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
								<div class="navbar-nav">
									<a class="nav-link" aria-current="page" href="../../index.html">Home</a>
									<a class="nav-link active" href="cadastro-usuario.jsp">Cadastro</a>
									<a class="nav-link" href="../contato/contato.jsp">Contato</a> <a
										class="nav-link" href="../sobre/sobre.jsp">Sobre</a>
								</div>
							</div>
						</div>
					</nav>
				</div>
			</header>
		</header>
		<!-- FIM BARRA DE NAVEGAÇÃO -->
		<!-- INÍCIO DO CADASTRO -->
		<main class="container d-flex justify-content-center flex-column">
			<h1>Doe um Equipamento</h1>
			<form action="">
				<!--Tipo Equipamento-->
				<div class="mb-3">
					<label for="equipamento" class="form-label">Tipo de
						equipamento:</label> <select class="form-select"
						aria-label="Default select example">
						<option selected>Selecione o tipo de equipamento está
							disposto à doar:</option>
						<option value="1">Computador</option>
						<option value="2">Notebook</option>
						<option value="3">Smartphone</option>
					</select>
				</div>
				<!--Estado Equipamento-->
				<div class="mb-3">
					<label for="equipamento" class="form-label">Qual o estado
						do equipamento:</label> <select class="form-select"
						aria-label="Default select example">
						<option selected>Selecione o tipo de equipamento está
							disposto à doar:</option>
						<option value="1">Novo</option>
						<option value="2">Pouco uso</option>
						<option value="3">Bastante uso, mas funcional</option>
						<option value="4">Liga, mas tem problemas</option>
					</select>
				</div>
				<!--Tipo Coleta-->
				<div class="mb-3">
					<label for="coleta" class="form-label">Tipo de Coleta:</label>
					<div class="mb-3">
						<input type="radio" name="opc" id="ag" value="ag" required /> <label
							for="ag">Agendar Coleta</label> <input type="radio" name="opc"
							id="ll" value="ll" required /> <label for="ll">Levar ao
							Local</label>
					</div>
				</div>
				<!--Data Coleta-->
				<div class="mb-3">
					<label for="data" class="form-label">Agende sua coleta:</label> <input
						type="date" name="data" id="data" class="form-control" required />
				</div>
				<!--Comentário-->
				<div class="mb-3 m-1">
					<label for="comentario" class="form-label">Comentário:</label>
					<textarea class="form-control" id="dependentes" rows="3"></textarea>
				</div>

				<!--Button enviar-->
				<div class="m-1">
					<input type="submit" class="btn btn-primary" value="Enviar" /> <input
						type="reset" class="btn btn-primary" value="Limpar" />
				</div>
			</form>
		</main>
		<!-- FIM DO CADASTRO -->
		<!-- INÍCIO DO FOOTER -->
		<footer class="pt-4 my-md-0 pt-md-2 border-top">
			<div class="row text-light">
				<div class="col-md-4">
					<hr class="light">
					<img src="../../assets/img/Icones/LogoVertical.png" height="120px">
					<hr class="light">
					<p>0800 4020-8922 / 11 4020-8922</p>
					<p>contato@conexao360.com.br</p>
					<p>Rua Padre Marchetti, 240</p>
					<p>São Paulo - SP, 04262-100</p>
				</div>
				<div class="col-md-4">
					<hr class="light">
					<img src="../../assets/img/Icones/Relogio.png" height="95px">
					<h5>Horários</h5>
					<hr class="light">
					<p>Segunda-Sexta: 08hs - 18hs</p>
					<p>Sábados e Domingos: 08hs - 14hs</p>
					<p>Feriados: 08hs - 12hs</p>
				</div>
				<div class="col-md-4">
					<hr class="light">
					<img src="../../assets/img/Icones/Contato.png" height="95px">
					<h5>Contato</h5>
					<hr class="light">
					<p>daniellessi@gmail.com</p>
					<p>dv.lfrancaa@outlook.com</p>
					<p>gabrieldasilvasantos1997@hotmail.com</p>
				</div>
				<div class="col-12">
					<hr class="light" />
					<h5>&copy; SQUAD 034</h5>
				</div>
			</div>
		</footer>
		<!-- FIM DO FOOTER -->
		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
			integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
			integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
			crossorigin="anonymous"></script>
	</div>
</body>

</html>