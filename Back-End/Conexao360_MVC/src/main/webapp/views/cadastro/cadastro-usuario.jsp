<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<title>Conexão 360 - Cadastro de Usuário</title>
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
								<a class="nav-link" href="../contato/contato.jsp">Contato</a> 
								<a class="nav-link" href="../sobre/sobre.jsp">Sobre</a>
							</div>
						</div>
					</div>
				</nav>
			</div>
		</header>
		<!-- FIM BARRA DE NAVEGAÇÃO -->
		<!-- INÍCIO DO CADASTRO -->
		<main class="container d-flex justify-content-center flex-column">
			<h1>Inicie o seu Cadastro:</h1>
			<form action="">
				<div class="mb-3">
					<!--Nome-->
					<div class="mb-3">
						<label for="nome" class="form-label">Nome Completo:</label> <input
							type="text" name="nome" id="nome" class="form-control" required
							placeholder="Nome:">
					</div>
					<!--RG-->
					<div class="mb-3">
						<label for="nome" class="form-label">RG:</label> <input
							type="text" name="nome" id="nome" class="form-control" required
							placeholder="Nome:">
					</div>
					<!--CPF-->
					<div class="mb-3">
						<label for="cpf" class="form-label">CPF:</label> <input
							type="text" name="nome" id="nome" class="form-control" required
							placeholder="Nome:">
					</div>
					<!--Data de Nascimento-->
					<div class="mb-3">
						<label for="data" class="form-label">Data de Nascimento:</label> <input
							type="date" name="data" id="data" class="form-control" required>
					</div>
					<!--Email-->
					<div class="mb-3">
						<label for="email" class="form-label">Email:</label> <input
							type="email" name="email" id="email" class="form-control"
							required placeholder="Email:">
					</div>
					<!--Senha-->
					<div class="mb-3">
						<label for="senha1" class="form-label">Senha:</label> <input
							type="senha1" name="senha1" id="senha1" class="form-control"
							required placeholder="Senha:">
					</div>
					<!--Confirme sua Senha-->
					<div class="mb-3">
						<label for="senha2" class="form-label">Confirme sua Senha:</label>
						<input type="senha2" name="senha2" id="senha2"
							class="form-control" required placeholder="Confirme sua Senha:">
					</div>
					<!--Telefone-->
					<div class="mb-3">
						<label for="tel" class="form-label">Telefone:</label> <input
							type="tel" name="tel" id="tel" class="form-control"
							maxlength="11" required placeholder="Ex: 11912345678">
					</div>
					<!--Estado-->
					<label for="estado" class="form-label">Estado:</label> <select
						class="form-select" aria-label="Default select example">
						<option selected>Escolha um Estado:</option>
						<option value="AC">AC</option>
						<option value="AL">AL</option>
						<option value="AP">AP</option>
						<option value="AM">AM</option>
						<option value="BA">BA</option>
						<option value="CE">CE</option>
						<option value="ES">ES</option>
						<option value="GO">GO</option>
						<option value="MA">MA</option>
						<option value="MT">MT</option>
						<option value="MS">MS</option>
						<option value="MG">MG</option>
						<option value="PA">PA</option>
						<option value="PB">PB</option>
						<option value="PR">PR</option>
						<option value="PE">PE</option>
						<option value="PI">PI</option>
						<option value="RJ">RJ</option>
						<option value="RN">RN</option>
						<option value="RS">RS</option>
						<option value="RO">RO</option>
						<option value="RR">RR</option>
						<option value="SC">SC</option>
						<option value="SP">SP</option>
						<option value="SE">SE</option>
						<option value="TO">TO</option>
					</select>
					<!--Cidade-->
					<div class="mb-3">
						<label for="cidade" class="form-label">Cidade:</label> <input
							type="text" class="form-control" id="cidade" required
							placeholder="Cidade:">
						<div class="invalid-feedback">Por favor, digite a sua
							cidade.</div>
					</div>
					<!--CEP-->
					<div class="mb-3">
						<label for="CEP" class="form-label">CEP:</label> <input
							type="text" id="localPartida" class="form-control" required
							placeholder="00000-000">
					</div>
					<!--Endereço-->
					<div class="mb-3">
						<label for="endereco" class="form-label">Endereço:</label> <input
							type="text" class="form-control" id="endereco"
							placeholder="Rua, N°" required>
						<div class="invalid-feedback">Por favor, digite seu
							endereço.</div>
					</div>
					<!--Complemento-->
					<div class="mb-3">
						<label for="complemento" class="form-label">Complemento<span
							class="text-muted">(Opcional):</span></label> <input type="text"
							class="form-control" id="complemento"
							placeholder="Apartamento...">
					</div>
				</div>
				<!--Button enviar-->
				<div class="direction">
					<div class="row justify-content-center">
						<div class="col-lg-3 col-sm-3 m-1">
							<input type="submit" class="btn btn-primary " value="Enviar">
							<input type="reset" class="btn btn-primary" value="Limpar">
						</div>
						<div class="col-md-3 offset-md-4">
							<a class="btn btn-primary" href="cadastro-servico.jsp"
								role="button">Clique para Prosseguir</a>
						</div>
					</div>
				</div>
			</form>
		</main>
	</div>
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