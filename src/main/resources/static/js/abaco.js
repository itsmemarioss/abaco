/**
 * by Mário Santos Sousa 
 */
$('#modalExcluir').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	var id = button.data("id");
	var nome = button.data("nome");
	
	var modal = $(this);
	
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')){
		action+='/';
	}
	form.attr('action',action+id);
	
	modal.find('.modal-body span').html('Deseja excluir o sistema <strong>'+nome+'</strong>?');
});

$('.js-modalFuncao').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);	
	var modal = $(this);
	
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')){
		action+='/';
	}
	
	form.attr('action',action+button.data('controller')+'/'+button.data('action')+'/'+button.data('idtab'));
	
});
/*
$('#modalFuncaoDeTransacao').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);	
	var modal = $(this);
	
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')){
		action+='/';
	}
	form.attr('action',action+button.data('action'));
	
});*/

$(function(){
	$('[rel="tooltip"]').tooltip();
});