<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ attribute name="tipoTemplate" required="true"%>
<%@ attribute name="tipoLimite" required="true"%>

<div id="boxLateral">
	<c:choose>
		<c:when test="${tipoTemplate eq 'SALDO_LIMITES_SEPARADO'}">
			<div class="col3" role="complementary">
				<div class="modulo modulo-sidebar aberto menu-contexto">
					<h3 class="hover flex-home">
						saldo disponível<span class="right abre-fecha"></span>
					</h3>
					<div class="conteudo">
						<p>Saldo disponível + LIS:</p>
						<p>
							 <strong id="valor">5.500,00</strong>
						</p>
					</div>
				</div>

				<div class="modulo modulo-sidebar menu-contexto">
					<h3>Horários e limites</h3>
					<p class="margem-cima20">
						<strong>horário</strong>
					</p>
					<p class="margem-cima15">
						pagamentos <br> <strong>até às 23:00h</strong>
					</p>
					<p class="margem-cima15">
						<strong>Limites disponíveis</strong>
					</p>
					<p>
						semanal <br> <strong> 10.000,00</strong>
					</p>
					<p class="margem-cima15 margem-baixo20">
						diário <br> <strong>Boletos:1.000,00</strong> <br> <strong>Água,Luz,Gás,etc:800,00</strong>
					</p>
					<p class="right">
						<a>Ver detalhes</a>
					</p>
				</div>
			</div>
		</c:when>
		<c:when test="${tipoTemplate eq 'SALDO_LIMITES_HOME_TRANSFERENCIA'}">
			<div class="conteudo-aba-direita left">
				<h3>Saldo disponível</h3>
				<div class="row clearfix">
					<p>
						<small>Saldo Disponível + LIS</small>
					</p>
					<p>
						<strong> <span class="valor-fatura">4.200,</span><small>00</small></strong>
					</p>
				</div>
				<h3>Horários e limites</h3>
				<div class="row clearfix padding-baixo20">
					<table summary="" class="no-border">
						<tbody>
							<tr>
								<td>DOC</td>
								<td>das 0h até às 22:00h</td>
							</tr>
							<tr>
								<td>TED</td>
								<td>das 06:30h até às 17:00h</td>
							</tr>
						</tbody>
					</table>
					<p>
						<a href="#">Consulte o seu limite disponível para esta
							transação</a>
					</p>
					<small>Limite válido para operações realizadas via Internet
						30 horas e Telefone 30 horas, podendo ser alterado sem aviso
						prévio</small>
				</div>
			</div>
		</c:when>
	</c:choose>

</div>

<script type="text/javascript">

	var tipoTemplate = "${tipoTemplate}";
	var tipoLimite = "${tipoLimite}";

	var templates = {
		SALDO_LIMITES_SEPARADO : "SALDO_LIMITES_SEPARADO",
		SALDO_LIMITES_HOME : "SALDO_LIMITES_HOME_TRANSFERENCIA"
	}

	/* $.ajax({
		url : "<<url:url-resolver path='' addContext='true'/>",
		dataType : "json",
		method : "POST",
		data : {
			
		},
		success : function(resultado) {
			$("$valor").html(resultado.saldo);
		}
	});  */
 
</script>

