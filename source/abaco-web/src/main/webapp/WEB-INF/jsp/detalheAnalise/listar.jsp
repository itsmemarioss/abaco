<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhe Analise</title>

<%@ include file="../../../header.jsp"%>

</head>

<body>

	<div id="wrapper">

		<%@ include file="../../../navigation.jsp"%>

		<!-- PAGE WRAPPER -->
		<div id="page-wrapper">

			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Detalhe Análise</h1>
					<ol class="breadcrumb">
						<li class="active"><i class="fa fa-dashboard"></i> Lista</li>
					</ol>
				</div>

				<h3>Lista de Detalhes</h3>
				<ul>
					<c:forEach items="${detalheAnaliseList}" var="detalhe">
						<li>${detalhe.proposito}</li>
					</c:forEach>
				</ul>
			</div>
			<!-- /.row -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->


	<!-- Scripts -->
	<%@ include file="../../../scripts.jsp"%>


</body>

</html>