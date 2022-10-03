<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<title>Conexão 360 - Serviço</title>
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
			<div class="nav1">
				<nav class="navbar navbar-expand-lg navbar-dark">
					<div class="container-fluid">
						<div>
							<img src="../../assets/img/Icones/LogoHorizontal.png"
								height="40px">
						</div>
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
		<!-- FIM BARRA DE NAVEGAÇÃO -->
		<!-- INÍCIO DA ÁREA DE TRIAGEM -->
		<main class="container d-flex justify-content-center flex-column">
			<h1>O QUE DESEJA FAZER?</h1>
			<div class="p-5 mb-4 bg-light rounded-3">
				<h1 class="display-5 fw-bold">Doar Equipamento</h1>
				<p class="col-md-11 fs-5">Compartilhar é um ato de boa vontade
					que impacta a vida de muitas pessoas. Esse gesto gera consequências
					positivas que começam diretamente no projeto e vão muito além, o
					equipamento que você puder contribuir poderá fazer toda a diferença
					no apoio as pessoas carentes.</p>
				<a class="btn btn-primary" href="cadastro-doacao.jsp" role="button">Doar
					Equipamento</a>
			</div>
			<div class="p-5 mb-4 bg-light rounded-3">
				<h1 class="display-5 fw-bold">Receber Equipamento</h1>
				<p class="col-md-11 fs-5">
					O Projeto Conexão 360° busca ajudar a todos e <b>Mudar Vidas</b>
					incentivamos para que as pessoas que realmente não tem a
					oportunidade de adquirir um equipamento.<br> Pensando em como
					beneficiar as pessoas com maior urgência de equipamento para
					igualar as oportunidades, decidimos priorizar quem está próximo de
					um vestibular ou ingressando o mercado de trabalho e quem não tem
					nenhum dispositivo em casa. A prioritização será para as pessoas
					com o maior número de pontos, que será calculado da seguinte forma:<br>
				</p>
				<h4>03 Pontos</h4>
				<ul>
					<li>Alunos cursando o 3º Ano do Ensino Médio ou 9º Ano do
						Fundamental</li>
					<li>Pessoas fora do mercado de trabalho com 40 anos ou mais</li>
					<li>Quem não possui equipamento em casa</li>
				</ul>
				<h4>02 Pontos</h4>
				<ul>
					<li>Alunos cursando o 2º Ano do Ensino Médio ou 8º Ano do
						Fundamental</li>
					<li>Alunos de Cursos Profissionalizantes</li>
					<li>Quem compartilha o equipamento com alguem da mesma
						residência</li>
				</ul>
				<h4>01 Ponto</h4>
				<ul>
					<li>Graduandos e Pós-Graduandos</li>
				</ul>

				<a class="btn btn-primary" href="cadastro-requisicao.jsp"
					role="button">Receber Equipamento</a>
			</div>
		</main>
		<!-- FIM DA ÁREA DE TRIAGEM -->
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