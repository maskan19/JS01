/**
 * 
 */
currentPage = 1;

updateReply = function(){
	
	$.ajax({
		url : '/board/UpdateReply.do',
		type : 'post',
		data : reply,  //reply객체 - cont, renum이 저장 
		dataType : 'json'
		
		
	})
}

deleteReply = function(but){
	
	console.log(vidx);
	 
	 
	$.ajax({
		url : '/board/DeleteReply.do',
		type: 'get',
		data : {"renum" : vidx},
		dataType : 'json',
		success : function(res){
			//alert(res.sw);
			$(but).parents('.rep').remove();
			
    	},
		error :  function(xhr){
			alert("상태 : " + xhr.status)
		}
			
	})
}

replySaveServer = function(but){
	
	$.ajax({
		url : '/board/InsertReply.do',
		type: 'post',
		data : board , //board객체 -bonum, name, cont
		dataType : 'json',
		success : function(res){
			//alert(res.sw);
			
			//댓글 등록 후 출력 
			replyListServer(but)
			
			
		},
		error :  function(xhr){
			alert("상태 : " + xhr.status)
		}
	})
}

//등록 버튼 클릭 . 제목클릭 할때 
replyListServer = function(but){
	
	$.ajax({
		url : '/board/ListReply.do',
		data : {'bonum' : vidx},
		success : function(res){
			//alert("성공");
			recode= "";
			
			$.each(res, function(i, v){
				recode += '  <div class="panel-body rep">';
				recode += '      <p class="p1">';
				recode +=           v.name  + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				recode +=           v.redate  + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				recode += '    <br><br><span class="cont">' + v.cont +'</span>';			
				recode += '      </p>';
				recode += '      <p class="p2">';
				recode += '          <button id="rmodi" idx="' + v.renum + '" type="button" name="r_modify" class="action">댓글수정 </button>';
				recode += '          <button idx="' + v.renum + '" type="button" name="r_delete" class="action">댓글삭제 </button>';
				recode += '      </p>';
				recode += '   </div>';
			})
			$(but).parents('.panel').find('.pbody').find('.rep').remove();
			$(but).parents('.panel').find('.pbody').append(recode);
			
			
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : 'json'
	})
}

readHitServer = function(list){
	
	$.ajax({
		url : '/board/UpdateHit.do',
		data : {"num" : vidx},
		success : function(res){
			//alert(res.sw);
			parent = $(list).parents(".panel");
			hit =  parseInt( $(parent).find('.wh').text());
			
			console.log("hit=" + hit);
			
			$(parent).find('.wh').text(++hit);
			
		},
		error : function(xhr){
			
		},
		dataType : 'json'
		
	})
	
}

updateBoard = function(){
	
	$.ajax({
		url : '/board/UpdateBoard.do',
		data : $('#mform').serializeJSON(),
		method : 'post',
		dataType : 'json',
		success : function(res){
			//alert(res.sw);
		
			//화면에서 수정한 값 출력-
			//제목
			$(parent).find('a').text($('#mform #subject').val());
			//메일
			$(parent).find('.wm').text($('#mform #mail').val());
			
			//내용
			cont = $('#mform #content').val();
			cont = cont.replace(/\r/g, "").replace(/\n/g,"<br>");
			
			$(parent).find(".wc").html(cont);
			
			//모달창닫기
			$('#modiModal').modal("hide");
			$('#mform .txt').val("");
			
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}
	})
}


deleteBoard = function(btn){
	
	$.get(
			'/board/DeleteBoard.do',
			{"num" : vidx},
			function(res){
				//alert(res.sw);
				//화면에서 리스트 삭제 
				//$(btn).parents('.panel').remove();
				readPageServer(currentPage);
			},
			'json'	
	)
}


insertBoard = function(){
	$.post(
			'/board/Insert.do',	
			$('#wform').serializeJSON(),
			function(res){
				//alert(res.sw);
				$('#writeModal').modal('hide');
				$('.txt').val("");
				readPageServer(1);
			},
			'json'
			
	)
}



readPageServer = function(cpage){
	
	$.ajax({
		url : '/board/List.do',
		type : 'post',
		data : {'cpage' : cpage },
		success : function(res){
						
			code = '<div class="panel-group" id="accordion">';
			$.each(res.datas, function(i, v){
				code += '<div class="panel panel-default">';
				code += '  <div class="panel-heading">';
				code += '   <h4 class="panel-title">';
				code += '      <a  idx="' + v.num +'" name="list" class="action" data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.num + '">' + v.subject + '</a>';
				code += '    </h4>';
				code += '  </div>';
				code += ' <div id="collapse' + v.num + '" class="panel-collapse collapse">';
				code += '    <div class="panel-body pbody">';
				code += '      <p class="p1">';
				code += '          작성자  :<span class="wr">' +  v.writer  + '</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '          이메일 :<span class="wm">' + v.mail + '</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '          작성일 : <span class="wd">' +  v.date  + '</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '          조회수 : <span class="wh">' + v.hit  + '</span>';
				code += '      </p>';
				code += '      <p class="p2">';
				code += '          <button idx="' + v.num + '" type="button" name="modify" class="action">수정 </button>';
				code += '          <button idx="' + v.num + '" type="button" name="delete" class="action">삭제 </button>';
				code += '      </p>';
				code += '      <p class="p3">';
				code += '         <span class="wc">' +  v.cont + '</span>' ;
				code += '      </p>';
				code += '      <p class="p4">';
				code += '          <textarea cols="60"></textarea>';
				code += '          <button  idx="' +v.num + '" type="button" name="reply" class="action">등록</button>';
				code += '      </p>';
				code += '   </div>';
				code += ' </div>';
				code += '</div>';
			})
			
			code += "</div>";
			
			$('.box').html(code);
			
			//이전버튼 출력- 1보다 클때만  
			$('#pagelist').empty();
			if(res.startp >1 ){
				
			  pager= '<ul class="pul pager">';
			  pager+='  <li><a class="prev" href="#">Previous</a></li>';
			  pager+='</ul>';
			
			  $('#pagelist').append(pager);
			}
			//페이지번호 출력
			pager = '<ul class="pul pagination pager">';
			for(i=res.startp; i<=res.endp; i++){
				
				if(currentPage == i){
				  pager +='<li class="active"><a  class="paging" href="#">' + i + '</a></li>';
				}else {
				  pager +='<li><a  class="paging" href="#">' + i + '</a></li>';
				}
			}
			pager += '</ul>';
			$('#pagelist').append(pager);
			
			//다음버튼 출력 
			if(res.endp < res.totalp){
				  pager= '<ul class="pager">';
				  pager+='  <li><a class="next" href="#">Next</a></li>';
				  pager+='</ul>';
				
				  $('#pagelist').append(pager);
			}
			
			
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}

readServer = function(){
	
	$.ajax({
		url : '/board/List.do',
		type : 'get',
		success : function(res){
			code = '<div class="panel-group" id="accordion">';
			$.each(res, function(i, v){
				code += '<div class="panel panel-default">';
				code += '  <div class="panel-heading">';
				code += '   <h4 class="panel-title">';
				code += '      <a data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.num + '">' + v.subject + '</a>';
				code += '    </h4>';
				code += '  </div>';
				code += ' <div id="collapse' + v.num + '" class="panel-collapse collapse">';
				code += '    <div class="panel-body">';
				code += '      <p class="p1">';
				code += '                 작성자  : ' +  v.writer  + ' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '                이메일 : ' + v.mail + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '                 작성일 :' +  v.date  + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '                 조회수 :' + 0 ;
				code += '     </p>';
				code += '      <p class="p2">';
				code += '          <button type="button" name="modify" class="action">수정 </button>';
				code += '          <button type="button" name="delete" class="action">삭제 </button>';
				code += '      </p>';
				code += '      <p class="p3">';
				code +=             v.cont ;
				code += '      </p>';
				code += '      <p class="p4">';
				code += '          <textarea cols="60"></textarea>';
				code += '          <button type="button" name="reply" class="action">등록</button>';
				code += '      </p>';
				code += '   </div>';
				code += ' </div>';
				code += '</div>';
			})
			
			code += "</div>";
			
			$('.box').html(code);
			
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
		
		
	})
}